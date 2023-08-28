package services;

import java.util.Scanner;

public class CoffeeShopMenu {

    Scanner scan = new Scanner(System.in);
    JokesAPI jackTheJoker = new JokesAPI();
    BooksAPI susanTheBookNerd = new BooksAPI();
    public void interactWithCharacters(){

        boolean backToMenu = true;

        System.out.println("Welcome to the COFFEE SHOP");
        System.out.println("You enter the CoffeeShop and there are some characters to interact with: \n");
        System.out.println("KAFI : the owner, who lets you make your own coffee, and learn about its types and varietals.");
        System.out.println("JACK : sitted at the counter, he's the best joker.");
        System.out.println("SUSAN: sitted at a table filled with books, she knows all about them.\n");

        do {
            System.out.println("1 | Kafi, the coffee master");
            System.out.println("2 | Jack, the joker");
            System.out.println("3 | Susan, the books nerd");
            System.out.println("0 | Exit");
            int option = scan.nextInt();
            scan.nextLine();

            switch (option){
                case 1:
                    System.out.println("1 |\n");
                    //kafiTheCoffeeMaker.chattingWithKafi();
                    break;
                case 2:
                    System.out.println("2 |\n");
                    jackTheJoker.chattingWithJack();
                    break;
                case 3:
                    System.out.println("3 |\n");
                    susanTheBookNerd.chattingWithSusan();
                    break;
                case 0:
                    backToMenu = false;
                    System.out.println("Leaving the CoffeeShop...");
                    break;
            }
        } while(backToMenu);

    }


}
