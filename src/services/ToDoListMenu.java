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

    public void toDoListMainMenu(){

        System.out.println("\n| My To-Do List |\n");
        System.out.println(" | All");
        listService.displayTasks(toDoList.getAllTasks());
        System.out.println(" | Active");
        listService.displayTasks(toDoList.getActiveTasks());
        System.out.println(" | Completed");
        listService.displayTasks(toDoList.getCompletedTasks());

        menuOptions();

    }

    public void menuOptions(){

        System.out.println("Select a list: ");
        int selectedList = scanner.nextInt();
        scanner.nextLine();
        boolean backToMenu = true;

        do {
            switch (selectedList) {
                case 1:
                    tasksMenu(allTasks);
                case 0:
                    System.out.println("Good work, see you next time!");
                    backToMenu = false;
                    break;
            }
        } while (backToMenu);
    }

    public void tasksMenu(TreeMap<Integer, String> tasks){

        boolean backToMenu = true;

        do {
            System.out.println("To-Do List: \n");
            System.out.println("1 | Add task");
            System.out.println("2 | Delete task");
            System.out.println("3 | Update task");
            System.out.println("4 | Mark task as completed");
            System.out.println("5 | Display tasks");
            System.out.println("6 | Back to Main Menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    listService.addTask(tasks);
                    break;
                case 2:
                    listService.deleteTask(tasks);
                    break;
                case 3:
                    listService.updateTask(tasks);
                    break;
                case 4:
                    listService.markTaskAsCompleted(tasks);
                    break;
                case 5:
                    listService.displayTasks(tasks);
                    break;
                case 6:
                    backToMenu = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (backToMenu);
}
}