import controller.service.PokerService;
import model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by igladush on 15.03.16.
 */

public class Tester {

    @Test
    public void testEqualsCombinationTest1(){
        Hand h1=new Hand(5);
        Hand h2=new Hand(5);

        h1.addCard(new Card(Suit.Clubs, Value.ACE));
        h1.addCard(new Card(Suit.Hearts, Value.TWO));
        h1.addCard(new Card(Suit.Diamonds, Value.THREE));
        h1.addCard(new Card(Suit.Spades, Value.FOUR));
        h1.addCard(new Card(Suit.Clubs, Value.FIVE));

        h2.addCard(new Card(Suit.Clubs, Value.ACE));
        h2.addCard(new Card(Suit.Hearts, Value.TWO));
        h2.addCard(new Card(Suit.Diamonds, Value.THREE));
        h2.addCard(new Card(Suit.Spades, Value.FOUR));
        h2.addCard(new Card(Suit.Clubs, Value.FIVE));
        assertEquals(0, PokerCombination.compareHand(h1,h2));
    }
    @Test
    public void testEqualsCombinationTest2(){
        Hand h1=new Hand(5);
        Hand h2=new Hand(5);

        h1.addCard(new Card(Suit.Clubs, Value.ACE));
        h1.addCard(new Card(Suit.Hearts, Value.TWO));
        h1.addCard(new Card(Suit.Spades, Value.TWO));
        h1.addCard(new Card(Suit.Spades, Value.FOUR));
        h1.addCard(new Card(Suit.Clubs, Value.FIVE));

        h2.addCard(new Card(Suit.Clubs, Value.ACE));
        h2.addCard(new Card(Suit.Clubs, Value.TWO));
        h2.addCard(new Card(Suit.Diamonds, Value.TWO));
        h2.addCard(new Card(Suit.Spades, Value.FOUR));
        h2.addCard(new Card(Suit.Clubs, Value.FIVE));
        assertEquals(0, PokerCombination.compareHand(h1,h2));
    }
    @Test
    public void testEqualsCombinationTest3(){
        Hand h1=new Hand(5);
        Hand h2=new Hand(5);

        h1.addCard(new Card(Suit.Clubs, Value.ACE));
        h1.addCard(new Card(Suit.Hearts, Value.TWO));
        h1.addCard(new Card(Suit.Spades, Value.TWO));
        h1.addCard(new Card(Suit.Spades, Value.FIVE));
        h1.addCard(new Card(Suit.Clubs, Value.FIVE));

        h2.addCard(new Card(Suit.Hearts, Value.ACE));
        h2.addCard(new Card(Suit.Clubs, Value.TWO));
        h2.addCard(new Card(Suit.Diamonds, Value.TWO));
        h2.addCard(new Card(Suit.Diamonds, Value.FIVE));
        h2.addCard(new Card(Suit.Hearts, Value.FIVE));
        assertEquals(0, PokerCombination.compareHand(h1,h2));
    }
    @Test
    public void testEqualsCombinationTest4(){
        Hand h1=new Hand(5);
        Hand h2=new Hand(5);

        h1.addCard(new Card(Suit.Clubs, Value.ACE));
        h1.addCard(new Card(Suit.Clubs, Value.TWO));
        h1.addCard(new Card(Suit.Clubs, Value.THREE));
        h1.addCard(new Card(Suit.Clubs, Value.FOUR));
        h1.addCard(new Card(Suit.Clubs, Value.FIVE));

        h2.addCard(new Card(Suit.Hearts, Value.ACE));
        h2.addCard(new Card(Suit.Hearts, Value.TWO));
        h2.addCard(new Card(Suit.Hearts, Value.THREE));
        h2.addCard(new Card(Suit.Hearts, Value.FOUR));
        h2.addCard(new Card(Suit.Hearts, Value.FIVE));
        assertEquals(0, PokerCombination.compareHand(h1,h2));
    }
    @Test
    public void testEqualsCombinationTest5(){
        Hand h1=new Hand(5);
        Hand h2=new Hand(5);

        h1.addCard(new Card(Suit.Clubs, Value.ACE));
        h1.addCard(new Card(Suit.Clubs, Value.TWO));
        h1.addCard(new Card(Suit.Clubs, Value.THREE));
        h1.addCard(new Card(Suit.Hearts, Value.FOUR));
        h1.addCard(new Card(Suit.Clubs, Value.FIVE));

        h2.addCard(new Card(Suit.Hearts, Value.ACE));
        h2.addCard(new Card(Suit.Clubs, Value.TWO));
        h2.addCard(new Card(Suit.Hearts, Value.THREE));
        h2.addCard(new Card(Suit.Hearts, Value.FOUR));
        h2.addCard(new Card(Suit.Hearts, Value.FIVE));
        assertEquals(0, PokerCombination.compareHand(h1,h2));
    }



