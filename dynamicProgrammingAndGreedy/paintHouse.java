// 1. You are given a number n, representing the number of houses.
// 2. In the next n rows, you are given 3 space separated numbers representing the cost of painting nth house
// with red or blue or green color.
// 3. You are required to calculate and print the minimum cost of painting all houses without painting any
// consecutive house with same color.

// Sample Input
// 4
// 1 5 7
// 5 8 4
// 3 2 9
// 1 2 4
// Sample Output
// 8

package dynamicProgrammingAndGreedy;

import java.util.*;

public class paintHouse {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        
        int n = scn.nextInt();
        int[][] arr = new int[n][3];
        for(int i=0; i<n; i++){
            for(int j=0; j<3; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        
        int[][] dp = new int[n][3];
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        for(int i=1; i<n; i++){
            dp[i][0] = arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = arr[i][1] + Math.min(dp[i-1][2], dp[i-1][0]);
            dp[i][2] = arr[i][2] + Math.min(dp[i-1][1], dp[i-1][0]);
        }
        
        
        System.out.println(Math.min(dp[n-1][2], Math.min(dp[n-1][1], dp[n-1][0])));

        scn.close();
    }
    
}
