package com.nikitakosh.TaskManager.models;

import com.nikitakosh.TaskManager.enums.Priority;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @Column(name = "deadline")
    private LocalDateTime deadline;

    public Task(String title, String description, Priority priority, LocalDateTime deadline) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.deadline = deadline;
    }

    public Task() {

    }
}
