package controller;

import controller.service.GameService;

import java.util.Scanner;

/**
 * Created by CraZy_IVAN on 12.03.16.
 */

public class Controller {
    private Scanner sc = new Scanner(System.in);
    private GameService gameService = new GameService();

    public void run() {
        String userAnswer;
        while (true) {
            System.out.println("\n\nIf you want add new user type 1");
            System.out.println("If you want conduct next round type 2");
            System.out.println("If you want exit type 0");
            userAnswer = sc.nextLine();
            switch (userAnswer) {
                case "1":
                    gameService.addNewUser();
                    break;
                case "2":
                    gameService.nextRound();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("You input incorrect string");
            }

        }
    }
}
