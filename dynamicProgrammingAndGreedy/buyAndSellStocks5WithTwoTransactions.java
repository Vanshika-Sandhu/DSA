// 1. You are given a number n, representing the number of days.
// 2. You are given n numbers, where ith number represents price of stock on ith day.
// 3. You are required to print the maximum profit you can make if you are allowed two transactions at-most.
// Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell)
// before opening another transaction (another buy).

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
// 30

package dynamicProgrammingAndGreedy;
import java.util.*;

public class buyAndSellStocks5WithTwoTransactions {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]  =scn.nextInt();
        }
        
        // for first traversal from left to right
        int mpist = 0;                     // max profit if sold today
        int lsf = arr[0];                  // least so far
        int[] dpmpisut = new int[n];       // dp of max profit if sold upto today
        for(int i=1; i<n; i++){
            if(arr[i]<lsf){
                lsf = arr[i];
            }
            mpist = arr[i] - lsf;
            if(mpist>dpmpisut[i-1]){
                dpmpisut[i] = mpist;
            }else{
                dpmpisut[i] = dpmpisut[i-1];
            }
        }
        
        // for second traversal from right to left 
        int mpibt = 0;                      // max profit if bought today
        int msf = arr[n-1];                 // max so far
        int[] dpmpibut = new int[n];        // dp of max profit if bought upto today
        for(int i=n-2; i>=0; i-- ){
            if(arr[i]>msf){
                msf = arr[i];
            }
            mpibt = msf - arr[i];
            if(mpibt > dpmpibut[i+1]){
                dpmpibut[i] = mpibt;
            }else{
                dpmpibut[i] = dpmpibut[i+1];
            }
        }
        
        // meaning of combination of traversal one and two
        // for i = 5
        // => 1st traversal denotes the max profit that held when we bought and sold 1 transaction till 5
        // => 2nd traversal denotes the max profit that held when we bought and sold 2nd transaction after 5 to n-1

        // maxProfit denotes the hightes of the sum of two combinations throughout the array
        int maxProfit = 0;
        for(int i=0; i<n; i++){
            if(maxProfit<dpmpisut[i] + dpmpibut[i])
                maxProfit = dpmpisut[i] + dpmpibut[i];
        }
        
        System.out.println(maxProfit);


        scn.close();
    }
    
}
