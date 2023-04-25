package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {
    private final HashSet<String> taskSet = new HashSet<>();

    public HashSet<String> extractNumber(List<Task> tasks) {
        for (Task task : tasks) {
            taskSet.add(task.getNumber());
        }
        return taskSet;
    }
}
