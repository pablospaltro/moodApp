package services;

import entities.ToDoList;
import java.util.Scanner;
public class ToDoListService {

    public void tasksMenu(){

        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
        System.out.println("\nOptions:");
        System.out.println("1. Add task");
        System.out.println("2. Delete task");
        System.out.println("3. Update task");
        System.out.println("4. Mark task as completed");
        System.out.println("5. Display tasks");
        System.out.println("6. Exit");
        System.out.print("Select an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter the task: ");
                String newTask = scanner.nextLine();
                toDoList.addTask(newTask);
                break;
            case 2:
                System.out.print("Enter the index of the task to delete: ");
                int deleteIndex = scanner.nextInt();
                toDoList.deleteTask(deleteIndex);
                break;
            case 3:
                System.out.print("Enter the index of the task to update: ");
                int updateIndex = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter the new task: ");
                String updatedTask = scanner.nextLine();
                toDoList.updateTask(updateIndex, updatedTask);
                break;
            case 4:
                System.out.print("Enter the index of the task to mark as completed: ");
                int completeIndex = scanner.nextInt();
                toDoList.markTaskAsCompleted(completeIndex);
                break;
            case 5:
                toDoList.displayTasks();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }
}
}