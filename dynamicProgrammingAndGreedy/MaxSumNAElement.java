// 1. You are given a number n, representing the count of elements.
// 2. You are given n numbers, representing n elements.
// 3. You are required to find the maximum sum of a subsequence with no adjacent elements.

// Sample Input
// 6
// 5
// 10
// 10
// 100
// 5
// 6
// Sample Output
// 116


// base for greedy algo
// see notebook for explanation


package dynamicProgrammingAndGreedy;
import java.util.*;

public class MaxSumNAElement {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        
        int inc = arr[0]; 
        int exc = 0; 
        for(int i=1; i<n; i++){
           int ninc = exc + arr[i];
           int nexc = inc > exc ? inc : exc;
           
           inc = ninc;
           exc = nexc;
        }
        
        System.out.println(inc > exc ? inc : exc);

        scn.close();
    }
    
}
