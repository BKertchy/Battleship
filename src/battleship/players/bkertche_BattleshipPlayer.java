
package battleship.players;

import battleship.Board;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class bkertche_BattleshipPlayer implements BattleshipPlayer {

    /**
     * Other than "game" char[][], which is my copy of the enemy's board, all
     * of these variables are explained in the code.
     */
    private char [][] best = new char[10][10];
    private int wa, ha, or;
    private boolean b;
    private int hit = 0;
    private int up = 1;
    private int down = 1;
    private int left = 1;
    private int right = 1;
    private Random width;
    private Random height;
    private char [][] game = new char[10][10];
    private int gw, gh;
    private boolean up2 = true;
    private boolean down2 = true;
    private boolean left2 = true;
    private boolean right2  = true;

    
            
    
    
    public Board hideShips() {
        //I empty both of my char[][]'s here
        for (int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++)
                best[i][j] = ' ';
        }
        for (int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++)
                game[i][j] = ' ';
        }
        /*I modified the "hasShip" method in order to loop through and place the
        * A's. Basically, I randomize the orientation(up or down) and also 
        * randomize where it starts.
        */
        width = new Random();
        height = new Random();
        Random o = new Random();
        wa = width.nextInt(10);
        ha = height.nextInt(10);
        best[ha][wa] = 'A';
        or = o.nextInt(2);
        int count1 = 1;
        int count0 = 1;
        while(hasShip('A',5) == false){
            if (or == 1){
                Random v = new Random();
                int updn = v.nextInt(2);
                if(updn == 1){
                    if((ha - count1) < 0){
                        best[ha+count0][wa] = 'A';
                        count0++;
                    }
                    else{
                        best[ha-count1][wa] = 'A';
                        count1++;
                    }
                }
                else{
                    if((ha + count0) > 9){
                        best[ha-count1][wa] = 'A';
                        count1++;
                    }
                    else{
                        best[ha+count0][wa] = 'A';
                        count0++;
                    }
                }
            }
            else{
                Random h = new Random();
                int ltrt = h.nextInt(2);
                if(ltrt == 1){
                    if((wa - count1) < 0){
                        best[ha][wa+count0] = 'A';
                        count0++;
                    }
                    else{
                        best[ha][wa-count1] = 'A';
                        count1++;
                    }
                }
                else{
                    if((wa + count0) > 9){
                        best[ha][wa-count1] = 'A';
                        count1++;
                    }
                    else{
                        best[ha][wa+count0] = 'A';
                        count0++;
                    }
                }
            }
        }
        /*The way I do the rest of the ships is fairly similar, however I created
        * a method called "canPlace". It takes random width, height, orientation,
        * as well as the ship length and the "best" char[][] and runs through every
        * space that corresponds to the orientation and responds back if it can
        * be placed there or not. If not, the loop runs again until it finds a 
        * spot. The second loop/algorithm counts left and right to keep track of how far
        * to each side of the original width and height it has gone. Once the
        * required number of letters has been reached, the loop ends and moves
        * on to the next ship and repeats the same process.
        */
        b = false;
        while(b != true){
            wa = width.nextInt(10);
            ha = height.nextInt(10);
            or = o.nextInt(2);
            b = canPlace(wa,ha,4,or,best);
        }
        best[ha][wa] = 'B';
        count1 = 1;
        count0 = 1;
        while(hasShip('B',4) == false){
            if (or == 1){
                Random v = new Random();
                int updn = v.nextInt(2);
                if(updn == 1){
                    if((ha - count1) < 0 || best[ha-count1][wa] != ' '){
                        best[ha+count0][wa] = 'B';
                        count0++;
                    }
                    else{
                        best[ha-count1][wa] = 'B';
                        count1++;
                    }
                }
                else{
                    if((ha + count0) > 9 || best[ha+count0][wa] != ' '){
                        best[ha-count1][wa] = 'B';
                        count1++;
                    }
                    else{
                        best[ha+count0][wa] = 'B';
                        count0++;
                    }
                }
            }
            else{
                Random h = new Random();
                int ltrt = h.nextInt(2);
                if(ltrt == 1){
                    if((wa - count1) < 0 || best[ha][wa-count1] != ' '){
                        best[ha][wa+count0] = 'B';
                        count0++;
                    }
                    else{
                        best[ha][wa-count1] = 'B';
                        count1++;
                    }
                }
                else{
                    if((wa + count0) > 9 || best[ha][wa+count0] != ' '){
                        best[ha][wa-count1] = 'B';
                        count1++;
                    }
                    else{
                        best[ha][wa+count0] = 'B';
                        count0++;
                    }
                }
            }
        }
        
        b = false;
        while(b != true){
            wa = width.nextInt(10);
            ha = height.nextInt(10);
            or = o.nextInt(2);
            b = canPlace(wa,ha,3,or,best);
        }
        best[ha][wa] = 'S';
        count1 = 1;
        count0 = 1;
        while(hasShip('S',3) == false){
            if (or == 1){
                Random v = new Random();
                int updn = v.nextInt(2);
                if(updn == 1){
                    if((ha - count1) < 0 || best[ha-count1][wa] != ' '){
                        best[ha+count0][wa] = 'S';
                        count0++;
                    }
                    else{
                        best[ha-count1][wa] = 'S';
                        count1++;
                    }
                }
                else{
                    if((ha + count0) > 9 || best[ha+count0][wa] != ' '){
                        best[ha-count1][wa] = 'S';
                        count1++;
                    }
                    else{
                        best[ha+count0][wa] = 'S';
                        count0++;
                    }
                }
            }
            else{
                Random h = new Random();
                int ltrt = h.nextInt(2);
                if(ltrt == 1){
                    if((wa - count1) < 0 || best[ha][wa-count1] != ' '){
                        best[ha][wa+count0] = 'S';
                        count0++;
                    }
                    else{
                        best[ha][wa-count1] = 'S';
                        count1++;
                    }
                }
                else{
                    if((wa + count0) > 9 || best[ha][wa+count0] != ' '){
                        best[ha][wa-count1] = 'S';
                        count1++;
                    }
                    else{
                        best[ha][wa+count0] = 'S';
                        count0++;
                    }
                }
            }
        }
        
        b = false;
        while(b != true){
            wa = width.nextInt(10);
            ha = height.nextInt(10);
            or = o.nextInt(2);
            b = canPlace(wa,ha,3,or,best);
        }
        best[ha][wa] = 'D';
        count1 = 1;
        count0 = 1;
        while(hasShip('D',3) == false){
            if (or == 1){
                Random v = new Random();
                int updn = v.nextInt(2);
                if(updn == 1){
                    if((ha - count1) < 0 || best[ha-count1][wa] != ' '){
                        best[ha+count0][wa] = 'D';
                        count0++;
                    }
                    else{
                        best[ha-count1][wa] = 'D';
                        count1++;
                    }
                }
                else{
                    if((ha + count0) > 9 || best[ha+count0][wa] != ' '){
                        best[ha-count1][wa] = 'D';
                        count1++;
                    }
                    else{
                        best[ha+count0][wa] = 'D';
                        count0++;
                    }
                }
            }
            else{
                Random h = new Random();
                int ltrt = h.nextInt(2);
                if(ltrt == 1){
                    if((wa - count1) < 0 || best[ha][wa-count1] != ' '){
                        best[ha][wa+count0] = 'D';
                        count0++;
                    }
                    else{
                        best[ha][wa-count1] = 'D';
                        count1++;
                    }
                }
                else{
                    if((wa + count0) > 9 || best[ha][wa+count0] != ' '){
                        best[ha][wa-count1] = 'D';
                        count1++;
                    }
                    else{
                        best[ha][wa+count0] = 'D';
                        count0++;
                    }
                }
            }
        }
        
        b = false;
        while(b != true){
            wa = width.nextInt(10);
            ha = height.nextInt(10);
            or = o.nextInt(2);
            b = canPlace(wa,ha,2,or,best);
        }
        best[ha][wa] = 'P';
        count1 = 1;
        count0 = 1;
        while(hasShip('P',2) == false){
            if (or == 1){
                Random v = new Random();
                int updn = v.nextInt(2);
                if(updn == 1){
                    if((ha - count1) < 0 || best[ha-count1][wa] != ' '){
                        best[ha+count0][wa] = 'P';
                        count0++;
                    }
                    else{
                        best[ha-count1][wa] = 'P';
                        count1++;
                    }
                }
                else{
                    if((ha + count0) > 9 || best[ha+count0][wa] != ' '){
                        best[ha-count1][wa] = 'P';
                        count1++;
                    }
                    else{
                        best[ha+count0][wa] = 'P';
                        count0++;
                    }
                }
            }
            else{
                Random h = new Random();
                int ltrt = h.nextInt(2);
                if(ltrt == 1){
                    if((wa - count1) < 0 || best[ha][wa-count1] != ' '){
                        best[ha][wa+count0] = 'P';
                        count0++;
                    }
                    else{
                        best[ha][wa-count1] = 'P';
                        count1++;
                    }
                }
                else{
                    if((wa + count0) > 9 || best[ha][wa+count0] != ' '){
                        best[ha][wa-count1] = 'P';
                        count1++;
                    }
                    else{
                        best[ha][wa+count0] = 'P';
                        count0++;
                    }
                }
            }
        }
        /*Once all the ships have been successfully placed, I create a board
        * object and use it as the return value.
        */
        try {
            Board awesome = new Board(best);
            return awesome;
        } catch (Exception ex) {
            Logger.getLogger(bkertche_BattleshipPlayer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    /*I spent quite a bit of time on this go method to make sure that it didn't
    * just randomly shoot. The process is methodical. There are two options at 
    * first and that is if either "hit" == 0 or 1. Basically, if I'm looking for
    * a new ship, hit == 0. If I have already found a ship, hit == 1. This entire
    * algorithm is based on the idea that once I find a width and height of a hit
    * spot, everything focuses around that. I have 4 booleans to indicate if the
    * algorithm should shoot in the indicated direction. I also have 4 int's to
    * keep track of how far I have gone in the indicated direction. gw and gh
    * represent the width and height, respectively. 
    */
    public void go(Board opponentsBoard) {
        if (hit == 0){
            up2 = true;
            down2 = true;
            left2 = true;
            right2 = true;
            up = 1;
            down = 1;
            left = 1;
            right = 1;
            gw = 1;
            gh = 0;
            /*If I have already located something at the randomized spot, it
            *restarts. The randomization is not every single square, but only
            *every other square. By making the sum of width and height be even
            *I guarantee that I'm randomly firing at the enemy's board like a
            *checker board. No ship is 1 unit long, it's bound to find them all.
            */
            while (((gw+gh)%2) != 0){
                gw = width.nextInt(10);
                gh = height.nextInt(10);
                if (game[gh][gw] == 'M' || 
                    game[gh][gw] == 'A' || 
                    game[gh][gw] == 'B' || 
                    game[gh][gw] == 'S' || 
                    game[gh][gw] == 'D' || 
                    game[gh][gw] == 'P') {
                    gw = 1;
                    gh = 0;
                    continue;
                    }
                if((gw+gh)%2 != 0)
                    continue;
                /*The purpose of these next if statements is basically to see if
                * it's actually worth hitting in the spot indicated even if it's
                * blank. For example.. if I have every ship except the aircraft
                * carrier and the spot I'm hitting can't fit an aircraft carrier,
                * both vertically and horizontally, I'm not going to target there.
                * I use a method called "enemyHasShip" which is a modified copy
                * of "hasShip" and I use "canBe" which is a modified copy of 
                * "canPlace"
                */
                if (enemyHasShip('A', 5) == false &&
                    (canBe(gw, gh, 5, 1, game, 'A') ||
                     canBe(gw, gh, 5, 0, game, 'A'))){
                    break;
                }
                if (enemyHasShip('B', 4) == false &&
                    (canBe(gw, gh, 4, 1, game,'B') ||
                     canBe(gw, gh, 4, 0, game,'B'))){
                    break;
                }
                if (enemyHasShip('S', 3) == false &&
                    (canBe(gw, gh, 3, 1, game,'S') ||
                     canBe(gw, gh, 3, 0, game,'S'))){
                    break;
                }
                if (enemyHasShip('D', 3) == false &&
                    (canBe(gw, gh, 3, 1, game,'D') ||
                     canBe(gw, gh, 3, 0, game,'D'))){
                    break;
                }
                if (enemyHasShip('P', 2) == false &&
                    (canBe(gw, gh, 2, 1, game,'P') ||
                     canBe(gw, gh, 2, 0, game,'P'))){
                    break;
                }
                gw = 1;
                gh = 0;
            }
            char fire = opponentsBoard.fireAt(gh, gw);
            if (fire == ' '){
                hit = 0;
                game[gh][gw] = 'M';
            }
            //If I hit something, the next stage begins.
            else{
                game[gh][gw] = fire;
                hit = 1;
            }
        }
        else{
            /*The first few "if" statements before the large "switch" statement
            * is there to let the "switch" statement know which way to hit.
            * If I go off the grid going down, I don't hit down. If there's a 
            * letter already found to the right, I don't go right, etc.
            * Very helpful for skipping unnecessary steps.
            */
            if(gh-up<0)
                up2 = false;
            else if(game[gh-up][gw] == ' ')
                up2 = true;
            else if(game[gh][gw] == game[gh-up][gw] && (gh-(up+1))>-1){
                up++;
                up2 = true;
                left2 = false;
                right2 = false;
            }
            else{
                up2 = false;
            }
            if(gh+down>9)
                down2 = false;
            else if (game[gh+down][gw] == ' ')
                down2 = true;
            else if(game[gh][gw] == game[gh+down][gw] && (gh+down+1)<10){
                down++;
                down2 = true;
                left2 = false;
                right2 = false;
            }
            else{
                down2 = false;
            }
            if(gw-left<0)
                left2 = false;
            else if(game[gh][gw-left] == ' ')
                left2 = true;
            else if(game[gh][gw] == game[gh][gw-left] && (gw-(left+1))>-1){
                left++;
                left2 = true;
                up2 = false;
                down2 = false;
            }
            else{
                left2 = false;
            }
            if(gw+right>9)
                right2 = false;
            else if(game[gh][gw+right] == ' ')
                right2 = true;
            else if(game[gh][gw] == game[gh][gw+right] && (gw+right+1)<10){
                right++;
                right2 = true;
                up2 = false;
                down2 = false;
            }
            else{right2 = false;}
            /*Here is where all the magic happens. Firstly, it sees what ship it
            * is. Within each ship "switch" statement, there are four directions
            * it can go and it uses "canBe" to determine if vertical or horizontal
            * is the best choice. If it misses, it sets spot to "M", and reassigns
            * booleans. If I hit more than one square of a ship, I have found whether it's
            * vertical or horizontal and don't need to keep searching randomly.
            * If, let's say, I hit 4 to the right for an aircraft carrier, but 
            * miss on the 5th, the algorithm will take me back to the other side
            * where the last square is bound to be. Once I have found the ship,
            * it sets "hit" to zero and the random searching begins again.
            *
            * Basically, once I find a ship, it goes down with minimally wasted
            * shots.
            *
            * The best part about this algorithm is when I happen to find another
            * ship while destroying the first one. It will ignore the one I found
            * until the first one is destroyed. As soon as "enemyHasShip" returns
            * true it calculates to see if any other ship (using countSquares) 
            * is on the board, but not completed. Then, it finds that square, and 
            * the process starts all over. By using my method "missMe" I locate
            * the square in the enemy's game board, set gw and gh to that and
            * reset all of my variables.
            *
            * I realize there is a lot of redundancy here, and if I had more time
            * I could and would definitely condense it. But for now.. it'll do.
            */
            switch (game[gh][gw]) {
                case 'A':
                    int tota = countSquares('A', game);
                    if (canBe(gw,gh,5,1,game,'A') && down2){
                        char fire = opponentsBoard.fireAt(gh+down,gw);
                        switch (fire) {
                            case ' ':
                                game[gh+down][gw] = 'M';
                                if(tota == 1){
                                    down2 = false;
                                }
                                else{
                                    down2 = false;
                                    right2 = false;
                                    left2 = false;
                                }
                                break;
                            case 'A':
                                game[gh+down][gw] = 'A';
                                down += 1;
                                if(enemyHasShip('A',5)){
                                    if(0 < countSquares('B',game) &&
                                           countSquares('B',game) < 4)
                                        missMe('B');
                                    else if (0 < countSquares('S',game) &&
                                                 countSquares('S',game) < 3)
                                        missMe('S');
                                    else if (0 < countSquares('D',game) &&
                                                 countSquares('D',game) < 3)
                                        missMe('D');
                                    else if (countSquares('P',game) == 1)
                                        missMe('P');
                                    else
                                        hit = 0;
                                }
                                left2 = false;
                                right2 = false;
                                break;
                            default:
                                game[gh+down][gw] = fire;
                                if(tota == 1){
                                    down2 = false;
                                }
                                else{
                                    down2 = false;
                                    right2 = false;
                                    left2 = false;
                                }
                                break;
                        }
                    }
                    else if (canBe(gw,gh,5,1,game,'A') && up2){
                        char fire = opponentsBoard.fireAt(gh-up,gw);
                        switch (fire) {
                            case ' ':
                                game[gh-up][gw] = 'M';
                                if(tota == 1){
                                    up2 = false;
                                }
                                else{
                                    up2 = false;
                                    left2 = false;
                                    right2 = false;
                                }
                                break;
                            case 'A':
                                game[gh-up][gw] = 'A';
                                up += 1;
                                if(enemyHasShip('A',5)){
                                    if(0 < countSquares('B',game) &&
                                           countSquares('B',game) < 4)
                                        missMe('B');
                                    else if (0 < countSquares('S',game) &&
                                                 countSquares('S',game) < 3)
                                        missMe('S');
                                    else if (0 < countSquares('D',game) &&
                                                 countSquares('D',game) < 3)
                                        missMe('D');
                                    else if (countSquares('P',game) == 1)
                                        missMe('P');
                                    else
                                        hit = 0;
                                }
                                left2 = false;
                                right2 = false;
                                break;
                            default:
                                game[gh-up][gw] = fire;
                                if(tota == 1){
                                    up2 = false;
                                }
                                else{
                                    up2 = false;
                                    left2 = false;
                                    right2 = false;
                                }
                                break;
                        }
                    }
                    else if (canBe(gw,gh,5,0,game,'A') && right2){
                        char fire = opponentsBoard.fireAt(gh,gw+right);
                        switch (fire) {
                            case ' ':
                                game[gh][gw+right] = 'M';
                                if(tota == 1){
                                    right2 = false;
                                }
                                else{
                                    right2 = false;
                                    up2 = false;
                                    down2 = false;
                                }
                                break;
                            case 'A':
                                game[gh][gw+right] = 'A';
                                right += 1;
                                if(enemyHasShip('A',5)){
                                    if(0 < countSquares('B',game) &&
                                           countSquares('B',game) < 4)
                                        missMe('B');
                                    else if (0 < countSquares('S',game) &&
                                                 countSquares('S',game) < 3)
                                        missMe('S');
                                    else if (0 < countSquares('D',game) &&
                                                 countSquares('D',game) < 3)
                                        missMe('D');
                                    else if (countSquares('P',game) == 1)
                                        missMe('P');
                                    else
                                        hit = 0;
                                }
                                up2 = false;
                                down2 = false;
                                break;
                            default:
                                game[gh][gw+right] = fire;
                                if(tota == 1){
                                    right2 = false;
                                }
                                else{
                                    right2 = false;
                                    up2 = false;
                                    down2 = false;
                                }
                                break;
                        }
                    }
                    else if (canBe(gw,gh,5,0,game,'A') && left2){
                        char fire = opponentsBoard.fireAt(gh,gw-left);
                        switch (fire) {
                            case ' ':
                                game[gh][gw-left] = 'M';
                                if(tota == 1){
                                    left2 = false;
                                }
                                else{
                                    left2 = false;
                                    up2 = false;
                                    down2 = false;
                                }
                                break;
                            case 'A':
                                game[gh][gw-left] = 'A';
                                left += 1;
                                if(enemyHasShip('A',5)){
                                    if(0 < countSquares('B',game) &&
                                           countSquares('B',game) < 4)
                                        missMe('B');
                                    else if (0 < countSquares('S',game) &&
                                                 countSquares('S',game) < 3)
                                        missMe('S');
                                    else if (0 < countSquares('D',game) &&
                                                 countSquares('D',game) < 3)
                                        missMe('D');
                                    else if (countSquares('P',game) == 1)
                                        missMe('P');
                                    else
                                        hit = 0;
                                }
                                up2 = false;
                                down2 = false;
                                break;
                            default:
                                game[gh][gw-left] = fire;
                                if(tota == 1){
                                    left2 = false;
                                }
                                else{
                                    left2 = false;
                                    up2 = false;
                                    down2 = false;
                                }
                                break;
                        }
                    }
                    break;
                case 'B':
                    int totb = countSquares('B', game);
                    if (canBe(gw,gh,4,1,game,'B') && down2){
                        char fire = opponentsBoard.fireAt(gh+down,gw);
                        switch (fire) {
                            case ' ':
                                game[gh+down][gw] = 'M';
                                if(totb == 1){
                                    down2 = false;
                                }
                                else{
                                    down2 = false;
                                    right2 = false;
                                    left2 = false;
                                }
                                break;
                            case 'B':
                                game[gh+down][gw] = 'B';
                                down += 1;
                                if(enemyHasShip('B',4)){
                                    if(0 < countSquares('A',game) &&
                                           countSquares('A',game) < 5)
                                        missMe('A');
                                    else if (0 < countSquares('S',game) &&
                                                 countSquares('S',game) < 3)
                                        missMe('S');
                                    else if (0 < countSquares('D',game) &&
                                                 countSquares('D',game) < 3)
                                        missMe('D');
                                    else if (countSquares('P',game) == 1)
                                        missMe('P');
                                    else
                                        hit = 0;
                                }
                                right2 = false;
                                left2 = false;
                                break;
                            default:
                                game[gh+down][gw] = fire;
                                if(totb == 1){
                                    down2 = false;
                                }
                                else{
                                    down2 = false;
                                    right2 = false;
                                    left2 = false;
                                }
                                break;
                        }
                    }
                    else if (canBe(gw,gh,4,1,game,'B') && up2){
                        char fire = opponentsBoard.fireAt(gh-up,gw);
                        switch (fire) {
                            case ' ':
                                game[gh-up][gw] = 'M';
                                if(totb == 1){
                                    up2 = false;
                                }
                                else{
                                    up2 = false;
                                    right2 = false;
                                    left2 = false;
                                }
                                break;
                            case 'B':
                                game[gh-up][gw] = 'B';
                                up += 1;
                                if(enemyHasShip('B',4)){
                                    if(0 < countSquares('A',game) &&
                                           countSquares('A',game) < 5)
                                        missMe('A');
                                    else if (0 < countSquares('S',game) &&
                                                 countSquares('S',game) < 3)
                                        missMe('S');
                                    else if (0 < countSquares('D',game) &&
                                                 countSquares('D',game) < 3)
                                        missMe('D');
                                    else if (countSquares('P',game) == 1)
                                        missMe('P');
                                    else
                                        hit = 0;
                                }
                                left2 = false;
                                right2 = false;
                                break;
                            default:
                                game[gh-up][gw] = fire;
                                if(totb == 1){
                                    up2 = false;
                                }
                                else{
                                    up2 = false;
                                    right2 = false;
                                    left2 = false;
                                }
                                break;
                        }
                    }
                    else if (canBe(gw,gh,4,0,game,'B') && right2){
                        char fire = opponentsBoard.fireAt(gh,gw+right);
                        switch (fire) {
                            case ' ':
                                game[gh][gw+right] = 'M';
                                if(totb == 1){
                                    right2 = false;
                                }
                                else{
                                    right2 = false;
                                    up2 = false;
                                    down2 = false;
                                }
                                break;
                            case 'B':
                                game[gh][gw+right] = 'B';
                                right += 1;
                                if(enemyHasShip('B',4)){
                                    if(0 < countSquares('A',game) &&
                                           countSquares('A',game) < 5)
                                        missMe('A');
                                    else if (0 < countSquares('S',game) &&
                                                 countSquares('S',game) < 3)
                                        missMe('S');
                                    else if (0 < countSquares('D',game) &&
                                                 countSquares('D',game) < 3)
                                        missMe('D');
                                    else if (countSquares('P',game) == 1)
                                        missMe('P');
                                    else
                                        hit = 0;
                                }
                                up2 = false;
                                down2 = false;
                                break;
                            default:
                                game[gh][gw+right] = fire;
                                if(totb == 1){
                                    right2 = false;
                                }
                                else{
                                    right2 = false;
                                    up2 = false;
                                    down2 = false;
                                }
                                break;
                        }
                    }
                    else if (canBe(gw,gh,4,0,game,'B') && left2){
                        char fire = opponentsBoard.fireAt(gh,gw-left);
                        switch (fire) {
                            case ' ':
                                game[gh][gw-left] = 'M';
                                if(totb == 1){
                                    left2 = false;
                                }
                                else{
                                    left2 = false;
                                    up2 = false;
                                    down2 = false;
                                }
                                break;
                            case 'B':
                                game[gh][gw-left] = 'B';
                                left += 1;
                                if(enemyHasShip('B',4)){
                                    if(0 < countSquares('A',game) &&
                                           countSquares('A',game) < 5)
                                        missMe('A');
                                    else if (0 < countSquares('S',game) &&
                                                 countSquares('S',game) < 3)
                                        missMe('S');
                                    else if (0 < countSquares('D',game) &&
                                                 countSquares('D',game) < 3)
                                        missMe('D');
                                    else if (countSquares('P',game) == 1)
                                        missMe('P');
                                    else
                                        hit = 0;
                                    hit = 0;
                                }
                                up2 = false;
                                down2 = false;
                                break;
                            default:
                                game[gh][gw-left] = fire;
                                if(totb == 1){
                                    left2 = false;
                                }
                                else{
                                    left2 = false;
                                    up2 = false;
                                    down2 = false;
                                }
                                break;
                        }
                    }
                    break;
                case 'S':
                    int tots = countSquares('S', game);
                    if (canBe(gw,gh,3,1,game,'S') && down2){
                        char fire = opponentsBoard.fireAt(gh+down,gw);
                        switch (fire) {
                            case ' ':
                                game[gh+down][gw] = 'M';
                                if(tots == 1){
                                    down2 = false;
                                }
                                else{
                                    down2 = false;
                                    left2 = false;
                                    right2 = false;
                                }
                                break;
                            case 'S':
                                game[gh+down][gw] = 'S';
                                down += 1;
                                if(enemyHasShip('S',3)){
                                    if(0 < countSquares('A',game) &&
                                           countSquares('A',game) < 5)
                                        missMe('A');
                                    else if (0 < countSquares('B',game) &&
                                                 countSquares('B',game) < 4)
                                        missMe('B');
                                    else if (0 < countSquares('D',game) &&
                                                 countSquares('D',game) < 3)
                                        missMe('D');
                                    else if (countSquares('P',game) == 1)
                                        missMe('P');
                                    else
                                        hit = 0;
                                }
                                right2 = false;
                                left2 = false;
                                break;
                            default:
                                game[gh+down][gw] = fire;
                                if(tots == 1){
                                    down2 = false;
                                }
                                else{
                                    down2 = false;
                                    left2 = false;
                                    right2 = false;
                                }
                                break;
                        }
                    }
                    else if (canBe(gw,gh,3,1,game,'S') && up2){
                        char fire = opponentsBoard.fireAt(gh-up,gw);
                        switch (fire) {
                            case ' ':
                                game[gh-up][gw] = 'M';
                                if(tots == 1){
                                    up2 = false;
                                }
                                else{
                                    up2 = false;
                                    left2 = false;
                                    right2 = false;
                                }
                                break;
                            case 'S':
                                game[gh-up][gw] = 'S';
                                up += 1;
                                if(enemyHasShip('S',3)){
                                    if(0 < countSquares('A',game) &&
                                           countSquares('A',game) < 5)
                                        missMe('A');
                                    else if (0 < countSquares('B',game) &&
                                                 countSquares('B',game) < 4)
                                        missMe('B');
                                    else if (0 < countSquares('D',game) &&
                                                 countSquares('D',game) < 3)
                                        missMe('D');
                                    else if (countSquares('P',game) == 1)
                                        missMe('P');
                                    else
                                        hit = 0;
                                }
                                right2 = false;
                                left2 = false;
                                break;
                            default:
                                game[gh-up][gw] = fire;
                                if(tots == 1){
                                    up2 = false;
                                }
                                else{
                                    up2 = false;
                                    left2 = false;
                                    right2 = false;
                                }
                                break;
                        }
                    }
                    else if (canBe(gw,gh,3,0,game,'S') && right2){
                        char fire = opponentsBoard.fireAt(gh,gw+right);
                        switch (fire) {
                            case ' ':
                                game[gh][gw+right] = 'M';
                                if(tots == 1){
                                    right2 = false;
                                }
                                else{
                                    right2 = false;
                                    up2 = false;
                                    down2 = false;
                                }
                                break;
                            case 'S':
                                game[gh][gw+right] = 'S';
                                right += 1;
                                if(enemyHasShip('S',3)){
                                    if(0 < countSquares('A',game) &&
                                           countSquares('A',game) < 5)
                                        missMe('A');
                                    else if (0 < countSquares('B',game) &&
                                                 countSquares('B',game) < 4)
                                        missMe('B');
                                    else if (0 < countSquares('D',game) &&
                                                 countSquares('D',game) < 3)
                                        missMe('D');
                                    else if (countSquares('P',game) == 1)
                                        missMe('P');
                                    else
                                        hit = 0;
                                }
                                up2 = false;
                                down2 = false;
                                break;
                            default:
                                game[gh][gw+right] = fire;
                                if(tots == 1){
                                    right2 = false;
                                }
                                else{
                                    right2 = false;
                                    up2 = false;
                                    down2 = false;
                                }
                                break;
                        }
                    }
                    else if (canBe(gw,gh,3,0,game,'S') && left2){
                        char fire = opponentsBoard.fireAt(gh,gw-left);
                        switch (fire) {
                            case ' ':
                                game[gh][gw-left] = 'M';
                                if(tots == 1){
                                    left2 = false;
                                }
                                else{
                                    left2 = false;
                                    up2 = false;
                                    down2 = false;
                                }
                                break;
                            case 'S':
                                game[gh][gw-left] = 'S';
                                left += 1;
                                if(enemyHasShip('S',3)){
                                    if(0 < countSquares('A',game) &&
                                           countSquares('A',game) < 5)
                                        missMe('A');
                                    else if (0 < countSquares('B',game) &&
                                                 countSquares('B',game) < 4)
                                        missMe('B');
                                    else if (0 < countSquares('D',game) &&
                                                 countSquares('D',game) < 3)
                                        missMe('D');
                                    else if (countSquares('P',game) == 1)
                                        missMe('P');
                                    else
                                        hit = 0;
                                }
                                up2 = false;
                                down2 = false;
                                break;
                            default:
                                game[gh][gw-left] = fire;
                                if(tots == 1){
                                    left2 = false;
                                }
                                else{
                                    left2 = false;
                                    up2 = false;
                                    down2 = false;
                                }
                                break;
                        }
                    }
                    break;
                case 'D':
                    int totd = countSquares('D', game);
                    if (canBe(gw,gh,3,1,game,'D') && down2){
                        char fire = opponentsBoard.fireAt(gh+down,gw);
                        switch (fire) {
                            case ' ':
                                game[gh+down][gw] = 'M';
                                if(totd == 1){
                                    down2 = false;
                                }
                                else{
                                    down2 = false;
                                    left2 = false;
                                    right2 = false;
                                }
                                break;
                            case 'D':
                                game[gh+down][gw] = 'D';
                                down += 1;
                                if(enemyHasShip('D',3)){
                                    if(0 < countSquares('A',game) &&
                                           countSquares('A',game) < 5)
                                        missMe('A');
                                    else if (0 < countSquares('B',game) &&
                                                 countSquares('B',game) < 4)
                                        missMe('B');
                                    else if (0 < countSquares('S',game) &&
                                                 countSquares('S',game) < 3)
                                        missMe('S');
                                    else if (countSquares('P',game) == 1)
                                        missMe('P');
                                    else
                                        hit = 0;
                                }
                                right2 = false;
                                left2 = false;
                                break;
                            default:
                                game[gh+down][gw] = fire;
                                if(totd == 1){
                                    down2 = false;
                                }
                                else{
                                    down2 = false;
                                    left2 = false;
                                    right2 = false;
                                }
                                break;
                        }
                    }
                    else if (canBe(gw,gh,3,1,game,'D') && up2){
                        char fire = opponentsBoard.fireAt(gh-up,gw);
                        switch (fire) {
                            case ' ':
                                game[gh-up][gw] = 'M';
                                if(totd == 1){
                                    up2 = false;
                                }
                                else{
                                    up2 = false;
                                    left2 = false;
                                    right2 = false;
                                }
                                break;
                            case 'D':
                                game[gh-up][gw] = 'D';
                                up += 1;
                                if(enemyHasShip('D',3)){
                                    if(0 < countSquares('A',game) &&
                                           countSquares('A',game) < 5)
                                        missMe('A');
                                    else if (0 < countSquares('B',game) &&
                                                 countSquares('B',game) < 4)
                                        missMe('B');
                                    else if (0 < countSquares('S',game) &&
                                                 countSquares('S',game) < 3)
                                        missMe('S');
                                    else if (countSquares('P',game) == 1)
                                        missMe('P');
                                    else
                                        hit = 0;
                                }
                                left2 = false;
                                right2 = false;
                                break;
                            default:
                                game[gh-up][gw] = fire;
                                if(totd == 1){
                                    up2 = false;
                                }
                                else{
                                    up2 = false;
                                    left2 = false;
                                    right2 = false;
                                }
                                break;
                        }
                    }
                    else if (canBe(gw,gh,3,0,game,'D') && right2){
                        char fire = opponentsBoard.fireAt(gh,gw+right);
                        switch (fire) {
                            case ' ':
                                game[gh][gw+right] = 'M';
                                if(totd == 1){
                                    right2 = false;
                                }
                                else{
                                    right2 = false;
                                    up2 = false;
                                    down2 = false;
                                }
                                break;
                            case 'D':
                                game[gh][gw+right] = 'D';
                                right += 1;
                                if(enemyHasShip('D',3)){
                                    if(0 < countSquares('A',game) &&
                                           countSquares('A',game) < 5)
                                        missMe('A');
                                    else if (0 < countSquares('B',game) &&
                                                 countSquares('B',game) < 4)
                                        missMe('B');
                                    else if (0 < countSquares('S',game) &&
                                                 countSquares('S',game) < 3)
                                        missMe('S');
                                    else if (countSquares('P',game) == 1)
                                        missMe('P');
                                    else
                                        hit = 0;
                                }
                                up2 = false;
                                down2 = false;
                                break;
                            default:
                                game[gh][gw+right] = fire;
                                if(totd == 1){
                                    right2 = false;
                                }
                                else{
                                    right2 = false;
                                    up2 = false;
                                    down2 = false;
                                }
                                break;
                        }
                    }
                    else if (canBe(gw,gh,3,0,game,'D') && left2){
                        char fire = opponentsBoard.fireAt(gh,gw-left);
                        switch (fire) {
                            case ' ':
                                game[gh][gw-left] = 'M';
                                if(totd == 1){
                                    left2 = false;
                                }
                                else{
                                    left2 = false;
                                    up2 = false;
                                    down2 = false;
                                }
                                break;
                            case 'D':
                                game[gh][gw-left] = 'D';
                                left += 1;
                                if(enemyHasShip('D',3)){
                                    if(0 < countSquares('A',game) &&
                                           countSquares('A',game) < 5)
                                        missMe('A');
                                    else if (0 < countSquares('B',game) &&
                                                 countSquares('B',game) < 4)
                                        missMe('B');
                                    else if (0 < countSquares('S',game) &&
                                                 countSquares('S',game) < 3)
                                        missMe('S');
                                    else if (countSquares('P',game) == 1)
                                        missMe('P');
                                    else
                                        hit = 0;
                                }
                                up2 = false;
                                down2 = false;
                                break;
                            default:
                                game[gh][gw-left] = fire;
                                if(totd == 1){
                                    left2 = false;
                                }
                                else{
                                    left2 = false;
                                    up2 = false;
                                    down2 = false;
                                }
                                break;
                        }
                    }
                    break;
                case 'P':
                    int totp = countSquares('P', game);
                    if (canBe(gw,gh,2,1,game,'P') && down2){
                        char fire = opponentsBoard.fireAt(gh+down,gw);
                        switch (fire) {
                            case ' ':
                                game[gh+down][gw] = 'M';
                                if(totp == 1){
                                    down2 = false;
                                }
                                else{
                                    down2 = false;
                                    right2 = false;
                                    left2 = false;
                                }
                                break;
                            case 'P':
                                game[gh+down][gw] = 'P';
                                down += 1;
                                if(enemyHasShip('P',2)){
                                    if(0 < countSquares('A',game) &&
                                           countSquares('A',game) < 5)
                                        missMe('A');
                                    else if (0 < countSquares('B',game) &&
                                                 countSquares('B',game) < 4)
                                        missMe('B');
                                    else if (0 < countSquares('S',game) &&
                                                 countSquares('S',game) < 3)
                                        missMe('S');
                                    else if (0 < countSquares('D',game) &&
                                                 countSquares('D',game) < 3)
                                        missMe('D');
                                    else
                                        hit = 0;
                                }
                                left2 = false;
                                right2 = false;
                                break;
                            default:
                                game[gh+down][gw] = fire;
                                if(totp == 1){
                                    down2 = false;
                                }
                                else{
                                    down2 = false;
                                    right2 = false;
                                    left2 = false;
                                }
                                break;
                        }
                    }
                    else if (canBe(gw,gh,2,1,game,'P') && up2){
                        char fire = opponentsBoard.fireAt(gh-up,gw);
                        switch (fire) {
                            case ' ':
                                game[gh-up][gw] = 'M';
                                if(totp == 1){
                                    up2 = false;
                                }
                                else{
                                    up2 = false;
                                    left2 = false;
                                    right2 = false;
                                }
                                break;
                            case 'P':
                                game[gh-up][gw] = 'P';
                                up += 1;
                                if(enemyHasShip('P',2)){
                                    if(0 < countSquares('A',game) &&
                                           countSquares('A',game) < 5)
                                        missMe('A');
                                    else if (0 < countSquares('B',game) &&
                                                 countSquares('B',game) < 4)
                                        missMe('B');
                                    else if (0 < countSquares('S',game) &&
                                                 countSquares('S',game) < 3)
                                        missMe('S');
                                    else if (0 < countSquares('D',game) &&
                                                 countSquares('D',game) < 3)
                                        missMe('D');
                                    else
                                        hit = 0;
                                }
                                left2 = false;
                                right2 = false;
                                break;
                            default:
                                game[gh-up][gw] = fire;
                                if(totp == 1){
                                    up2 = false;
                                }
                                else{
                                    up2 = false;
                                    left2 = false;
                                    right2 = false;
                                }
                                break;
                        }
                    }
                    else if (canBe(gw,gh,2,0,game,'P') && right2){
                        char fire = opponentsBoard.fireAt(gh,gw+right);
                        switch (fire) {
                            case ' ':
                                game[gh][gw+right] = 'M';
                                if(totp == 1){
                                    right2 = false;
                                }
                                else{
                                    right2 = false;
                                    up2 = false;
                                    down2 = false;
                                }
                                break;
                            case 'P':
                                game[gh][gw+right] = 'P';
                                right += 1;
                                if(enemyHasShip('P',2)){
                                    if(0 < countSquares('A',game) &&
                                           countSquares('A',game) < 5)
                                        missMe('A');
                                    else if (0 < countSquares('B',game) &&
                                                 countSquares('B',game) < 4)
                                        missMe('B');
                                    else if (0 < countSquares('S',game) &&
                                                 countSquares('S',game) < 3)
                                        missMe('S');
                                    else if (0 < countSquares('D',game) &&
                                                 countSquares('D',game) < 3)
                                        missMe('D');
                                    else
                                        hit = 0;
                                }
                                up2 = false;
                                down2 = false;
                                break;
                            default:
                                game[gh][gw+right] = fire;
                                if(totp == 1){
                                    right2 = false;
                                }
                                else{
                                    right2 = false;
                                    up2 = false;
                                    down2 = false;
                                }
                                break;
                        }
                    }
                    else if (canBe(gw,gh,2,0,game,'P') && left2){
                        char fire = opponentsBoard.fireAt(gh,gw-left);
                        switch (fire) {
                            case ' ':
                                game[gh][gw-left] = 'M';
                                if(totp == 1){
                                    left2 = false;
                                }
                                else{
                                    left2 = false;
                                    up2 = false;
                                    down2 = false;
                                }
                                break;
                            case 'P':
                                game[gh][gw-left] = 'P';
                                left += 1;
                                if(enemyHasShip('P',2)){
                                    if(0 < countSquares('A',game) &&
                                           countSquares('A',game) < 5)
                                        missMe('A');
                                    else if (0 < countSquares('B',game) &&
                                                 countSquares('B',game) < 4)
                                        missMe('B');
                                    else if (0 < countSquares('S',game) &&
                                                 countSquares('S',game) < 3)
                                        missMe('S');
                                    else if (0 < countSquares('D',game) &&
                                                 countSquares('D',game) < 3)
                                        missMe('D');
                                    else
                                        hit = 0;
                                }
                                up2 = false;
                                down2 = false;
                                break;
                            default:
                                game[gh][gw-left] = fire;
                                if(totp == 1){
                                    left2 = false;
                                }
                                else{
                                    left2 = false;
                                    up2 = false;
                                    down2 = false;
                                }
                                break;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * I didn't have to do much here to be honest.. I probably did something
     * wrong
     */
    public void reset() {
        hit = 0;
    }
    /**
     * modified version of the original hasShip method.
     * @param ship the ship I'm finding
     * @param num length of ship
     * @return 
     */
    private boolean hasShip(char ship, int num) {
        return (countSquares(ship, best) == num);
    }
    /**
     * Only difference here is that I didn't feel like creating another
     * char[][] parameter, so I created a method for my "game" char[][].
     * @param ship
     * @param num
     * @return 
     */
    private boolean enemyHasShip(char ship, int num){
        return (countSquares(ship, game) == num);
    }
    
    /**
     * Counts squares of ships on the board.
     * @param ship
     * @param temp
     * @return 
     */
    private int countSquares(char ship, char[][] temp) {
        int total = 0;
        for (int i=0; i<10; i++) {
            for (int j=0; j<10; j++) {
                if (temp[i][j] == ship) {
                    total++;
                }
            }
        }
        return total;
    }
    /**
     * Originally, this method was much smaller, but I fixed it so that ships
     * are not touching side by side as much. The first "if" statement tries
     * to find if there's anything around the chosen width and height. If there
     * is, it returns false. The second part is just an over complicated counter.
     * It counts left, right, up, and down the number of squares that also have 
     * nothing surrounding it. For example, if placing the ship in any square that
     * touches another ship, it breaks and stops counting. If the total count
     * doesn't at least equal the size of the ship, then it returns false and 
     * looks for another place to hide the ship. There is a predetermined
     * orientation too, so even if it could fit vertically in a spot, it will
     * only look horizontally if that's the preset orientation. 
     * @param w width
     * @param h height
     * @param l length of ship
     * @param o orientation
     * @param temp char[][] to be used
     * @return 
     */
    
    private boolean canPlace(int w, int h, int l, int o, char[][] temp){
    
        if (best[h][w] != ' ')
            return false;
        else{
            if(h-1 < 0){
                if(w-1 < 0){
                    if(best[h][w+1] != ' ' ||
                       best[h+1][w] != ' ')
                       return false;
                }
                else if(w+1 > 9){
                    if(best[h][w-1] != ' ' ||
                       best[h+1][w] != ' ')
                       return false;
                }
                else{
                    if(best[h][w-1] != ' ' ||
                       best[h][w+1] != ' ' ||
                       best[h+1][w] != ' ')
                       return false;
                }
            }
            else if (h+1 > 9){
                if(w-1 < 0){
                    if(best[h][w+1] != ' ' ||
                       best[h-1][w] != ' ')
                       return false;
                }
                else if(w+1 > 9){
                    if(best[h][w-1] != ' ' ||
                       best[h-1][w] != ' ')
                       return false;
                }
                else{
                    if(best[h][w-1] != ' ' ||
                       best[h][w+1] != ' ' ||
                       best[h-1][w] != ' ')
                       return false;
                }
            }
            else{
                if(w-1 < 0){
                    if(best[h][w+1] != ' ' ||
                       best[h-1][w] != ' ' ||
                       best[h+1][w] != ' ')
                       return false;
                }
                else if(w+1 > 9){
                    if(best[h][w-1] != ' ' ||
                       best[h-1][w] != ' ' ||
                       best[h+1][w] != ' ')
                       return false;
                }
                else{
                    if(best[h][w-1] != ' ' ||
                       best[h][w+1] != ' ' ||
                       best[h-1][w] != ' ' ||
                       best[h+1][w] != ' ')
                       return false;
                }
            }
            if (o == 1){
                int count1 = 0;
                int count0 = 0;
                for(int i = 1; i < h; i++){
                    try{
                        if(h-(i+1) < 0){
                            if(w-1 < 0){
                                if(best[h-i][w] != ' ' ||
                                   best[h-i][w+1] != ' ')
                                    break;
                                else
                                    count1++;
                            }
                            else if (w+1 > 9){
                                if(best[h-i][w] != ' ' ||
                                   best[h-i][w-1] != ' ' )
                                   break;
                                else
                                    count1++;
                            }
                            else{
                                if(best[h-i][w] != ' ' ||
                                   best[h-i][w-1] != ' ' ||
                                   best[h-i][w+1] != ' ')
                                   break;
                                else
                                    count1++;
                            }
                        }
                        else{
                            if(w-1 < 0){
                                if(best[h-i][w] != ' ' ||
                                   best[h-i][w+1] != ' ' ||
                                   best[h-(i+1)][w] != ' ')
                                    break;
                                else
                                    count1++;
                            }
                            else if (w+1 > 9){
                                if(best[h-i][w] != ' ' ||
                                   best[h-i][w-1] != ' ' ||
                                   best[h-(i+1)][w] != ' ')
                                   break;
                                else
                                    count1++;
                            }
                            else{
                                if(best[h-i][w] != ' ' ||
                                   best[h-i][w-1] != ' ' ||
                                   best[h-i][w+1] != ' ' ||
                                   best[h-(i+1)][w] != ' ')
                                   break;
                                else
                                    count1++;
                            }
                        }     
                    }
                    catch(Exception ArrayIndexOutOfBoundsException){
                        break;
                    }
                }
                for(int j = 1; j < h; j++){
                    try{
                        if(h+(j+1) > 9){
                            if(w-1 < 0){
                                if(best[h+j][w] != ' ' ||
                                   best[h+j][w+1] != ' ')
                                    break;
                                else
                                    count0++;
                            }
                            else if (w+1 > 9){
                                if(best[h+j][w] != ' ' ||
                                   best[h+j][w-1] != ' ' )
                                   break;
                                else
                                    count0++;
                            }
                            else{
                                if(best[h+j][w] != ' ' ||
                                   best[h+j][w-1] != ' ' ||
                                   best[h+j][w+1] != ' ')
                                   break;
                                else
                                    count0++;
                            }
                        }
                        else{
                            if(w-1 < 0){
                                if(best[h+j][w] != ' ' ||
                                   best[h+j][w+1] != ' ' ||
                                   best[h+(j+1)][w] != ' ')
                                    break;
                                else
                                    count0++;
                            }
                            else if (w+1 > 9){
                                if(best[h+j][w] != ' ' ||
                                   best[h+j][w-1] != ' ' ||
                                   best[h+(j+1)][w] != ' ')
                                   break;
                                else
                                    count0++;
                            }
                            else{
                                if(best[h+j][w] != ' ' ||
                                   best[h+j][w-1] != ' ' ||
                                   best[h+j][w+1] != ' ' ||
                                   best[h+(j+1)][w] != ' ')
                                   break;
                                else
                                    count0++;
                            }
                        }
                    }
                    catch(Exception ArrayIndexOutOfBoundsException){
                        break;
                    } 
                }
                return (count0+count1+1 >= l);  
            }
            else{
                int count1 = 0;
                int count0 = 0;
                for(int i = 1; i < w; i++){
                    try{
                        if(w-(i+1) < 0){
                            if(h-1 < 0){
                                if(best[h][w-i] != ' ' ||
                                   best[h+1][w-i] != ' ')
                                    break;
                                else
                                    count1++;
                            }
                            else if (h+1 > 9){
                                if(best[h][w-i] != ' ' ||
                                   best[h-1][w-i] != ' ' )
                                   break;
                                else
                                    count1++;
                            }
                            else{
                                if(best[h][w-i] != ' ' ||
                                   best[h-1][w-i] != ' ' ||
                                   best[h+1][w-i] != ' ')
                                   break;
                                else
                                    count1++;
                            }
                        }
                        else{
                            if(h-1 < 0){
                                if(best[h][w-i] != ' ' ||
                                   best[h+1][w-i] != ' ' ||
                                   best[h][w-(i+1)] != ' ')
                                    break;
                                else
                                    count1++;
                            }
                            else if (h+1 > 9){
                                if(best[h][w-i] != ' ' ||
                                   best[h-1][w-i] != ' ' ||
                                   best[h][w-(i+1)] != ' ')
                                   break;
                                else
                                    count1++;
                            }
                            else{
                                if(best[h][w-i] != ' ' ||
                                   best[h-1][w-i] != ' ' ||
                                   best[h+1][w-1] != ' ' ||
                                   best[h][w-(i+1)] != ' ')
                                   break;
                                else
                                    count1++;
                            }
                        }
                    }
                    catch(Exception ArrayIndexOutOfBoundsException){
                        break;
                    }
                }
                for(int j = 1; j < w; j++){
                    try{
                        if(w+(j+1) > 9){
                            if(h-1 < 0){
                                if(best[h][w+j] != ' ' ||
                                   best[h+1][w+j] != ' ')
                                    break;
                                else
                                    count0++;
                            }
                            else if(h+1 > 9){
                                if(best[h][w+j] != ' ' ||
                                   best[h-1][w+j] != ' ' )
                                   break;
                                else
                                    count0++;
                            }
                            else{
                                if(best[h][w+j] != ' ' ||
                                   best[h-1][w+j] != ' ' ||
                                   best[h+1][w+j] != ' ')
                                   break;
                                else
                                    count0++;
                            }
                        }
                        else{
                            if(h-1 < 0){
                                if(best[h][w+j] != ' ' ||
                                   best[h+1][w+j] != ' ' ||
                                   best[h][w+(j+1)] != ' ')
                                    break;
                                else
                                    count0++;
                            }
                            else if(h+1 > 9){
                                if(best[h][w+j] != ' ' ||
                                   best[h-1][w+j] != ' ' ||
                                   best[h][w+(j+1)] != ' ')
                                   break;
                                else
                                    count0++;
                            }
                            else{
                                if(best[h][w+j] != ' ' ||
                                   best[h-1][w+j] != ' ' ||
                                   best[h+1][w+j] != ' ' ||
                                   best[h][w+(j+1)] != ' ')
                                   break;
                                else
                                    count0++;
                            }
                        }
                    }
                    catch(Exception ArrayIndexOutOfBoundsException){
                        break;
                    }
                }
                return (count0+count1+1 >= l);
            }
        }
    }
    

    
    /**
     * This is basically what the original "canPlace" looked like. It searches
     * the surrounding area to see if a ship can actually go in the desired
     * direction (given the already fire upon squares). It's also a counter.
     * The great thing about this method is when I calculated whether or not it
     * can fit vertically or horizontally, my algorithm will ignore that direction
     * completely. Eliminating another redundant step. 
     * @param w width
     * @param h height
     * @param l size of ship
     * @param o orientation
     * @param temp 2D char array
     * @param p I needed the char in this method so that if by accident there 
     * were more than one char of that same kind already found, it would count it
     * as a possible square to place the ship. Otherwise, anything other than a 
     * blank (' ') would be dismissed as unavailable. 
     * 
     * @return 
     */
    private boolean canBe(int w, int h, int l, int o, char[][] temp, char p){
        if (o == 1){
            int count1 = 0;
            int count0 = 0;
            for(int i = 1; i <= l; i++){
                try{
                    if(temp[h-i][w] == ' ' ||
                       temp[h-i][w] == p)
                        count1++;
                    else
                        break;
                }
                catch(Exception ArrayIndexOutOfBoundsException){
                    break;
                }
            }
            for(int j = 1; j <= l; j++){
                try{
                    if(temp[h+j][w] == ' ' ||
                       temp[h+j][w] == p)
                        count0++;
                    else
                        break;
                }
                catch(Exception ArrayIndexOutOfBoundsException){
                    break;
                } 
            }
            return (count0+count1+1 >= l);  
        }
        else{
            int count1 = 0;
            int count0 = 0;
            for(int i = 1; i <= l; i++){
                try{
                    if(temp[h][w-i] == ' ' ||
                       temp[h][w-i] == p)
                        count1++;
                    else
                        break;
                }
                catch(Exception ArrayIndexOutOfBoundsException){
                    break;
                }
            }
            for(int j = 1; j <= l; j++){
                try{
                    if(temp[h][w+j] == ' ' ||
                       temp[h][w+j] == p)
                        count0++;
                    else
                        break;
                }
                catch(Exception ArrayIndexOutOfBoundsException){
                    break;
                }
            }
            return (count0+count1+1 >= l);
        }
    }
    
    
    /**
     * This little method here allows me to search for the ship I found while
     * destroying another ship. It sets the width and height to that location,
     * resets all of the required parameters and goes straight back to taking
     * down the ship by setting "hit" to 1.
     * @param p char (ship) to be found.
     */
    private void missMe(char p){
        for(int i = 0; i<10; i++){
            for(int j = 0; j<10; j++){
                if (game[i][j] == p){
                    gh = i;
                    gw = j;
                    hit = 1;
                    up = 1;
                    down = 1; 
                    right = 1;
                    left = 1;
                    up2 = true;
                    down2 = true;
                    right2 = true;
                    left2 = true;
                    break;
                }
            }
        }
    }
        

}
