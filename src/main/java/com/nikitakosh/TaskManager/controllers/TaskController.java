package com.nikitakosh.TaskManager.controllers;

import com.nikitakosh.TaskManager.models.Task;
import com.nikitakosh.TaskManager.services.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping("/tasks")
    public String findAll(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        return "allTasks";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") int id, Model model) {
        model.addAttribute("task", taskService.findById(id));
        return "task";
    }

    @GetMapping("/createTask")
    public String create(Model model) {
        model.addAttribute("task", new Task());
        return "createTask";
    }

    @PostMapping("/saveTask")
    public String save(@ModelAttribute("task") Task task) {
        taskService.save(task);
        return "redirect:/tasks";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("task", taskService.findById(id));
        return "updateTask";
    }

    @PostMapping("/{id}/editTask")
    public String edit(@ModelAttribute("task") Task task, @PathVariable("id") int id) {
        taskService.update(id, task);
        return "redirect:/tasks";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        taskService.delete(id);
        return "redirect:/tasks";
    }
}
