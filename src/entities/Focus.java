package entities;

import services.MoodActionService;
import services.ToDoListService;

public class Focus extends Mood implements MoodActionService {


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
