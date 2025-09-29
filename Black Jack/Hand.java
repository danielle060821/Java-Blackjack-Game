import java.util.*;
public abstract class Hand {

    //the cards in each player's hand should be private, but we need to use this arraylist in other classes, so we use protected instead.
    protected ArrayList<Card> hand;

    public Hand(){
        hand = new ArrayList<>();
    }

    //add the dealt cards to hand
    public void manageHand(){
       Card card = new Card(null, null);
       card.random();
       hand.add(card);
    }


    //calculate the sum of the cards 
    public int calculateSum(){
        int sum = 0;
        for(int i = 0; i < hand.size(); i++){
            sum += hand.get(i).determineValue();
        }

        //When sum is bigger than 21 and there are "A" cards in the hand, change the value of "A" into 1.
        for(int i = 0; i < hand.size();i++){
            if (sum > 21 && hand.get(i).determineValue() == 11) {
                sum -= 10;
                break;
            }
         }
            return sum;
        }
 
       
    //get hand
    public abstract ArrayList<Card> getHand();
}
