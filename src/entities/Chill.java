package entities;

import services.CoffeeShopMenu;
import services.MoodActionService;

public class Chill extends Mood implements MoodActionService {
    public Chill() {
        super();
    }


    @Override
    public void executeAction() {

        System.out.println("\nEasy now, let's chill\n");

        CoffeeShopMenu coffeeShop = new CoffeeShopMenu();
        coffeeShop.interactWithCharacters();
    }
}
