package model;

/**
 * Created by CraZy_IVAN on 10.03.16.
 */
public class Card {
    private SuitCards suitCards;
    private ValueCards valueCards;


    public Card(SuitCards suitCards, ValueCards valueCards) {
        this.suitCards = suitCards;
        this.valueCards = valueCards;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Card)) {
            return false;
        }
        Card c = (Card) o;
        return c.getSuitCards().equals(this.suitCards) &&
                c.getValueCards().equals(this.valueCards);
    }

    @Override
    public String toString() {
        return suitCards.toString() + " " + valueCards.toString();
    }

    public SuitCards getSuitCards() {
        return suitCards;
    }

    public ValueCards getValueCards() {
        return valueCards;
    }
}
