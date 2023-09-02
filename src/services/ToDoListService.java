package services;

import entities.ToDoList;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ToDoListService {

    Scanner scanner = new Scanner(System.in);
    public void displayTasks(TreeMap <Integer, String> tasks) {

        for (Map.Entry<Integer, String> task: tasks.entrySet()) {
            Integer key;
            if (task.getKey() == 0) {
                System.out.println("No tasks yet");
            } else {
                key = task.getKey();
                String value = task.getValue();
                System.out.println(key + "" + value);
            }
        }
    }

    public void addTask(TreeMap<Integer, String> tasks){

        System.out.println("New task description: ");
        String taskDescription = scanner.nextLine();

        int newIndex = tasks.isEmpty() ? 1 : tasks.lastKey() + 1;
        tasks.put(newIndex, taskDescription);
    }

    public void deleteTask(TreeMap<Integer, String> tasks) {

        boolean taskFound = false;

        do {
            System.out.println("Task to delete: ");
            int taskToDelete = scanner.nextInt();
            scanner.nextLine();

            if (tasks.containsKey(taskToDelete)) {
                tasks.remove(taskToDelete);
                System.out.println("Task deleted succesfully.");
                taskFound = true;
            } else {
                System.out.println("Task with key " + taskToDelete + " does not exist.");
            }
        } while (!taskFound);
    }

    public void updateTask(TreeMap<Integer, String> tasks) {

        boolean taskFound = false;

        do {
            System.out.println("Task to update: ");
            int taskToUpdate = scanner.nextInt();
            scanner.nextLine();

            if (tasks.containsKey(taskToUpdate)) {
                System.out.println("Task description: ");
                String updatedTasktDescription = scanner.nextLine();
                tasks.put(taskToUpdate, updatedTasktDescription);
                System.out.println("Task updated succesfully.");
                taskFound = true;
            } else {
                System.out.println("Task with key " + taskToUpdate + " does not exist.");
            }
        } while (!taskFound);

    }

    public void markTaskAsCompleted(TreeMap<Integer, String> tasks) {

        boolean taskFound = false;

        System.out.println("Task to mark as completed: ");
        int taskIndex = scanner.nextInt();
        scanner.nextLine();

        do {
            if (tasks.containsKey(taskIndex)) {
                String task = tasks.get(taskIndex);
                tasks.put(taskIndex, "✔ " + task);
                taskFound = true;
            } else {
                System.out.println("Invalid task index.");
            }
        } while(!taskFound);
    }


}
