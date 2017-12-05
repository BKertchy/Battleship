package battleship.players;

import battleship.Board;
import java.util.Random;

public class kpayne4test2_BattleshipPlayer implements BattleshipPlayer {

    // The height and width of the board, in squares. Note that this may
    // change without notice!
    public static final int HEIGHT = 10;
    public static final int WIDTH = 10;
    
    private static final int BATTLESHIP=0;
    private static final int CARRIER=1;
    private static final int SUB=2;
    private static final int DESTROYER=3;
    private static final int PATROL=4;
    private static final int NUMSHIPS=5;
    
    private static char[][] previousBoard;
    private boolean firstBoardCreate = true;
    private static char[][] myGuesses;
    private boolean firstTime = true;
    private boolean useBegin;
    
    private boolean[] isShipHit;
    private boolean[] isShipHorizontal;
    private boolean[] isShipSunk;
    private int[] numShipHits;
    
    private int[] beginx;
    private int[] beginy;
    private int[] endx;
    private int[] endy;
    
    private int guessX;
    private int guessY;

    /**
     * hideShips - This method is called once at the beginning of each game when
     * you need to hide your ships.
     *
     * You must return a valid Board object. See that class for details. Note
     * carefully: under *no* circumstances should you return the same board
     * twice in a row; i.e., two successive calls to your hideShips() method
     * must always return *different* answers!
     */
    public Board hideShips() {
        char newGameBoard[][] = new char[10][10];
        Board myBoard = null;
        try {
            if (firstBoardCreate) {
                previousBoard = new char[10][10];
                for (int i = 0; i < HEIGHT; i++) {
                    for (int j = 0; j < WIDTH; j++) {
                        previousBoard[i][j] = ' ';
                    }
                }
                firstBoardCreate = false;
            }

            boolean boardsMatch;
            do {
                //System.out.println("Trying to create");
                for (int i = 0; i < HEIGHT; i++) {
                    for (int j = 0; j < WIDTH; j++) {
                        newGameBoard[i][j] = ' ';
                    }
                }

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

                } else if (rot == 1) {
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

                } else if (rot == 2) {
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
                } else if (rot == 3) {
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

                boardsMatch = true;
                for (int i = 0; i < HEIGHT; i++) {
                    for (int j = 0; j < WIDTH; j++) {
                        if (newGameBoard[i][j] != previousBoard[i][j]) {
                            boardsMatch = false;
                        }
                    }
                }
            } while (boardsMatch);

            previousBoard = newGameBoard;
            myBoard = new Board(newGameBoard);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return myBoard;
    }
    
    private void getGuess(int shipType) {

        Random random = new Random();

        if (numShipHits[shipType] == 1) {

            do {
                int guess = random.nextInt(4);
                if (guess == 0) {
                    System.out.println("ran 0. guessX = x + 1");
                    guessX = beginx[shipType] + 1;
                    guessY = beginy[shipType];
                } else if (guess == 1) {
                    System.out.println("ran 1. guessX = x - 1");
                    guessX = beginx[shipType] - 1;
                    guessY = beginy[shipType];
                } else if (guess == 2) {
                    System.out.println("ran 2. guessX = y + 1");
                    guessX = beginx[shipType];
                    guessY = beginy[shipType] + 1;
                } else if (guess == 3) {
                    System.out.println("ran 3. guessX = y - 1");
                    guessX = beginx[shipType];
                    guessY = beginy[shipType] - 1;
                }
            } while (myGuesses[guessX][guessY] != 'x');
        } else {
            if (useBegin == true) {
                System.out.println("Use Begin");
                if (isShipHorizontal[shipType] == false) {
                    guessX = beginx[shipType] - 1;
                    guessY = beginy[shipType];

                    if (guessX < 0 || myGuesses[guessX][guessY] != 'x') {
                        System.out.println("Tried " + guessX + " " + guessY);

                        guessX = beginx[shipType] + 1;
                        guessY = beginy[shipType];
                    }
                    if (guessX > 9 || myGuesses[guessX][guessY] != 'x') {
                        System.out.println("Vertical tried both ways and switch useBegin");
                        useBegin = false;
                    }
                } else {
                    guessX = beginx[shipType];
                    guessY = beginy[shipType] - 1;

                    if (guessY < 0 || myGuesses[guessX][guessY] != 'x') {
                        System.out.println("Tried " + guessX + " " + guessY);
                        guessX = beginx[shipType];
                        guessY = beginy[shipType] + 1;
                    }
                    if (guessY > 9 || myGuesses[guessX][guessY] != 'x') {
                        useBegin = false;
                        System.out.println("Horizontal tried both ways and switch useBegin");
                    }
                }
            }
            if (useBegin == false) {
                System.out.println("Use End");
                if (isShipHorizontal[shipType] == false) {
                    guessX = endx[shipType] - 1;
                    guessY = endy[shipType];

                    if (guessX < 0 || myGuesses[guessX][guessY] != 'x') {
                        System.out.println("Tried " + guessX + " " + guessY);
                        guessX = endx[shipType] + 1;
                        guessY = endy[shipType];
                    }
                } else {
                    guessX = endx[shipType];
                    guessY = endy[shipType] - 1;

                    if (guessY < 0 || myGuesses[guessX][guessY] != 'x') {
                        System.out.println("Tried " + guessX + " " + guessY);
                        guessX = endx[shipType];
                        guessY = endy[shipType] + 1;
                    }
                }
            }
        }
    }
    
    private void recordShot(int shipType) {
        // Record shot information

        System.out.println("=====================" + shipType + " is hit at " + guessX + " " + guessY);
        numShipHits[shipType]++;
        isShipHit[shipType] = true;
        //useBegin = true;
        if (numShipHits[shipType] == 1) {
            beginx[shipType] = guessX;
            beginy[shipType] = guessY;
            System.out.println("Num hits 1 being X,Y " + beginx[shipType] + " " + beginy[shipType]);
        } else if (numShipHits[shipType] == 2) {
            endx[shipType] = guessX;
            endy[shipType] = guessY;
            System.out.println("Num hits 2 end X,Y " + endx[shipType] + " " + endy[shipType]);
            if (beginx[shipType] == endx[shipType]) {
                System.out.println("horizontal");
                isShipHorizontal[shipType] = true;
            } else if (beginy[shipType] == endy[shipType]) {
                System.out.println("vertical");
                isShipHorizontal[shipType] = false;
            }
            useBegin = true;
        } else if (useBegin == true) {
            beginx[shipType] = guessX;
            beginy[shipType] = guessY;
            System.out.println("Num hits >2 begin X,Y " + beginx[shipType] + " " + beginy[shipType]);
        } else {
            endx[shipType] = guessX;
            endy[shipType] = guessY;
            System.out.println("Num hits >2 end X,Y " + endx[shipType] + " " + endy[shipType]);
        }

        if ((numShipHits[shipType] == 4 && shipType == BATTLESHIP) ||
              (numShipHits[shipType] == 5 && shipType == CARRIER) ||
                (numShipHits[shipType] == 3 && shipType == SUB) ||
                (numShipHits[shipType] == 3 && shipType == DESTROYER) ||
                (numShipHits[shipType] == 2 && shipType == PATROL)){
            isShipSunk[shipType] = true;
            System.out.println("=====================" + shipType + " is sunk");
        }
    }

    /**
     * go - This method is called repeatedly throughout the game, every time
     * it's your turn.
     *
     * When it's your turn, and go() is called, you must call fireAt() on the
     * Board object which is passed as a parameter. You must do this exactly
     * *once*: trying to fire more than once during your turn will be detected
     * as cheating.
     */
    public void go(Board opponentsBoard) {
        Random random = new Random();

        if (isShipHit[BATTLESHIP] && !isShipSunk[BATTLESHIP]) {
            getGuess(BATTLESHIP);
        } else if (isShipHit[CARRIER] && !isShipSunk[CARRIER]) {
            getGuess(CARRIER);
        } else if (isShipHit[SUB] && !isShipSunk[SUB]) {
            getGuess(SUB);
        } else if (isShipHit[DESTROYER] && !isShipSunk[DESTROYER]) {
            getGuess(DESTROYER);
        } else if (isShipHit[PATROL] && !isShipSunk[PATROL]) {
            getGuess(PATROL);
        } else {
            // Select square to fire on
            do {
                guessX = random.nextInt(10);
                guessY = random.nextInt(10);
            } while (myGuesses[guessX][guessY] != 'x');
        }
        
        System.out.println("Guessing " + guessX +  " " + guessY);
        try {
            char shot = opponentsBoard.fireAt(guessX, guessY);
            myGuesses[guessX][guessY] = shot;
            
            /*
            for (int i=0;i<10;i++) {
                for (int j=0;j<10;j++) {
                    System.out.print(myGuesses[i][j]);
                }
                System.out.println("");
            }
            */
            if (shot == 'B') {       
                recordShot(BATTLESHIP);
            } else if (shot == 'A') {
                recordShot(CARRIER);
            } else if (shot == 'S') {       
                recordShot(SUB);
            } else if (shot == 'D') {
                recordShot(DESTROYER);
            } else if (shot == 'P') {
                recordShot(PATROL);
            } else {
                if (useBegin == true){
                    useBegin = false;
                    System.out.println("Missed and setting useBegin to false");
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * reset - This method is called when a game has ended and a new game is
     * beginning. It gives you a chance to reset any instance variables you may
     * have created, so that your BattleshipPlayer starts fresh.
     */
    public void reset() {
        
        if (firstTime) {
            myGuesses = new char[10][10];
            isShipHit = new boolean[NUMSHIPS];
            isShipSunk = new boolean[NUMSHIPS];
            isShipHorizontal = new boolean[NUMSHIPS];
            beginx = new int[NUMSHIPS];
            beginy = new int[NUMSHIPS];
            endx = new int[NUMSHIPS];
            endy = new int[NUMSHIPS];
            numShipHits = new int[NUMSHIPS];

            firstTime = false;
        }
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                myGuesses[i][j] = 'x';
            }
        }
        useBegin = false;

        for (int i = 0; i < NUMSHIPS; i++) {
            beginx[i] = 0;
            beginy[i] = 0;
            endx[i] = 0;
            endy[i] = 0;
            isShipHorizontal[i] = true;
            numShipHits[i] = 0;
            isShipSunk[i] = false;
            isShipHit[i] = false;
        }
    }
}
