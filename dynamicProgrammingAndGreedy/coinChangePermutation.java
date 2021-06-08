// 1. You are given a number n, representing the count of coins.
// 2. You are given n numbers, representing the denominations of n coins.
// 3. You are given a number "amt".
// 4. You are required to calculate and print the number of permutations of the n coins using which the 
//      amount "amt" can be paid.

// Note1 -> You have an infinite supply of each coin denomination i.e. same coin denomination can be 
//                   used for many installments in payment of "amt"
// Note2 -> You are required to find the count of permutations and not combinations i.e.
//                   2 + 2 + 3 = 7 and 2 + 3 + 2 = 7 and 3 + 2 + 2 = 7 are different permutations of same 
//                   combination. You should treat them as 3 and not 1.

// Sample Input
// 4
// 2
// 3
// 5
// 6
// 7
// Sample Output
// 5

package dynamicProgrammingAndGreedy;
import java.util.*;

public class coinChangePermutation {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        // tabulation
        // meaning of each cell => how many ways are there in which you can pay the money in the mentioned cell
        int[] dp = new int[tar+1];
        
        // there is only one way to pay 0 money that is don't give money
        dp[0] = 1;
        
        for(int amt=1; amt<tar+1; amt++){
            for(int coin : dp){
                if(coin<=amt){
                    int rAmt = amt-coin;
                    dp[amt] += dp[rAmt];
                }
            }
        }
        
        System.out.println(dp[tar]);
        scn.close();
    }
    
}