    @Test
    public void getMaxCombinationTest1(){
        Hand h1=new Hand(5);

        h1.addCard(new Card(Suit.Clubs, Value.ACE));
        h1.addCard(new Card(Suit.Hearts, Value.TWO));
        h1.addCard(new Card(Suit.Clubs, Value.SEVEN));
        h1.addCard(new Card(Suit.Hearts, Value.FOUR));
        h1.addCard(new Card(Suit.Clubs, Value.FIVE));

        assertEquals(PokerCombination.HIGH_HAND, PokerCombination.getMaxCombination(h1));
    }

    @Test
    public void getMaxCombinationTest2(){
        Hand h1=new Hand(5);

        h1.addCard(new Card(Suit.Clubs, Value.ACE));
        h1.addCard(new Card(Suit.Hearts, Value.TWO));
        h1.addCard(new Card(Suit.Clubs, Value.TWO));
        h1.addCard(new Card(Suit.Hearts, Value.FOUR));
        h1.addCard(new Card(Suit.Clubs, Value.FIVE));

        assertEquals(PokerCombination.ONE_PAIR, PokerCombination.getMaxCombination(h1));
    }

    @Test
    public void getMaxCombinationTest3(){
        Hand h1=new Hand(5);

        h1.addCard(new Card(Suit.Clubs, Value.ACE));
        h1.addCard(new Card(Suit.Hearts, Value.TWO));
        h1.addCard(new Card(Suit.Clubs, Value.TWO));
        h1.addCard(new Card(Suit.Clubs, Value.FIVE));
        h1.addCard(new Card(Suit.Diamonds, Value.FIVE));


        assertEquals(PokerCombination.TWO_PAIR, PokerCombination.getMaxCombination(h1));
    }

    @Test
    public void getMaxCombinationTest4(){
        Hand h1=new Hand(5);

        h1.addCard(new Card(Suit.Diamonds, Value.QUEEN));
        h1.addCard(new Card(Suit.Clubs, Value.TWO));
        h1.addCard(new Card(Suit.Clubs, Value.THREE));
        h1.addCard(new Card(Suit.Hearts, Value.QUEEN));
        h1.addCard(new Card(Suit.Clubs, Value.QUEEN));

        assertEquals(PokerCombination.THREE_OF_A_KIND, PokerCombination.getMaxCombination(h1));
    }

    @Test
    public void getMaxCombinationTest5(){
        Hand h1=new Hand(5);

        h1.addCard(new Card(Suit.Clubs, Value.ACE));
        h1.addCard(new Card(Suit.Clubs, Value.TWO));
        h1.addCard(new Card(Suit.Clubs, Value.THREE));
        h1.addCard(new Card(Suit.Hearts, Value.FOUR));
        h1.addCard(new Card(Suit.Clubs, Value.FIVE));

        assertEquals(PokerCombination.STRAIGHT, PokerCombination.getMaxCombination(h1));
    }

    @Test
    public void getMaxCombinationTest6(){
        Hand h1=new Hand(5);

        h1.addCard(new Card(Suit.Clubs, Value.ACE));
        h1.addCard(new Card(Suit.Clubs, Value.KING));
        h1.addCard(new Card(Suit.Clubs, Value.THREE));
        h1.addCard(new Card(Suit.Clubs, Value.EIGHT));
        h1.addCard(new Card(Suit.Clubs, Value.JACK));

        assertEquals(PokerCombination.FLUSH, PokerCombination.getMaxCombination(h1));
    }

