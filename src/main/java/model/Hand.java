package model;

import java.util.*;

/**
 * Created by CraZy_IVAN on 10.03.16.
 */
/**
 * Card modeling user's hands from poker game
 * the hand can define the main card in it cards
 * */
public class Hand {
    private final String FULL_HAND_EXCEPTION="You want add card but the hand is full";
    private List<Card> cards = new ArrayList<>();
    private int maxSizeHand;


    public Hand(int maxSizeHand) {
        this.maxSizeHand = maxSizeHand;
    }

    public void addCard(Card card) {
        if (cards.size()+1 > maxSizeHand) {
            throw new IllegalStateException(FULL_HAND_EXCEPTION);
        }
        cards.add(card);
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

    /**return high card*/
    public Card maxValuesCard() {
        Card maxCard = cards.get(0);
        for (Card c : cards) {
            if(maxCard.getValue().getSequenceNumber()<c.getValue().getSequenceNumber()){
                maxCard=c;
            }
        }
        return maxCard;
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
