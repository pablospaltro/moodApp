package entities;

import services.MoodAction;
import services.ToDoListService;

public class Focus extends Mood implements MoodAction {


    public Focus() {
        super();
    }

    @Override
    public void executeAction() {
        System.out.println("\n- OK, let's focus.");
        ToDoListService toDo = new ToDoListService();
        toDo.tasksMenu();
    }
}
