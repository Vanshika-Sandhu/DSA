// 1. You are given a number n, representing the number of days.
// 2. You are given n numbers, where ith number represents price of stock on ith day.
// 3. You are given a number k, representing the number of transactions allowed.
// 3. You are required to print the maximum profit you can make if you are allowed k transactions at-most.
// Note - There can be no overlapping transaction. One transaction needs to be closed
// (a buy followed by a sell) before openinganother transaction (another buy).

// Sample Input
// 6
// 9
// 6
// 7
// 6
// 3
// 8
// 1

// Sample Output
// 5

package dynamicProgrammingAndGreedy;
import java.util.*;

public class buyAndSellStocks6KTransactionsAllowed {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        
        int[][] dp = new int[k+1][n];

        // APPROACH 1 => 0(n*n*n)
        // for(int t=1; t<=k; t++){
        //     for(int d=1; d<n; d++){
        //         dp[t][d] = dp[t][d-1];
                
        //         for(int pd=0; pd<d; pd++){
        //             int ptilltm1 = dp[t-1][pd];
        //             int ptth = arr[d] - arr[pd];
        //             if(ptilltm1+ptth >dp[t][d]){
        //                 dp[t][d] = ptilltm1 + ptth;
        //             }
        //         }
        //     }
        // }

        // APPROACH 2 => optimized => 0(n*n)
        for(int t=1; t<=k; t++){
            int max = Integer.MIN_VALUE;
            for(int d=1; d<n; d++){
                if(dp[t-1][d-1] - arr[d-1] > max){
                    max = dp[t-1][d-1] - arr[d-1];
                }
                if(max+arr[d] > dp[t][d-1]){
                    dp[t][d] = max + arr[d];
                }else{
                    dp[t][d] = dp[t][d-1];
                }
            }
        }
        
        System.out.println(dp[k][n-1]);

        scn.close();
    }
}
