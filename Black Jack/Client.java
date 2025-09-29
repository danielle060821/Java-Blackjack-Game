import java.util.*;
public class Client {
    public static void main(String[] args) {

        //create a scanner for scanning players
        Scanner input = new Scanner(System.in);

        //add players and dealer to the game
        Player player1 = new Player("Kien",50,0);
        Player player2 = new Player("Chiyong",60,0);
        Player player3 = new Player("Danielle",70,0);
        Dealer dealer = new Dealer("Munir");

        //calculate the total bet of players
        double totalBet = 0;
    
        /*create an ArrayList to store all the players, in order to remove them if the sum is bigger than 21.
         (Also make the later code simpler when the game continues and everyone take turns to move)
        */
        ArrayList<Player> players = new ArrayList<>();
        List<Player> toRemove = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);


        //players set bet
        player1.setBet(9);
        player2.setBet(8);
        player3.setBet(6);

        
        //1st round of dealing cards
        for(int i = 0;i < players.size(); i++){
            players.get(i).manageHand();
            System.out.println(players.get(i).getName() + ": " + players.get(i).calculateSum());
        }
       
        
    
    boolean gameContinues = true;
    // when sum of card numbers is smaller than 21, ask players whether to hit or pass. If hit, deal a new card
    //exit the loop when there is only 1 player left
    while(gameContinues == true){
            for(int i = 0; i < players.size(); i++){
                Player p = players.get(i);
                if(p.calculateSum() < 21){
                    System.out.println(p.getName() + "'s turn:");
                    if(p.move(input) == true){
                        p.manageHand();
                        System.out.println(p.getName() + ":" + p.calculateSum());
                        }                     

                    // When the sum is bigger than 21, remove the player from the game.
                    if(p.calculateSum() > 21){
                        System.out.println("Sorry," + p.getName() + " is out.");
                        totalBet += p.getBet();

                        //add the player needed to be removed to a list and remove together to avoid iteration 
                        toRemove.add(p);
                        }
                    
                    //when some player's cards add to 21, end the game(end the whole class: return)
                    if(p.calculateSum() == 21){
                        System.out.println(p.getName() + " wins!");
                        gameContinues = false;
                        return;
                        }
                    
                    //When there is only 1 player left, exist the loop, and go to the next step(only end the loop: break)
                    if(players.size() - toRemove.size() <= 1){
                        gameContinues = false;
                        break;
                    }
                    }
            }    
            //Remove all the players who lost in this round(card number > 21)
            players.removeAll(toRemove);
    }  
    
    //When there is only one player left, deal a new card to the dealer, and reveal the dealer's 1st card and compare the hand with the player.
    if (players.size() == 1) {
        players.get(0).manageHand();

        //deal a new card to the dealer(since the 1st card was hidden, and the card generation is completely random, so we just generate both of the cards at the end)
        dealer.manageHand();
        dealer.manageHand();
        System.out.println("Munir(Dealer): " + dealer.calculateSum());

        //If the dealer's card is bigger, then dealer wins.
        if(dealer.calculateSum() > players.get(0).calculateSum()){
            System.out.println("Munir(Dealer) wins!");
            dealer.setBalance(dealer.getBalance()+totalBet);
        }

        //Otherwise, the last player wins and gains all the bet.
        else{
            players.get(0).calculateBalance(player1.getBet(), player2.getBet(), player3.getBet());
            System.out.println(players.get(0).getName() + " wins!");
        }
    }
   
}
}


