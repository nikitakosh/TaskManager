package com.nikitakosh.TaskManager.enums;


import lombok.Getter;

@Getter
public enum Priority {
    LOW(0),
    MEDIUM(1),
    HIGH(2),
    CRITICAL(3);

    private final int severity;

    Priority(int severity) {
        this.severity = severity;
    }

}
