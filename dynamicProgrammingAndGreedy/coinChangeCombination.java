// 1. You are given a number n, representing the count of coins.
// 2. You are given n numbers, representing the denominations of n coins.
// 3. You are given a number "amt".
// 4. You are required to calculate and print the number of combinations of the n coins using which the 
//      amount "amt" can be paid.

// Note1 -> You have an infinite supply of each coin denomination i.e. same coin denomination can be 
//                   used for many installments in payment of "amt"
// Note2 -> You are required to find the count of combinations and not permutations i.e.
//                   2 + 2 + 3 = 7 and 2 + 3 + 2 = 7 and 3 + 2 + 2 = 7 are different permutations of same 

package dynamicProgrammingAndGreedy;
import java.util.*;

public class coinChangeCombination {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        
        int amt = scn.nextInt();
        
        int[] dp = new int[amt+1];
        
        dp[0] = 1;
        
        for(int i=0; i<n; i++){
            // j only for the array values -> helps prevent permutation
            for(int j=arr[i]; j<amt+1; j++){
                dp[j]+=dp[j-arr[i]];
            }
        }
        
        System.out.println(dp[amt]);

        scn.close();
    }
    
}
