// 1. You are given a number n and a number m separated by line-break representing the length and breadth of a
// n * m floor.
// 2. You've an infinite supply of m * 1 tiles.
// 3. You are required to calculate and print the number of ways floor can be tiled using tiles.

// Sample Input
// 39
// 16
// Sample Output
// 61

package dynamicProgrammingAndGreedy;
import java.util.*;

public class tilingWithMx1Tiles {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int m = scn.nextInt();
        
        int[] dp = new int[n+1];
        for(int i=1; i<n+1; i++){
            // for all the values of i<m there is only one way => i tiles vertically
           if(i<m){
               dp[i] = 1;
           }
            // for i == m two ways => m tiles vertically    or    m tiles horizontally   
           else if(i==m){
               dp[i] = 2;
           }else{
               dp[i] = dp[i-1] + dp[i-m];
           }
        }
        
        System.out.println(dp[n]);
        scn.close();
    }
    
}
