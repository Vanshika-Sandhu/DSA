// 1. You are given a number n, the size of a chess board.
// 2. You are given a row and a column, as a starting point for a knight piece.
// 3. You are required to generate the all moves of a knight starting in (row, col) such that knight visits 
//      all cells of the board exactly once.
// 4. Calculate and print all configurations of the chess board representing the route
//      of knight through the chess board. Use sample input and output to get more idea.

// Note -> When moving from (r, c) to the possible 8 options give first precedence to (r - 2, c + 1) and 
//                move in clockwise manner to
//                explore other options.


// input
// 5
// 2
// 0

// output

// 25 2 13 8 23 
// 12 7 24 3 14 
// 1 18 15 22 9 
// 6 11 20 17 4 
// 19 16 5 10 21 

// 19 2 13 8 21 
// 12 7 20 3 14 
// 1 18 15 22 9 
// 6 11 24 17 4 
// 25 16 5 10 23  .... and many more


import java.util.*;


public class knightsTour {

    public static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove) {

        if( r<0 || c<0 ||r>=chess.length || c>=chess.length || chess[r][c]>0 ){
            return;
        }else if(upcomingMove == chess.length*chess.length){
            chess[r][c] = upcomingMove;
            displayBoard(chess);
            chess[r][c] = 0;
            return;
        }

        chess[r][c] = upcomingMove;
        printKnightsTour(chess,r-2, c+1, upcomingMove+1 );
        printKnightsTour(chess,r-1, c+2, upcomingMove+1 );
        printKnightsTour(chess,r+1, c+2, upcomingMove+1 );
        printKnightsTour(chess,r+2, c+1, upcomingMove+1 );
        printKnightsTour(chess,r+2, c-1, upcomingMove+1 );
        printKnightsTour(chess,r+1, c-2, upcomingMove+1 );
        printKnightsTour(chess,r-1, c-2, upcomingMove+1 );
        printKnightsTour(chess,r-2, c-1, upcomingMove+1 );
        chess[r][c] = 0;
        return;
        
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter dimension of the chess board");
        int n = scn.nextInt();
        System.out.println("Enter row of the knight");
        int r = scn.nextInt();
        System.out.println("Enter column of the knight");
        int c = scn.nextInt();

        int[][] chess = new int[n][n];

        printKnightsTour(chess, r, c, 1);

        scn.close();
    }    
}
