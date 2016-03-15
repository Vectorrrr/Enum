package controller.service;

import model.Hand;
import model.PokerCombination;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by CraZy_IVAN on 12.03.16.
 */
/**
 * Class can add user in game and
 * class can carry out one round of game
 * */
public class GameService {
    private final static String EXIST_FREE_PLACE = "I can't add user because all place occupied";
    private final static String SEPARATOR_ROUNDS = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
    private Scanner sc = new Scanner(System.in);

    private List<User> users = new ArrayList<>();
    private int round = 1;


    public void addNewUser() {
        if (users.size() < 10) {
            System.out.println("Input user name");
            String name = sc.nextLine();
            users.add(new User(name));
        } else {
            System.out.println(EXIST_FREE_PLACE);
        }
    }

    public void nextRound() {
        System.out.println(SEPARATOR_ROUNDS);
        System.out.println("\n\n\nRound number: " + round++);
        List<Hand> hands = PokerService.createHandsForPoker(users.size());
        for (int i = 0; i < users.size(); ++i) {
            users.get(i).setHand(hands.get(i));
        }
        List<User> winners = PokerService.getWinner(users);
        for (User u : winners) {
            u.addWins();
            System.out.println(u);
        }
        System.out.println("Winners combination " + PokerCombination.getMaxCombination(winners.get(0).getHand()));
    }

}
