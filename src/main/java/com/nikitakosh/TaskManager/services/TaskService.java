package com.nikitakosh.TaskManager.services;

import com.nikitakosh.TaskManager.appuser.AppUser;
import com.nikitakosh.TaskManager.enums.PriorityComparator;
import com.nikitakosh.TaskManager.exceptions.NoSuchTaskException;
import com.nikitakosh.TaskManager.models.Task;
import com.nikitakosh.TaskManager.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Transactional(readOnly = true)
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Task> findAllUserTasksSortByPriority() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser user = (AppUser) authentication.getPrincipal();
        return findAll().stream()
                .filter(task -> Objects.equals(task.getAppUser().getId(), user.getId()))
                .sorted(Comparator.comparing(Task::getPriority, new PriorityComparator()))
                .toList();
    }

    @Transactional(readOnly = true)
    public Task findById(int id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new NoSuchTaskException("could not find task by id"));
    }

    @Transactional
    public void save(Task task) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AppUser user = (AppUser) authentication.getPrincipal();
        task.setAppUser(user);
        taskRepository.save(task);
    }

    @Transactional
    public void update(Integer id, Task task) {
        Task oldTask = findById(id);
        oldTask.setTitle(task.getTitle());
        oldTask.setDescription(task.getDescription());
        oldTask.setPriority(task.getPriority());
        oldTask.setDeadline(task.getDeadline());
    }

    @Transactional
    public void delete(Integer id) {
        taskRepository.deleteById(id);
    }
}
