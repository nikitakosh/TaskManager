package com.nikitakosh.TaskManager.models;

import com.nikitakosh.TaskManager.appuser.AppUser;
import com.nikitakosh.TaskManager.enums.Priority;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@Entity
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

    @ManyToOne()
    @JoinColumn(
            nullable = false,
            name = "app_user_id"
    )
    private AppUser appUser;

    public Task(String title, String description, Priority priority, LocalDateTime deadline, AppUser appUser) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.deadline = deadline;
        this.appUser = appUser;
    }
}
