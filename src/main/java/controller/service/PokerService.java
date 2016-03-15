package controller.service;

import model.PokerCombination;
import model.Deck;
import model.Hand;
import model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CraZy_IVAN on 10.03.16.
 */
/**
 * Class can create list hands and find winners from some players
 * */
public class PokerService {
    public static List<Hand> createHandsForPoker(int size) {
        Deck deck = new Deck();
        if (size > 10) {
            throw new IllegalArgumentException();
        }
        List<Hand> hands = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            hands.add(new Hand(5));
        }
        for (int i = 0; i < 5; i++) {
            for (Hand h : hands) {
                h.addCard(deck.getTopCard());
            }
        }
        return hands;
    }


    public static List<User> getWinner(List<User> users) {
        if (users.size() == 0) {
            return users;
        }
        List<User> winners = new ArrayList<>();
        winners.add(users.get(0));
        for (int i = 1; i < users.size(); ++i) {
            User us = users.get(i);
            int comp = PokerCombination.compareHand(winners.get(0).getHand(), us.getHand());
            if (comp == 0) {
                winners.add(us);
            } else if (comp == -1) {
                winners.clear();
                winners.add(us);
            }
        }
        return winners;
    }


}
