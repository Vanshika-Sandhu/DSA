// 1. You are given a number n, representing the number of elements.
// 2. You are given a number k, representing the number of subsets.
// 3. You are required to print the number of ways in which these elements can be partitioned in k non-empty subsets.
// E.g.
// For n = 4 and k = 3 total ways is 6
// 12-3-4
// 1-23-4
// 13-2-4
// 14-2-3
// 1-24-3
// 1-2-34

// Sample Input
// 4
// 3
// Sample Output
// 6

package dynamicProgrammingAndGreedy;
import java.util.*;

public class partitionIntoSubsets {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int k = scn.nextInt();

        long[][] dp = new long[k+1][n+1];
        for(int i=1; i<k+1; i++){
            for(int j=1; j<n+1; j++){
                if(i==1 || i==j){
                    dp[i][j] = 1;
                }else if(j<i){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = i*dp[i][j-1] + dp[i-1][j-1];
                }
            }
        }
        System.out.println(dp[k][n]);
        
        scn.close();
    }
    
}
