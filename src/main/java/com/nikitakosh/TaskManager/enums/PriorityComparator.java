package com.nikitakosh.TaskManager.enums;

import java.util.Comparator;

public class PriorityComparator implements Comparator<Priority> {
    @Override
    public int compare(Priority o1, Priority o2) {
        return o1.getSeverity() - o2.getSeverity();
    }
}
