import java.util.*;

public class Player extends Hand implements Role{

    private String name;
    private double balance;
    private double bet;
    public Scanner input;

    public Player(String name,double balance,double bet){
       this.name = name;
       this.balance = balance;
       this.bet = bet;
       ArrayList<Card> hand = new ArrayList<>();
       this.input = new Scanner(System.in);
    }

    //allow players to set bet (if bet is bigger than balance, error.)
    public void setBet(double addedBet){
        if (bet <= balance) {
            bet += addedBet;
            balance -= addedBet;
        }
        else{
            System.out.println("Sorry, you don't have enough money.");
        }
       
    }

    //get players' names
    public String getName(){
        return name;
    }

    //calculate players' balance if they win
    public double calculateBalance(double bet1,double bet2,double bet3){
        balance = bet1 + bet2 + bet3 + balance;
        return balance;
    }

    //get players' balance
    public double getBalance(){
        return balance;
    }

    //get players' bet
    public double getBet(){
        return bet;
    }

    //ask players whether to hit or pass
    public boolean move(Scanner input){
        System.out.println(getName() + " ,Hit or Pass(answer true or false): ");
        if(input.hasNextBoolean()){
            boolean move = input.nextBoolean();
            return move;
        }
        return false;
    }

    //get hand
    public ArrayList<Card> getHand(){
        return hand;
    }
}