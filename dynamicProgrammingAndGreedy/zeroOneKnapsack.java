// 1. You are given a number n, representing the count of items.
// 2. You are given n numbers, representing the values of n items.
// 3. You are given n numbers, representing the weights of n items.
// 3. You are given a number "cap", which is the capacity of a bag you've.
// 4. You are required to calculate and print the maximum value that can be created in the bag without 
//      overflowing it's capacity.

// Note -> Each item can be taken 0 or 1 number of times. You are not allowed to put the same item 
//                again and again.

// Sample Input
// 5
// 15 14 10 45 30
// 2 5 1 3 4
// 7
// Sample Output
// 75

// APPROACH
// tabulation
// meaning of cell => for dp[3][5] , for a bag of 5 kg of value corresponding to the subset of [2-15, 5-14, 1-10], 
//                    what is the max value that can be filled in the cell.

package dynamicProgrammingAndGreedy;
import java.util.*;

public class zeroOneKnapsack {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] val = new int[n];
        for(int i=0; i<n; i++){
            val[i] = scn.nextInt();
        }
        int[] weight = new int[n];
        for(int i=0; i<n; i++){
            weight[i] = scn.nextInt();
        }
        int cap = scn.nextInt();

        
        int[][] dp = new int[n+1][cap+1];


        
        for(int i=1; i<n+1; i++){
            for(int j=1; j<cap+1; j++){
                // when val[i-1] doesn't take part
                int d1 = dp[i-1][j]; 
                dp[i][j] = d1;
                
                // when val[i-1] takes part
                int rWeight = j-weight[i-1];
                if(rWeight>=0){
                    int d2 = dp[i-1][rWeight] + val[i-1];
                    if(d2>d1){
                        dp[i][j] = d2;
                    }
                }
            }
        }
        
        System.out.println(dp[n][cap]);


        scn.close();
    }
    
}