    @Test
    public void getMaxCombinationTest7(){
        Hand h1=new Hand(5);

        h1.addCard(new Card(Suit.Hearts, Value.ACE));
        h1.addCard(new Card(Suit.Clubs, Value.ACE));
        h1.addCard(new Card(Suit.Diamonds, Value.ACE));
        h1.addCard(new Card(Suit.Clubs, Value.JACK));
        h1.addCard(new Card(Suit.Spades, Value.JACK));

        assertEquals(PokerCombination.FULL_HOUSE, PokerCombination.getMaxCombination(h1));
    }

    @Test
    public void getMaxCombinationTest8(){
        Hand h1=new Hand(5);

        h1.addCard(new Card(Suit.Clubs, Value.NINE));
        h1.addCard(new Card(Suit.Clubs, Value.NINE));
        h1.addCard(new Card(Suit.Spades, Value.NINE));
        h1.addCard(new Card(Suit.Diamonds, Value.NINE));
        h1.addCard(new Card(Suit.Spades, Value.SIX));

        assertEquals(PokerCombination.FOUR_OF_A_KIND, PokerCombination.getMaxCombination(h1));
    }

    @Test
    public void getMaxCombinationTest9(){
        Hand h1=new Hand(5);

        h1.addCard(new Card(Suit.Clubs, Value.ACE));
        h1.addCard(new Card(Suit.Clubs, Value.TWO));
        h1.addCard(new Card(Suit.Clubs, Value.THREE));
        h1.addCard(new Card(Suit.Clubs, Value.FOUR));
        h1.addCard(new Card(Suit.Clubs, Value.FIVE));

        assertEquals(PokerCombination.STRAIGHT_FLUSH, PokerCombination.getMaxCombination(h1));
    }


    @Test
    public void getMaxHandTest1(){
        Hand h1=new Hand(5);
        Hand h2=new Hand(5);

        h1.addCard(new Card(Suit.Diamonds, Value.THREE));
        h1.addCard(new Card(Suit.Clubs, Value.TWO));
        h1.addCard(new Card(Suit.Clubs, Value.TWO));
        h1.addCard(new Card(Suit.Hearts, Value.QUEEN));
        h1.addCard(new Card(Suit.Clubs, Value.KING));

        h2.addCard(new Card(Suit.Hearts, Value.ACE));
        h2.addCard(new Card(Suit.Clubs, Value.TWO));
        h2.addCard(new Card(Suit.Diamonds, Value.TWO));
        h2.addCard(new Card(Suit.Hearts, Value.QUEEN));
        h2.addCard(new Card(Suit.Spades, Value.KING));
        assertEquals(1, PokerCombination.compareHand(h1,h2));
    }

    @Test
    public void getMaxHandTest2(){
        Hand h1=new Hand(5);
        Hand h2=new Hand(5);

        h1.addCard(new Card(Suit.Diamonds, Value.ACE));
        h1.addCard(new Card(Suit.Clubs, Value.TWO));
        h1.addCard(new Card(Suit.Clubs, Value.TWO));
        h1.addCard(new Card(Suit.Hearts, Value.TWO));
        h1.addCard(new Card(Suit.Clubs, Value.KING));

        h2.addCard(new Card(Suit.Hearts, Value.JACK));
        h2.addCard(new Card(Suit.Clubs, Value.TWO));
        h2.addCard(new Card(Suit.Hearts, Value.TWO));
        h2.addCard(new Card(Suit.Hearts, Value.TWO));
        h2.addCard(new Card(Suit.Hearts, Value.KING));
        assertEquals(-1, PokerCombination.compareHand(h1,h2));
    }
    @Test
    public void getMaxHandTest3(){
        Hand h1=new Hand(5);
        Hand h2=new Hand(5);

        h1.addCard(new Card(Suit.Diamonds, Value.ACE));
        h1.addCard(new Card(Suit.Spades, Value.TWO));
        h1.addCard(new Card(Suit.Clubs, Value.TWO));
        h1.addCard(new Card(Suit.Hearts, Value.TWO));
        h1.addCard(new Card(Suit.Clubs, Value.KING));

        h2.addCard(new Card(Suit.Hearts, Value.ACE));
        h2.addCard(new Card(Suit.Clubs, Value.TWO));
        h2.addCard(new Card(Suit.Diamonds, Value.THREE));
        h2.addCard(new Card(Suit.Spades, Value.FOUR));
        h2.addCard(new Card(Suit.Hearts, Value.FIVE));
        assertEquals(-1, PokerCombination.compareHand(h1,h2));
    }
    @Test
    public void getMaxHandTest4(){
        Hand h1=new Hand(5);
        Hand h2=new Hand(5);

        h1.addCard(new Card(Suit.Clubs, Value.ACE));
        h1.addCard(new Card(Suit.Clubs, Value.JACK));
        h1.addCard(new Card(Suit.Clubs, Value.NINE));
        h1.addCard(new Card(Suit.Clubs, Value.TEN));
        h1.addCard(new Card(Suit.Clubs, Value.KING));

        h2.addCard(new Card(Suit.Hearts, Value.ACE));
        h2.addCard(new Card(Suit.Clubs, Value.TWO));
        h2.addCard(new Card(Suit.Diamonds, Value.THREE));
        h2.addCard(new Card(Suit.Spades, Value.FOUR));
        h2.addCard(new Card(Suit.Hearts, Value.FIVE));
        assertEquals(1, PokerCombination.compareHand(h1,h2));
    }

