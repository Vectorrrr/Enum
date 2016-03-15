package model;

/**
 * Created by CraZy_IVAN on 12.03.16.
 */
/**
 * Class simulates player in poker game
 * */
public class User {
    private final String name;
    private Hand hand;
    private int wins;


    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name:\t" + name + "   wins\t" + wins + " " + hand.toString();
    }

    public String getName() {
        return name;
    }

    public void addWins() {
        wins++;
    }

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

}
