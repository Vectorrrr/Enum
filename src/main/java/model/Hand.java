package model;

import java.util.*;

/**
 * Created by CraZy_IVAN on 10.03.16.
 */
public class Hand {
    private List<Card> cards = new ArrayList();
    private int maxSizeHand;


    public Hand(int maxSizeHand) {
        this.maxSizeHand = maxSizeHand;
    }

    public void addCard(Card card) {
        if (cards.size() < maxSizeHand) {
            cards.add(card);
        }
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

    //return main card
    public int maxValuesCard() {
        int maxValue = cards.get(0).getValueCards().getPoints();
        for (Card c : cards) {
            maxValue = Math.max(maxValue, c.getValueCards().getPoints());
        }
        return maxValue;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card c : cards) {
            sb.append(c.toString()).append(" ");
        }
        return sb.toString();
    }
}
