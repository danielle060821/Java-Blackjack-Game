import java.util.*;
public class Card {

    private String suit;
    private String shape;
    
    public Card(String suit, String shape){
        this.suit = suit;
        this.shape = shape;
    }


    //randomly deal cards
    public void random(){
        
        String[] allSuit = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] allShapes = {"heart","diamond","spade","club"};
        Random random = new Random();
        this.suit = allSuit[random.nextInt(allSuit.length)];
        this.shape = allShapes[random.nextInt(allShapes.length)];
        
    }


    //set value for each suit.(J,Q,K is 10; A is originally viewed as 11)
    public int determineValue(){
        if (suit.equals("A")) {
            return 11;
        }
        else if(suit.equals("10") || suit.equals("J") || suit.equals("Q") || suit.equals("K")){
            return 10;
        }
        
        else if(suit.equals("2")){
            return 2;
        }
        else if(suit.equals("3")){
            return 3;
        }
        else if(suit.equals("4")){
            return 4;
        }
        else if(suit.equals("5")){
            return 5;
        }
        else if(suit.equals("6")){
            return 6;
        }
        else if(suit.equals("7")){
            return 7;
        }
        else if(suit.equals("8")){
            return 8;
        }
        return 9;
    }

    //get suit
    public String getSuit(){
        return suit;
    }


    //get shape
    public String getShape(){
        return shape;
    }
    
}