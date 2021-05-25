// 1. You are given a number n, the size of a chess board.
// 2. You are required to place n number of queens in the n * n cells of board such that no queen can 
//      kill another.
// Note - Queens kill at distance in all 8 directions
// 3. Complete the body of printNQueens function - without changing signature - to calculate and 
//      print all safe configurations of n-queens


// Sample Input
// 4
// Sample Output
// 0-1, 1-3, 2-0, 3-2, .
// 0-2, 1-0, 2-3, 3-1, .

// time complexity => 0(n);

// APPROACH FOR THE QUESTION
// consider 3 boolean arrays to check the safe positions of the queen i.e. array for columns of size n,
// for normal diagonal of size 2*n-1, and same for reverse diagonal
// mark the indices as true if required when given in the question each index represent either a col or a diagonal
// iterate for the length of the column 


package recursionLevel2;


import java.util.*;

public class NQueensBnB {
    
    public static void solve(boolean[][] board, boolean[] cols, boolean[] ndiag, boolean[] rdiag, int row, String asf ){
        // base case
        if(row == board.length){
            System.out.println(asf+".");
            return;
        }
        
        
        // a loop for columns
        for(int col = 0; col<board.length; col++){
            // check if the position is valid for the queen to be placed
            if(cols[col]==false && ndiag[row+col]==false && rdiag[row-col+board.length-1]==false ){
                // mark everything true before function and move forward for function call
               board[row][col] = true;
               cols[col] = true;
               ndiag[row+col] = true;
               rdiag[row-col+board.length-1] = true;
               
            //   function call
            solve(board, cols, ndiag, rdiag, row+1, asf+row+"-"+col+", ");
            
            //   convert everything false while coming back
               board[row][col] = false;
               cols[col] = false;
               ndiag[row+col] = false;
               rdiag[row-col+board.length-1] = false;
               
               
            }
        }
    }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    // chess board
    boolean[][] board = new boolean[n][n];
    // array to mark columns if filled or not
    boolean[] cols = new boolean[n];
    // array to mark normal diagonal if filled or not, here a cell sums as row+col 
    // i.e. cells [0,2], [1,1], [2,0], belong to diagonal 3 and their sum being [row+col] = 2 =>3-1
    boolean[] ndiag = new boolean[2*n -1];
    // array to mark normal diagonal if filled or not, here a cell sums as row-col+board.length-1 
    // i.e. cells [0,1], [1,2], [2,3], belong to diagonal 3 and their sum being [row-col+board.length-1] = 2
    boolean[] rdiag = new boolean[2*n -1];

    solve(board, cols, ndiag, rdiag, 0, "");

    scn.close();
    
  }

}