// 1. You are given a number n, representing the number of stairs in a staircase.
// 2. You are on the 0th step and are required to climb to the top.
// 3. You are given n numbers, where ith element's value represents - till how far from the step you 
//      could jump to in a single move.  
//      You can of course jump fewer number of steps in the move.
// 4. You are required to print the number of different paths via which you can climb to the top.

// Sample Input
// 10
// 3
// 3
// 0
// 2
// 1
// 2
// 4
// 2
// 0
// 0
// Sample Output
// 5

package dynamicProgrammingAndGreedy;
import java.util.*;

// using tabulation
public class climbStairsWVJ {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        
        int[] arr = new int[n];
        
        for(int i = 0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        
        int[] tabArr = new int[n+1];
        tabArr[n] = 1;
        for(int i = n-1; i>=0; i--){
            for(int j = 1; j<=arr[i] && i+j<n+1; j++){
                tabArr[i] += tabArr[i+j]; 
            }
        }
        System.out.println(tabArr[0]);
        scn.close();
    }
    
}
