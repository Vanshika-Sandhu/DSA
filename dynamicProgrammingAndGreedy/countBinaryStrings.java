// 1. You are given a number n.
// 2. You are required to print the number of binary strings of length n with no consecutive 0's.

// Sample Input
// 6
// Sample Output
// 21


// type of problem => include exclude 

package dynamicProgrammingAndGreedy;
import java.util.*;

public class countBinaryStrings {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        // using tabulation
        // meaning of cell 
        // for arr0[i] => count of binary string following the rules, of length i and ending with 0
        // for arr1[i] => count of binary string following the rules, of length i and ending with 1
        int[] arr0 = new int[n+1];
        int[] arr1 = new int[n+1];
        
        arr0[1] = 1;
        arr1[1] = 1;
        for(int i=2; i<n+1; i++){
            // this is taken so that there is no repetition of 0s
            arr0[i] = arr1[i-1];
            arr1[i] = arr0[i-1]+arr1[i-1];
        }
        System.out.println(arr0[n]+arr1[n]);

        scn.close();
    }
    
}
