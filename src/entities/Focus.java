package entities;

import services.MoodActionService;
import services.ToDoListMenu;

public class Focus extends Mood implements MoodActionService {


    public Focus() {
        super();
    }

    @Override
    public void executeMoodAction() {
        System.out.println("\n- OK, let's focus.\n");
        ToDoListMenu toDoList = new ToDoListMenu();
        toDoList.toDoListMainMenu();
    }
}
