package model;

/**
 * Created by CraZy_IVAN on 10.03.16.
 */
/**
 * Contains all value of card from poker game
 * */
public enum Value {
    ACE("Ace", 1,1),
    TWO("Two", 2,2),
    THREE("Three", 3,3),
    FOUR("Four", 4,4),
    FIVE("Five", 5,5),
    SIX("Six", 6,6),
    SEVEN("Seven", 7,7),
    EIGHT("Eight", 8,8),
    NINE("Nine", 9,9),
    TEN("Ten", 10,10),
    JACK("Jack", 10,11),
    QUEEN("Queen", 10,12),
    KING("King", 10,13);

    private int sequenceNumber;
    private int points;
    private String sing;

    public int getPoints() {
        return points;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    Value(String sing, int points,int sequenceNumber) {
        this.sing = sing;
        this.points = points;
        this.sequenceNumber=sequenceNumber;
    }

    @Override
    public String toString() {
        return this.sing;
    }
}
