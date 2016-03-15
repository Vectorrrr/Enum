package model;


import java.util.*;

/**
 * Created by CraZy_IVAN on 10.03.16.
 */
/**
 * This class consist all combination for poker
 * every combination contains two attribute
 * name and point value
 * */
public enum PokerCombination {
    HIGH_HAND("High Hand", 0) ,
    ONE_PAIR("Pair", 100) ,
    TWO_PAIR("Two Pair", 200) ,
    THREE_OF_A_KIND("Three of a kind", 300) ,
    STRAIGHT("Straight", 400) ,
    FLUSH("Flush", 500),
    FULL_HOUSE("Full House", 600) ,
    FOUR_OF_A_KIND("Four of a kind", 700) ,
    STRAIGHT_FLUSH("Straight Flush", 800) {};

    private int point;
    private String name;


    PokerCombination(String name, int point) {
        this.name = name;
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public String getName() {
        return name;
    }

    /**
     * @author
     * Method return the High combinate that consist Hand
     * this method have next algorithm
     * the first part we calc mutually equal value cards
     * if this value equals
     *  one hand contains only one pair
     *  two hand contains two pair
     *  four hand contains three of a kind
     *  five hand contains full house
     *  six hand contains four of a kind
     *  if none of these
     *  we check flush and straight flush
     *  if this not a flush or straight or straight flush is Head Card
     * */
    public static PokerCombination getMaxCombination(Hand h){
       int sum=0;
       List<Card> cards =h.getCards();
       int countCards=cards.size();
       for(int i=0;i<countCards;++i){
           for(int j=i+1;j<countCards;++j){
               if(cards.get(i).getValue().equals(cards.get(j).getValue())){
                   sum++;
               }
           }
       }
       switch (sum){
           case 1:
               return ONE_PAIR;
           case 2:
               return TWO_PAIR;
           case 3:
               return THREE_OF_A_KIND;
           case 4:
               return FULL_HOUSE;
           case 6:
               return FOUR_OF_A_KIND;
       }
       boolean isFlush=true;
       boolean isStraight=true;
       for(Card c:cards){
           if(!c.getSuit().equals(cards.get(0).getSuit())){
               isFlush=false;
               break;
           }
       }

       List<Integer> values=new ArrayList<>();
       for(Card c:cards){
            values.add(c.getValue().getSequenceNumber());
       }
       Collections.sort(values);

        for(int i=1;i<values.size();++i){
            if(values.get(i)-values.get(i-1)>1){
                isStraight=false;
                break;
            }
        }
       if(isFlush && isStraight){
           return STRAIGHT_FLUSH;
       }
       if(isFlush){
           return FLUSH;
       }
       if(isStraight){
           return STRAIGHT;
       }
        return HIGH_HAND;
   }

    /**
     * If first hand more return 1
     * if second return -1
     * else return 0
     * */
    public static int compareHand(Hand h1,Hand h2){
        PokerCombination pc1=getMaxCombination(h1);
        PokerCombination pc2=getMaxCombination(h2);
        if(pc1.getPoint()>pc2.getPoint()){
            return 1;
        }else if(pc1.getPoint()<pc2.getPoint()){
            return -1;
        }

        if(pc1.equals(FLUSH)||pc1.equals(STRAIGHT_FLUSH)){
            return h1.maxValuesCard().compareTo(h2.maxValuesCard());
        }
        int listSeq1[]=getListSequence(h1);
        int listSeq2[]=getListSequence(h2);

        for(int i=4;i>0;--i){
            for(int j=13;j>0;--j){
                if( listSeq1[j]==i && listSeq2[j]!=i){
                    return 1;
                }else if(listSeq2[j]==i && listSeq1[j]!=i){
                    return -1;
                }

            }
        }
    return 0;
  }

    //todo this good practice
    private static int[] getListSequence(Hand h){
        int[] answer=new int[14];
        for(Card c:h.getCards()){
            answer[c.getValue().getSequenceNumber()]++;
        }
        return answer;

    }

}