    @Test
    public void fullHouseTest1(){
        Hand h1=new Hand(5);
        Hand h2=new Hand(5);

        h1.addCard(new Card(Suit.Diamonds, Value.JACK));
        h1.addCard(new Card(Suit.Spades, Value.JACK));
        h1.addCard(new Card(Suit.Clubs, Value.JACK));
        h1.addCard(new Card(Suit.Hearts, Value.TEN));
        h1.addCard(new Card(Suit.Clubs, Value.TEN));

        h2.addCard(new Card(Suit.Hearts, Value.QUEEN));
        h2.addCard(new Card(Suit.Clubs, Value.QUEEN));
        h2.addCard(new Card(Suit.Diamonds, Value.QUEEN));
        h2.addCard(new Card(Suit.Spades, Value.FOUR));
        h2.addCard(new Card(Suit.Diamonds, Value.FOUR));
        assertEquals(-1, PokerCombination.compareHand(h1,h2));
    }
    @Test
    public void twoPairTest1(){
        Hand h1=new Hand(5);
        Hand h2=new Hand(5);

        h1.addCard(new Card(Suit.Diamonds, Value.JACK));
        h1.addCard(new Card(Suit.Spades, Value.JACK));
        h1.addCard(new Card(Suit.Clubs, Value.QUEEN));
        h1.addCard(new Card(Suit.Hearts, Value.TEN));
        h1.addCard(new Card(Suit.Clubs, Value.TEN));

        h2.addCard(new Card(Suit.Hearts, Value.QUEEN));
        h2.addCard(new Card(Suit.Clubs, Value.QUEEN));
        h2.addCard(new Card(Suit.Diamonds, Value.KING));
        h2.addCard(new Card(Suit.Spades, Value.FOUR));
        h2.addCard(new Card(Suit.Diamonds, Value.FOUR));
        assertEquals(-1, PokerCombination.compareHand(h1,h2));
    }
    @Test
    public void twoPairTest2(){
        Hand h1=new Hand(5);
        Hand h2=new Hand(5);

        h1.addCard(new Card(Suit.Diamonds, Value.JACK));
        h1.addCard(new Card(Suit.Spades, Value.JACK));
        h1.addCard(new Card(Suit.Clubs, Value.QUEEN));
        h1.addCard(new Card(Suit.Hearts, Value.TEN));
        h1.addCard(new Card(Suit.Clubs, Value.TEN));

        h2.addCard(new Card(Suit.Hearts, Value.JACK));
        h2.addCard(new Card(Suit.Clubs, Value.JACK));
        h2.addCard(new Card(Suit.Diamonds, Value.KING));
        h2.addCard(new Card(Suit.Spades, Value.FOUR));
        h2.addCard(new Card(Suit.Diamonds, Value.FOUR));
        assertEquals(1, PokerCombination.compareHand(h1,h2));
    }
    @Test
    public void twoPairTest3(){
        Hand h1=new Hand(5);
        Hand h2=new Hand(5);

        h1.addCard(new Card(Suit.Diamonds, Value.JACK));
        h1.addCard(new Card(Suit.Spades, Value.JACK));
        h1.addCard(new Card(Suit.Clubs, Value.QUEEN));
        h1.addCard(new Card(Suit.Hearts, Value.TEN));
        h1.addCard(new Card(Suit.Clubs, Value.TEN));

        h2.addCard(new Card(Suit.Hearts, Value.JACK));
        h2.addCard(new Card(Suit.Clubs, Value.JACK));
        h2.addCard(new Card(Suit.Diamonds, Value.KING));
        h2.addCard(new Card(Suit.Spades, Value.TEN));
        h2.addCard(new Card(Suit.Diamonds, Value.TEN));
        assertEquals(-1, PokerCombination.compareHand(h1,h2));
    }

