// 1. You are give a partially filled 9*9 2-D array(arr) which represents an incomplete sudoku state.
// 2. You are required to assign the digits from 1 to 9 to the empty cells following some rules.
// Rule 1 -> Digits from 1-9 must occur exactly once in each row.
// Rule 2 -> Digits from 1-9 must occur exactly once in each column.
// Rule 3 -> Digits from 1-9 must occur exactly once in each 3x3 sub-array of the given 2D array.

// Assumption -> The given Sudoku puzzle will have a single unique solution.

// Sample Input
// 3 0 6 5 0 8 4 0 0
// 5 2 0 0 0 0 0 0 0
// 0 8 7 0 0 0 0 3 1
// 0 0 3 0 1 0 0 8 0
// 9 0 0 8 6 3 0 0 5
// 0 5 0 0 9 0 6 0 0
// 1 3 0 0 0 0 2 5 0
// 0 0 0 0 0 0 0 7 4
// 0 0 5 2 0 6 3 0 0
// Sample Output
// 3 1 6 5 7 8 4 9 2 
// 5 2 9 1 3 4 7 6 8 
// 4 8 7 6 2 9 5 3 1 
// 2 6 3 4 1 5 9 8 7 
// 9 7 4 8 6 3 1 2 5 
// 8 5 1 7 9 2 6 4 3 
// 1 3 8 9 4 7 2 5 6 
// 6 9 2 3 5 1 8 7 4 
// 7 4 5 2 8 6 3 1 9 

package recursionLevel2;


import java.util.*;

public class sudoku {
    public static void display(int[][] board){
        for(int i = 0; i < board.length; i++){
          for(int j = 0; j < board[0].length; j++){
            System.out.print(board[i][j] + " ");
          }
        System.out.println();
        }
    }

    public static boolean isValid(int[][] board, int i, int j, int po){
        // check for row
        for(int x = 0; x<board.length; x++){
            if(board[x][j] == po)
                return false;
        }

        // check for column
        for(int y = 0; y<board.length; y++){
            if(board[i][y] == po)
                return false;
        }

        // check for submatrix
        // to obtain the corner of submatrix
        int smi = (i/3)*3;
        int smj = (j/3)*3;
        for(int x = 0; x<3; x++){
            for(int y = 0; y<3; y++){
                if(board[x+smi][y+smj] == po)
                    return false;
            }
        }

        return true;
    }

    public static void solveSudoku(int[][] board, int i, int j) {

        // base case
        if(i == board.length){  // i.e. for a board of 9 rows from 0->8, if i == 9, print the solved combination
            System.out.println("\nSolution of he given sudoku\n");
            display(board);
            return;
        }

        // values for next cell
        int ni = 0; 
        int nj = 0;

        // set value for next cell
        // eg => if cell is [0,8] i.e. i = 0 and j = 8, set i = 1 and j = 0 to get to cell [1,0]
        if(j == board.length-1){
            ni = i + 1;    // increase the row
            nj = 0;       
        }else{
            ni = i;
            nj = j+1;      // increase the column
        }

        // check for the value of cell
        // if value != 0, just call the function and move forward doing nothing
        // if not, then check if any of the possible options are valid.
        // If yes, put the value in the cell and function call. keep in mind, to set the value of cell as 0
        // after function call so that backtracking could be achieved
        if(board[i][j] != 0){
            solveSudoku(board, ni, nj);
        }else{
            for(int po = 1; po<=9; po++){
                if(isValid(board, i, j, po)){
                    board[i][j] = po;
                    solveSudoku(board, ni, nj);
                    board[i][j] = 0;
                }
            }
        }
        return;

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter the sudoku matrix");

        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        solveSudoku(arr, 0, 0);

        scn.close();
    }
    
}
