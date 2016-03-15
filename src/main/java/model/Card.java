package model;

/**
 * Created by CraZy_IVAN on 10.03.16.
 */
/**
 * Class Card modeling card for poker
 * contains two field suit and value
 * */
public class Card implements Comparable<Card> {
    private final Suit suit;
    private final Value value;


    public Card(Suit suitCards, Value valueCards) {
        this.suit = suitCards;
        this.value = valueCards;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Card)) {
            return false;
        }
        Card c = (Card) o;
        return c.getSuit().equals(this.suit) &&
                c.getValue().equals(this.value);
    }

    @Override
    public String toString() {
        return suit.toString() + " " + value.toString();
    }

    @Override
    public int compareTo(Card card) {
        int cardNumber=card.getValue().getSequenceNumber();
        int thisNumber=this.getValue().getSequenceNumber();

        if(cardNumber>thisNumber){
            return 1;
        }else if(cardNumber<thisNumber){
            return -1;
        }else {
            return 0;
        }

    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

}