    @Test
    public void treeCardTest1(){
        Hand h1=new Hand(5);
        Hand h2=new Hand(5);

        h1.addCard(new Card(Suit.Diamonds, Value.JACK));
        h1.addCard(new Card(Suit.Spades, Value.JACK));
        h1.addCard(new Card(Suit.Clubs, Value.JACK));
        h1.addCard(new Card(Suit.Hearts, Value.TEN));
        h1.addCard(new Card(Suit.Clubs, Value.NINE));

        h2.addCard(new Card(Suit.Hearts, Value.QUEEN));
        h2.addCard(new Card(Suit.Clubs, Value.QUEEN));
        h2.addCard(new Card(Suit.Diamonds, Value.QUEEN));
        h2.addCard(new Card(Suit.Spades, Value.ACE));
        h2.addCard(new Card(Suit.Diamonds, Value.TEN));
        assertEquals(-1, PokerCombination.compareHand(h1,h2));
    }

    @Test
    public void headCardTest1(){
        Hand h1=new Hand(5);
        Hand h2=new Hand(5);

        h1.addCard(new Card(Suit.Diamonds, Value.TWO));
        h1.addCard(new Card(Suit.Spades, Value.THREE));
        h1.addCard(new Card(Suit.Clubs, Value.FOUR));
        h1.addCard(new Card(Suit.Hearts, Value.FIVE));
        h1.addCard(new Card(Suit.Clubs, Value.SIX));

        h2.addCard(new Card(Suit.Hearts, Value.THREE));
        h2.addCard(new Card(Suit.Clubs, Value.FOUR));
        h2.addCard(new Card(Suit.Diamonds, Value.FIVE));
        h2.addCard(new Card(Suit.Spades, Value.SIX));
        h2.addCard(new Card(Suit.Diamonds, Value.ACE));

        assertEquals(1, PokerCombination.compareHand(h1,h2));
    }

    @Test
    public void headCardTest2(){
        Hand h1=new Hand(5);
        Hand h2=new Hand(5);

        h1.addCard(new Card(Suit.Diamonds, Value.TEN));
        h1.addCard(new Card(Suit.Spades, Value.THREE));
        h1.addCard(new Card(Suit.Clubs, Value.ACE));
        h1.addCard(new Card(Suit.Hearts, Value.JACK));
        h1.addCard(new Card(Suit.Clubs, Value.SIX));

        h2.addCard(new Card(Suit.Hearts, Value.FOUR));
        h2.addCard(new Card(Suit.Clubs, Value.JACK));
        h2.addCard(new Card(Suit.Diamonds, Value.TEN));
        h2.addCard(new Card(Suit.Spades, Value.SIX));
        h2.addCard(new Card(Suit.Diamonds, Value.ACE));

        assertEquals(-1, PokerCombination.compareHand(h1,h2));
    }

    @Test(expected=IllegalStateException.class)
    public void emptyDeckTest1(){
        Deck d=new Deck();
        for(int i=0;i<56;++i){
            d.getTopCard();
        }
    }

