package model;

/**
 * Created by CraZy_IVAN on 12.03.16.
 */
public class User {
    private String name;
    private Hand hand;
    private int userId;
    private int wins;


    public User(String name) {
        this.name = name;
    }

    public User(String name, int wins) {
        this(name);
        this.wins = wins;
    }

    public User(String name, int wins, Hand hand) {
        this(name, wins);
        this.hand = hand;
    }

    public void addWins() {
        wins++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    @Override
    public String toString() {
        return "Name:\t" + name + "   wins\t" + wins + " " + hand.toString();
    }
}
