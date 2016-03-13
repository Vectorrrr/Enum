package model;

import java.util.*;

/**
 * Created by CraZy_IVAN on 10.03.16.
 */
public class Deck {
    private ArrayList<Card> deck = new ArrayList<Card>();

    public Deck() {
        for (SuitCards suitCards : SuitCards.values()) {
            for (ValueCards valueCards : ValueCards.values()) {
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
        throw new IllegalArgumentException();

    }
}
