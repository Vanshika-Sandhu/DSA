// 1. You are given a number n, representing the number of days.
// 2. You are given n numbers, where ith number represents price of stock on ith day.
// 3. You are required to print the maximum profit you can make if you are allowed infinite transactions, but have
// to cooldown for 1 day after 1 transaction
// i.e. you cannot buy on the next day after you sell, you have to cooldown for a day at-least before buying again.
// Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell)
// before opening another transaction (another buy).

// Sample Input
// 12
// 10
// 15
// 17
// 20
// 16
// 18
// 22
// 20
// 22
// 20
// 23
// 25
// Sample Output
// 19

package dynamicProgrammingAndGreedy;
import java.util.*;

public class buyAndSellStocks4WithCooldown {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        
        int bsp = -arr[0];  // bought state profit => BSC B
        int ssp = 0;        // sold state profit => BSC BS
        int csp = 0;        // cooldown state profit => BSC BSC
        
        for(int i=1; i<n; i++){
            int nbsp = csp - arr[i];
            int nssp = bsp + arr[i];
            int ncsp = ssp;
            
            if(nbsp>bsp){
                bsp = nbsp;
            }
            if(nssp>ssp){
                ssp = nssp;
            }
            if(ncsp>csp){
                csp = ncsp;
            }            
        }
        
        System.out.println(ssp);
        scn.close();
    }
    
}
