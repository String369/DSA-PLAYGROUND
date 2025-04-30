package com.code.project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ToDoList {
    // Java 17 Record
    record Task(String title, String description, boolean completed) {}

    private static List<Task> tasks = new ArrayList<>();

    public static void main(String[] args) {
        // Add tasks
        tasks.add(new Task("Learn Java", "Study Java 8 to 21", false));
        tasks.add(new Task("Build Project", "Create a To-Do app", false));

        // Java 8 Stream: List incomplete tasks
        System.out.println("Incomplete Tasks:");
        tasks.stream()
                .filter(task -> !task.completed())
                .forEach(task -> System.out.println());

        // Mark task as completed
        tasks.set(0, new Task(tasks.get(0).title(), tasks.get(0).description(), true));

        // Java 21 Virtual Thread: Save tasks to file
        Thread.startVirtualThread(() -> {
            try {
                // Java 11 String methods
                String content = tasks.stream()
                        .map(task -> "Title: " + task.title() + ", Description: " + task.description() + ", Completed: " + task.completed())
                        .collect(Collectors.joining("\n"));
                Files.writeString(Paths.get("tasks.txt"), content);
                System.out.println("Tasks saved to file");
            } catch (IOException e) {
                System.out.println("Error saving tasks: " + e.getMessage());
            }
        });

        // Java 17 Pattern Matching
        Object task = tasks.get(0);
        if (task instanceof Task t) {
            System.out.println("Task Title: " + t.title());
            System.out.println("Task Description: " + t.description());
            System.out.println("Task Completed: " + t.completed());
        } else {
            System.out.println("Not a task");
        }
    }
}
