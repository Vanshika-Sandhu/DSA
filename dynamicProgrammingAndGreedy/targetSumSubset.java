// 1. You are given a number n, representing the count of elements.
// 2. You are given n numbers.
// 3. You are given a number "tar".
// 4. You are required to calculate and print true or false, if there is a subset the elements of which add 
//      up to "tar" or not.

// Sample Input
// 5
// 4
// 2
// 7
// 1
// 3
// 10
// Sample Output
// true

package dynamicProgrammingAndGreedy;
import java.util.*;

public class targetSumSubset {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        
        // tabulation
        boolean[][] dp = new boolean[n+1][tar+1];
        
        for(int i = 0; i<n+1; i++){
            for(int j=0; j<tar+1; j++){
                if(i==0&&j==0){
                    dp[i][j] = true;
                }else if(i==0){
                    dp[i][j] = false;
                }else if(j==0){
                    dp[i][j] = true;
                }else{
                    if(dp[i-1][j]==true){
                        dp[i][j] = true;
                    }else{
                        int val = arr[i-1];
                        if(j>=val){
                            if(dp[i-1][j-val]==true){
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        
        System.out.println(dp[n][tar]);
        
        scn.close();
    }
}
