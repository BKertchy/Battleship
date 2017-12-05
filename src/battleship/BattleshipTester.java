package battleship;

import battleship.players.kpayne4_BattleshipPlayer;
import battleship.players.kpayne4_BattleshipPlayer;
import battleship.players.kpayne4test1_BattleshipPlayer;
import battleship.players.kpayne4test2_BattleshipPlayer;
import battleship.players.bkertche_BattleshipPlayer;

/**
 * Created by Kaylee
 */
public class BattleshipTester {

    public static void main(String[] args) {
        bkertche_BattleshipPlayer a = new bkertche_BattleshipPlayer();
        kpayne4_BattleshipPlayer b = new kpayne4_BattleshipPlayer();

        int playerOneWins = 0;
        int playerTwoWins = 0;
        int numTies = 0;
        //Board aBoard = new Board(); 
        //Board bBoard = new Board();
        
        for (int j = 0; j < 10000; j++) {
            System.out.println("Starting game number " + j);
            Board aBoard = a.hideShips();
            System.out.println("Player A starting board...");
            System.out.println(aBoard);

            Board bBoard = b.hideShips();
            System.out.println("Player B starting board...");
            System.out.println(bBoard);       

            a.reset();
            b.reset();

            int step = 1;

            for (int i = 0; i < 100; i++) {
                //System.out.println("STEP " + step + " ================");
                bBoard.firedAtThisRound = false;
                a.go(bBoard);
                //System.out.println(bBoard);
                aBoard.firedAtThisRound = false;
                b.go(aBoard);
                //System.out.println(aBoard);
                
                if(aBoard.isComplete() && bBoard.isComplete()){
                    System.out.println("Tie!");
                    numTies++;
                }
                
                else if (aBoard.isComplete()) {
                    System.out.println("B Wins!");
                    playerOneWins++;
                }
                else if (bBoard.isComplete()) {
                    System.out.println("A Wins!");
                    playerTwoWins++;
                }
                if (aBoard.isComplete() || bBoard.isComplete()) {
                    break;
                }

                step++;
            }

        }
        System.out.println("Wins " + playerOneWins + " " + playerTwoWins);
        System.out.println("Ties " + numTies);
    }
}
