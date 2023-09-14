package services;

import entities.ToDoList;
import java.util.Scanner;
import java.util.TreeMap;

public class ToDoListMenu {

    Scanner scanner = new Scanner(System.in);
    ToDoListService listService = new ToDoListService();
    TreeMap<Integer, String> allTasks = new TreeMap<>();
    TreeMap<Integer, String> activeTasks = new TreeMap<>();
    TreeMap<Integer, String> completedTasks = new TreeMap<>();

    ToDoList toDoList = new ToDoList(allTasks, activeTasks, completedTasks);

    public void toDoList(){

        System.out.println("\n| My To-Do List |\n");
        System.out.println(" | ALL");
        listService.displayTasks(allTasks);
        System.out.println(" | ACTIVE");
        listService.displayTasks(activeTasks);
        System.out.println(" | COMPLETED");
        listService.displayTasks(completedTasks);

    }

    public void menuOptions(){

        boolean backToMenu = true;

        do {
            toDoList();
            System.out.println("\n1 | Add task");
            System.out.println("2 | Delete task");
            System.out.println("3 | Update task");
            System.out.println("4 | Mark task as completed");
            System.out.println("0 | Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    listService.addTask(allTasks);
                    break;
                case 2:
                    listService.deleteTask(allTasks);
                    break;
                case 3:
                    listService.updateTask(allTasks);
                    break;
                case 4:
                    listService.markTaskAsCompleted(allTasks);
                    break;
                case 0:
                    System.out.println("Good work, see you next time!");
                    backToMenu = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (backToMenu);
}
}