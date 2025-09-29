import java.util.ArrayList;

public class Dealer extends Hand implements Role{

    private String name;
    private double balance;
    
    public Dealer(String name){
        this.name = name;
        this.balance = 0;
        ArrayList<Card> hand = new ArrayList<>();
     }

     //get dealer's name 
     public String getName(){
        return name;
    }
  
    //get hand
    public ArrayList<Card> getHand(){
        return hand;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public double getBalance(){
        return balance;
    }
}
