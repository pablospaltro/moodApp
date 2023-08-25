package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoList {
    private List<String> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public void deleteTask(int i) {
        if (i >= 0 && i < tasks.size()) {
            tasks.remove(i+1);
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void updateTask(int index, String updatedTask) {
        if (index >= 0 && index < tasks.size()) {
            tasks.set((index+1), updatedTask);
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            String task = tasks.get(index+1);
            tasks.set((index+1), "✔ " + task);
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void displayTasks() {
        System.out.println("Task List:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i+1) + ". " + tasks.get(i+1));
        }
    }
}
