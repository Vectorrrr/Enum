package model;

/**
 * Created by CraZy_IVAN on 10.03.16.
 */
public enum ValueCards {
    ACE("Ace", 1),
    TWO("Two", 2),
    THREE("Three", 3),
    FOUR("Four", 4),
    FIVE("Five", 5),
    SIX("Six", 6),
    SEVEN("Seven", 7),
    EIGHT("Eight", 8),
    NINE("Nine", 9),
    TEN("Ten", 10),
    JACK("Jack", 10),
    QUEEN("Queen", 10),
    KING("King", 10);

    private int points;
    private String sing;

    public int getPoints() {
        return points;
    }

    ValueCards(String sing, int points) {
        this.sing = sing;
        this.points = points;
    }

    @Override
    public String toString() {
        return this.sing;
    }

}
