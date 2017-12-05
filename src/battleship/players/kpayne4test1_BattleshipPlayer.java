package battleship.players;

import battleship.Board;
import java.util.Random;

public class kpayne4test1_BattleshipPlayer implements BattleshipPlayer {

    // The height and width of the board, in squares. Note that this may
    // change without notice!
    public static final int HEIGHT = 10;
    public static final int WIDTH = 10;
    private static char[][] previousBoard;
    private boolean firstTime = true;
    public static char[][] oppBoard;
   
   

    /**
     * hideShips - This method is called once at the beginning of each game
     * when you need to hide your ships.
     *
     * You must return a valid Board object. See that class for details.
     * Note carefully: under *no* circumstances should you return the same
     * board twice in a row; i.e., two successive calls to your hideShips()
     * method must always return *different* answers!
     */
    public Board hideShips() {
        char  newGameBoard[][] = new char[10][10];
        Board myBoard = null;
        try {
            if (firstTime) {
                previousBoard = new char[10][10];
                for (int i = 0; i < HEIGHT; i++) {
                    for (int j = 0; j < WIDTH; j++) {
                        previousBoard[i][j] = ' ';
                    }
                }
                firstTime = false;
            }
            
            boolean boardsMatch;
            do {
                System.out.println("Trying to create");
                for(int i = 0; i < HEIGHT; i++)
                    for(int j = 0; j < WIDTH; j++)
                        newGameBoard[i][j] = ' ';
/*
                Random random = new Random();       //creating three random numbers used for the placement of my board pattern
                int x = random.nextInt(3);          //the x placement that keeps the board in bounds
                int y = random.nextInt(3);          //the y placement that keeps the board in bounds
                int rot = random.nextInt(4);        //the orientation of the board pattern

                
                //board pattern for each rotation
                if (rot == 0) {
                    newGameBoard[1 + x][1 + y] = 'A';
                    newGameBoard[2 + x][1 + y] = 'A';
                    newGameBoard[3 + x][1 + y] = 'A';
                    newGameBoard[4 + x][1 + y] = 'A';
                    newGameBoard[5 + x][1 + y] = 'A';

                    newGameBoard[1 + x][3 + y] = 'B';
                    newGameBoard[1 + x][4 + y] = 'B';
                    newGameBoard[1 + x][5 + y] = 'B';
                    newGameBoard[1 + x][6 + y] = 'B';

                    newGameBoard[6 + x][2 + y] = 'D';
                    newGameBoard[6 + x][3 + y] = 'D';
                    newGameBoard[6 + x][4 + y] = 'D';

                    newGameBoard[4 + x][6 + y] = 'S';
                    newGameBoard[5 + x][6 + y] = 'S';
                    newGameBoard[6 + x][6 + y] = 'S';

                    newGameBoard[3 + x][3 + y] = 'P';
                    newGameBoard[4 + x][3 + y] = 'P';

                }else if (rot == 1) {
                    newGameBoard[1 + x][2 + y] = 'A';
                    newGameBoard[1 + x][3 + y] = 'A';
                    newGameBoard[1 + x][4 + y] = 'A';
                    newGameBoard[1 + x][5 + y] = 'A';
                    newGameBoard[1 + x][6 + y] = 'A';

                    newGameBoard[3 + x][6 + y] = 'B';
                    newGameBoard[4 + x][6 + y] = 'B';
                    newGameBoard[5 + x][6 + y] = 'B';
                    newGameBoard[6 + x][6 + y] = 'B';

                    newGameBoard[3 + x][1 + y] = 'D';
                    newGameBoard[4 + x][1 + y] = 'D';
                    newGameBoard[5 + x][1 + y] = 'D';

                    newGameBoard[6 + x][2 + y] = 'S';
                    newGameBoard[6 + x][3 + y] = 'S';
                    newGameBoard[6 + x][4 + y] = 'S';

                    newGameBoard[3 + x][3 + y] = 'P';
                    newGameBoard[3 + x][4 + y] = 'P';

                }else if (rot == 2) {
                    newGameBoard[2 + x][6 + y] = 'A';
                    newGameBoard[3 + x][6 + y] = 'A';
                    newGameBoard[4 + x][6 + y] = 'A';
                    newGameBoard[5 + x][6 + y] = 'A';
                    newGameBoard[6 + x][6 + y] = 'A';

                    newGameBoard[6 + x][1 + y] = 'B';
                    newGameBoard[6 + x][2 + y] = 'B';
                    newGameBoard[6 + x][3 + y] = 'B';
                    newGameBoard[6 + x][4 + y] = 'B';

                    newGameBoard[1 + x][2 + y] = 'D';
                    newGameBoard[1 + x][3 + y] = 'D';
                    newGameBoard[1 + x][4 + y] = 'D';

                    newGameBoard[2 + x][1 + y] = 'S';
                    newGameBoard[3 + x][1 + y] = 'S';
                    newGameBoard[4 + x][1 + y] = 'S';

                    newGameBoard[3 + x][4 + y] = 'P';
                    newGameBoard[4 + x][4 + y] = 'P';
                }else if (rot == 3) {
                    newGameBoard[6 + x][1 + y] = 'A';
                    newGameBoard[6 + x][2 + y] = 'A';
                    newGameBoard[6 + x][3 + y] = 'A';
                    newGameBoard[6 + x][4 + y] = 'A';
                    newGameBoard[6 + x][5 + y] = 'A';

                    newGameBoard[1 + x][1 + y] = 'B';
                    newGameBoard[2 + x][1 + y] = 'B';
                    newGameBoard[3 + x][1 + y] = 'B';
                    newGameBoard[4 + x][1 + y] = 'B';

                    newGameBoard[2 + x][6 + y] = 'D';
                    newGameBoard[3 + x][6 + y] = 'D';
                    newGameBoard[4 + x][6 + y] = 'D';

                    newGameBoard[1 + x][3 + y] = 'S';
                    newGameBoard[1 + x][4 + y] = 'S';
                    newGameBoard[1 + x][5 + y] = 'S';

                    newGameBoard[4 + x][3 + y] = 'P';
                    newGameBoard[4 + x][4 + y] = 'P';
                } 
*/             
/* Try side by side ships */
                    newGameBoard[0][0] = 'A';
                    newGameBoard[1][0] = 'A';
                    newGameBoard[2][0] = 'A';
                    newGameBoard[3][0] = 'A';
                    newGameBoard[4][0] = 'A';

                    newGameBoard[0][1] = 'B';
                    newGameBoard[1][1] = 'B';
                    newGameBoard[2][1] = 'B';
                    newGameBoard[3][1] = 'B';

                    newGameBoard[0][2] = 'D';
                    newGameBoard[1][2] = 'D';
                    newGameBoard[2][2] = 'D';

                    newGameBoard[0][3] = 'S';
                    newGameBoard[1][3] = 'S';
                    newGameBoard[2][3] = 'S';

                    newGameBoard[0][4] = 'P';
                    newGameBoard[1][4] = 'P';
                    
                boardsMatch = true;
                for(int i = 0; i < HEIGHT; i++)
                    for(int j = 0; j < WIDTH; j++)
                        if (newGameBoard[i][j] != previousBoard[i][j])
                                boardsMatch = false;
            } while (false);
           // } while (boardsMatch);
            
            previousBoard = newGameBoard;
            myBoard = new Board(newGameBoard);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());    
        }
        return myBoard;
    }
    /**
     * go - This method is called repeatedly throughout the game, every
     * time it's your turn.
     *
     * When it's your turn, and go() is called, you must call fireAt() on
     * the Board object which is passed as a parameter. You must do this
     * exactly *once*: trying to fire more than once during your turn will
     * be detected as cheating.
     */
     
    

    public void go(Board opponentsBoard) {
        Random random = new Random();       //creating three random numbers used for the placement of my board pattern
        int h = random.nextInt(9);          //the x placement that keeps the board in bounds
        int w = random.nextInt(9); 
        try {
            opponentsBoard.fireAt(h,w);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * reset - This method is called when a game has ended and a new game
     * is beginning. It gives you a chance to reset any instance variables
     * you may have created, so that your BattleshipPlayer starts fresh.
     */
    public void reset() {
        // RESET YOUR OBJECT HERE
    }
}
