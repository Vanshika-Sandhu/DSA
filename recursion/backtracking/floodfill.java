// 1. You are given a number n, representing the number of rows.
// 2. You are given a number m, representing the number of columns.
// 3. You are given n*m numbers, representing elements of 2d array a. The numbers can be 1 or 0 only.
// 4. You are standing in the top-left corner and have to reach the bottom-right corner. 
// Only four moves are allowed 't' (1-step up), 'l' (1-step left), 'd' (1-step down) 'r' (1-step right).
// You can only move to cells which have 0 value in them. You can't move out of the boundaries or in the cells which have value 1 in them (1 means obstacle)

// also a question of depth first search

// input
// 3 3
// 0 0 0
// 1 0 1
// 0 0 0

// output
// rddr

import java.util.*;

public class floodfill {

    public static void floodFill(int[][] arr, int sr, int sc, String asf, boolean[][] check){

        if(sr<0 || sc<0 || sr == arr.length || sc == arr[0].length || arr[sr][sc] == 1 || check[sr][sc] == true){
            return;
        }
        else if(sr == arr.length-1 && sc == arr[0].length-1){
            System.out.println(asf);
        }

        check[sr][sc] = true;
        // top
        floodFill(arr, sr-1, sc, asf + "t", check);
        // left
        floodFill(arr, sr, sc-1, asf + "l", check);
        // down
        floodFill(arr, sr+1, sc, asf + "d", check);
        // right
        floodFill(arr, sr, sc+1, asf + "r", check);
        check[sr][sc] = false;

        return;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter no of rows");
        int n = scn.nextInt();
        System.out.println("Enter no. of columns");
        int m = scn.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        boolean[][] check = new boolean[n][m];
        floodFill(arr, 0, 0, "", check );

        scn.close();
    }
}
