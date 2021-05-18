// 1. You are given a number n, the size of a chess board.
// 2. You are required to place n number of queens in the n * n cells of board such that no queen can kill another.
// Note - Queens kill at distance in all 8 directions

// input
// 4

// output
// 0-1, 1-3, 2-0, 3-2, .
// 0-2, 1-0, 2-3, 3-1, .

package recursionLevel1.backtracking;


import java.util.*;

public class NQueens {

    public static boolean isQueenSafe(int[][] chess, int row, int col){
        // vertical
        for(int i = row-1, j = col; i>=0; i--){
            if(chess[i][j] == 1){
                return false;
            }

        }

        // left diagonal
        for(int i = row-1, j = col-1; i>=0 && j>=0; i--, j--){
            if(chess[i][j] == 1){
                return false;
            }
        }

        // right diagonal
        for(int i = row-1, j = col+1; i>=0 && j<chess.length; i--, j++){
            if(chess[i][j] == 1){
                return false;
            }
        }



        return true;

    }

    public static void printNQueens(int[][] chess, String qsf, int row) {
        if(row == chess.length){
            System.out.println(qsf + ".");
            return;
        }
        if(row>chess.length){
            return;
        }
        
        for(int col = 0; col<chess.length; col++){
            chess[row][col] = 1;
            if(isQueenSafe(chess, row, col) == true){
                printNQueens(chess, qsf + row + "-" + col + ", ", row+1);
            }
            chess[row][col] = 0;
        }

        return;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter no. of rows ");
        int n = scn.nextInt();
        int[][] chess = new int[n][n];

        printNQueens(chess, "", 0);

        scn.close();
    }
    
}