    @Test(expected = IllegalStateException.class)
    public void fullHandTest1(){
        Hand h1=new Hand(5);
        h1.addCard(new Card(Suit.Diamonds, Value.JACK));
        h1.addCard(new Card(Suit.Spades, Value.TWO));
        h1.addCard(new Card(Suit.Clubs, Value.TEN));
        h1.addCard(new Card(Suit.Diamonds, Value.QUEEN));
        h1.addCard(new Card(Suit.Hearts, Value.TEN));
        h1.addCard(new Card(Suit.Hearts, Value.KING));
    }

    @Test
    public void getWinnerTwoUserTest1(){
        User user1=new User("Vanya");
        User user2=new User("A13");
        Hand h1 = new Hand(5);
        h1.addCard(new Card(Suit.Hearts, Value.KING));
        h1.addCard(new Card(Suit.Hearts, Value.EIGHT));
        h1.addCard(new Card(Suit.Spades, Value.EIGHT));
        h1.addCard(new Card(Suit.Clubs, Value.TWO));
        h1.addCard(new Card(Suit.Spades, Value.FIVE));

        Hand h2 = new Hand(5);
        h2.addCard(new Card(Suit.Hearts, Value.FOUR));
        h2.addCard(new Card(Suit.Hearts, Value.QUEEN));
        h2.addCard(new Card(Suit.Spades, Value.NINE));
        h2.addCard(new Card(Suit.Hearts, Value.JACK));
        h2.addCard(new Card(Suit.Clubs, Value.KING));

        user1.setHand(h1);
        user2.setHand(h2);
        List<User> us=new ArrayList<>();
        us.add(user1);
        us.add(user2);
        List<User> l= PokerService.getWinner(us);

        assertEquals(1,l.size());
        assertEquals("Vanya",l.get(0).getName());
    }

    @Test
    public void getWinnerTwoUserTest2(){
        User user1=new User("Vanya");
        User user2=new User("A13");
        Hand h1 = new Hand(5);
        h1.addCard(new Card(Suit.Hearts, Value.THREE));
        h1.addCard(new Card(Suit.Spades, Value.THREE));
        h1.addCard(new Card(Suit.Hearts, Value.THREE));
        h1.addCard(new Card(Suit.Clubs, Value.TWO));
        h1.addCard(new Card(Suit.Diamonds, Value.FOUR));
        Hand h2 = new Hand(5);
        h2.addCard(new Card(Suit.Diamonds, Value.JACK));
        h2.addCard(new Card(Suit.Spades, Value.FOUR));
        h2.addCard(new Card(Suit.Hearts, Value.FOUR));
        h2.addCard(new Card(Suit.Clubs, Value.FOUR));
        h2.addCard(new Card(Suit.Diamonds, Value.QUEEN));

        user1.setHand(h1);
        user2.setHand(h2);
        List<User> us=new ArrayList<>();
        us.add(user1);
        us.add(user2);
        List<User> l= PokerService.getWinner(us);

        assertEquals(1,l.size());
        assertEquals("A13",l.get(0).getName());
    }

    @Test
    public void getWinnerTwoUserTest3(){
        User user1=new User("Vanya");
        User user2=new User("A13");
        Hand h1 = new Hand(5);
        h1.addCard(new Card(Suit.Hearts, Value.QUEEN));
        h1.addCard(new Card(Suit.Spades, Value.FOUR));
        h1.addCard(new Card(Suit.Hearts, Value.TWO));
        h1.addCard(new Card(Suit.Clubs, Value.TWO));
        h1.addCard(new Card(Suit.Diamonds, Value.FIVE));
        Hand h2 = new Hand(5);
        h2.addCard(new Card(Suit.Diamonds, Value.TWO));
        h2.addCard(new Card(Suit.Spades, Value.TWO));
        h2.addCard(new Card(Suit.Hearts, Value.FOUR));
        h2.addCard(new Card(Suit.Clubs, Value.FIVE));
        h2.addCard(new Card(Suit.Diamonds, Value.QUEEN));

        user1.setHand(h1);
        user2.setHand(h2);
        List<User> us=new ArrayList<>();
        us.add(user1);
        us.add(user2);
        List<User> l= PokerService.getWinner(us);

        assertEquals(2,l.size());
        assertEquals("Vanya",l.get(0).getName());
        assertEquals("A13",l.get(1).getName());
    }


}
