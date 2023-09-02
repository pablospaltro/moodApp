package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class ToDoList {
    private TreeMap<Integer, String> allTasks;
    private TreeMap<Integer, String> activeTasks;
    private TreeMap<Integer, String> completedTasks;

    public ToDoList(TreeMap<Integer, String> allTasks, TreeMap<Integer, String> activeTasks, TreeMap<Integer, String> completedTasks) {
        this.allTasks = new TreeMap<>();
        this.activeTasks = new TreeMap<>();
        this.completedTasks = new TreeMap<>();
    }

    public TreeMap<Integer, String> getAllTasks() {
        return allTasks;
    }

    public void setAllTasks(TreeMap<Integer, String> allTasks) {
        this.allTasks = allTasks;
    }

    public TreeMap<Integer, String> getActiveTasks() {
        return activeTasks;
    }

    public void setActiveTasks(TreeMap<Integer, String> activeTasks) {
        this.activeTasks = activeTasks;
    }

    public TreeMap<Integer, String> getCompletedTasks() {
        return completedTasks;
    }

    public void setCompletedTasks(TreeMap<Integer, String> completedTasks) {
        this.completedTasks = completedTasks;
    }
}
