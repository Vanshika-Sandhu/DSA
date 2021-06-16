// 1. You are given a number n, representing the number of days.
// 2. You are given n numbers, where ith number represents price of stock on ith day.
// 3. You are required to print the maximum profit you can make if you are allowed a single transaction.

// Sample Input
// 9
// 11
// 6
// 7
// 19
// 4
// 1
// 6
// 18
// 4
// Sample Output
// 17

package dynamicProgrammingAndGreedy;
import java.util.*;

public class buyAndSellStocks1{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        
        int[] dp = new int[n+1];
        int min = arr[0];
        int maxProfit = Integer.MIN_VALUE; 
        for(int i=2; i<n+1; i++){
            dp[i] = arr[i-1] - min;
            if(arr[i-1]<min){
                min = arr[i-1];
            }
            if(maxProfit<dp[i]){
                maxProfit = dp[i];
            }
        }
        
        System.out.println(maxProfit);

        scn.close();
    }
}