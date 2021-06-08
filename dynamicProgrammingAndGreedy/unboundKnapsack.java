// 1. You are given a number n, representing the count of items.
// 2. You are given n numbers, representing the values of n items.
// 3. You are given n numbers, representing the weights of n items.
// 3. You are given a number "cap", which is the capacity of a bag you've.
// 4. You are required to calculate and print the maximum value that can be created in the bag without 
//     overflowing it's capacity.
// Note -> Each item can be taken any number of times. You are allowed to put the same item again 
//                   and again.

// Sample Input
// 5
// 15 14 10 45 30
// 2 5 1 3 4
// 7
// Sample Output
// 100

package dynamicProgrammingAndGreedy;
import java.util.*;

public class unboundKnapsack {
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
        
        int[] dp = new int[cap+1];
        dp[0] = 0;
        for(int bagc=1; bagc<cap+1; bagc++){
            int max = 0;
            for(int j=0; j<n; j++){
                if(weight[j]<=bagc){
                    int rbagc = bagc - weight[j];
                    int rbagval = dp[rbagc];
                    int tbagval = rbagval + val[j];
                    
                    if(tbagval>max){
                        max = tbagval;
                    }
                }
            }
            dp[bagc] = max;
        }
        
        System.out.println(dp[cap]);

        scn.close();
    }
    
}
