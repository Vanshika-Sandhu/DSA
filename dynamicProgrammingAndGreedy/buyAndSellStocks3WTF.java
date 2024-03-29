// 1. You are given a number n, representing the n1. You are given a number n, representing the number of days.
// 2. You are given n numbers, where ith number represents price of stock on ith day.
// 3. You are give a number fee, representing the transaction fee for every transaction.
// 4. You are required to print the maximum profit you can make if you are allowed infinite transactions,
// but has to pay "fee" for every closed transaction.
// Note - There can be no overlapping transaction. One transaction needs to be closed
// (a buy followed by a sell) before opening another transaction (another buy).

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
// 3
// Sample Output
// 13

package dynamicProgrammingAndGreedy;
import java.util.*;

public class buyAndSellStocks3WTF {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        int fee = scn.nextInt();

        int bsp = -arr[0];       // buy state profit => BS BS B type 
        int ssp = 0;             // sold state profit => BS BS type
        for(int i=1; i<n; i++){
            int nbsp = ssp - arr[i];
            int nssp = arr[i] + bsp - fee;
            
            if(nssp>ssp){
                ssp = nssp;
            }
            if(nbsp>bsp){
                bsp = nbsp;
            }
        }
        System.out.print(ssp);

        scn.close();

    }
    
}
