package model;

import java.util.*;

/**
 * Created by CraZy_IVAN on 10.03.16.
 */
public class Deck {
    private static final String EXCEPTION_EMPTY_DECK="You want take card but deck is empty";
    private ArrayList<Card> deck = new ArrayList<>();

    public Deck() {
        for (Suit suitCards : Suit.values()) {
            for (Value valueCards : Value.values()) {
                deck.add(new Card(suitCards, valueCards));
            }
        }
        Collections.shuffle(deck);
    }

    public Card getTopCard() {
        if (deck.size() > 0) {
            int indLast = deck.size() - 1;
            Card c = deck.get(indLast);
            deck.remove(indLast);
            return c;
        }
        throw new IllegalStateException(EXCEPTION_EMPTY_DECK);

    }
}
