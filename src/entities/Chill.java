package entities;

import services.MoodAction;

public class Chill extends Mood implements MoodAction {
    public Chill() {
        super();
    }

    @Override
    public void executeAction() {
        System.out.println("\n(・ω<)");
        System.out.println("- The CoffeeShop is coming soon...\n- Chill.");
    }
}
