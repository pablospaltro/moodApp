package entities;

import services.MoodActionService;

public class Chill extends Mood implements MoodActionService {
    public Chill() {
        super();
    }

    @Override
    public void executeAction() {
        System.out.println("\n(・ω<)");
        System.out.println("- The CoffeeShop is coming soon...\n- Chill.");
    }
}
