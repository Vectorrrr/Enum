package model;

/**
 * Created by CraZy_IVAN on 10.03.16.
 */
/**
 * Enum consist all suit for card
 * */
public enum Suit {
    Diamonds("Diamonds"), Clubs("Clubs"), Spades("Spades"), Hearts("Hearts");

    private final String suit;

    Suit(String suit) {
        this.suit = suit;
    }


    @Override
    public String toString() {
        return suit;
    }
}
