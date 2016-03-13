package model;

/**
 * Created by CraZy_IVAN on 10.03.16.
 */
public enum SuitCards {
    Diamonds("Diamonds"), Clubs("Clubs"), Spades("Spades"), Hearts("Hearts");

    private String suit;

    SuitCards(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return this.suit;
    }

    @Override
    public String toString() {
        return suit;
    }
}
