package entities;

import pong.game.GameFrame;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Pong {

    Scanner scanner = new Scanner(System.in);

    public void startPongGame() {
        String option = null;
        do {
            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() throws Exception {
                    GameFrame gameFrame = new GameFrame();
                    gameFrame.setVisible(true);

                    gameFrame.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent e) {
                            // En lugar de detener la ejecución, oculta la ventana del juego
                            gameFrame.setVisible(false);
                        }
                    });

                    return null;
                }
            };

            worker.execute(); // Ejecutar el juego en segundo plano

            System.out.println("Enter Y to get back to the CoffeeShop options");
            option = scanner.nextLine();

            // Esperar a que termine la ejecución del juego en segundo plano
            try {
                worker.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }

        } while (!option.equalsIgnoreCase("Y"));
    }


}


