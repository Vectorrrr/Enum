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
public class PokerService {
    private static final String ERROR_TYPE_HAND = "I don't know this hand, it's not poker hand";

    public static List<Hand> createHandsForPocker(int size) {
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

    public static PokerCombination getCombination(Hand hand) {
        for (PokerCombination pc : PokerCombination.values()) {
            if (pc.isThisCombination(hand)) {
                return pc;
            }
        }
        throw new IllegalArgumentException(ERROR_TYPE_HAND);
    }

    public static List<User> getWinner(List<User> users) {
        int maxValue = 0;
        List<User> winners = new ArrayList<>();
        for (User user : users) {
            Hand hand = user.getHand();
            int value = getCombination(hand).getPoint() + hand.maxValuesCard();
            if (maxValue < value) {
                winners.clear();
                winners.add(user);
                maxValue = value;
            } else if (maxValue == value) {
                winners.add(user);
            }
        }
        return winners;
    }


}
