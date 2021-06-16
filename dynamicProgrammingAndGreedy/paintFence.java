// 1. You are given a number n and a number k in separate lines, representing the number of fences and no. of colors.
// 2. You are required to calculate and print the number of ways in which the fences could be painted so that not
// more than two consecutive fences have same colors.

// Sample Input
// 8
// 3
// Sample Output
// 3672

package dynamicProgrammingAndGreedy;
import java.util.*;

public class paintFence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int k = scn.nextInt();
        
        int same = k;
        int diff = k*(k-1);
        for(int i=2; i<n; i++){
            int total = same + diff;
            
            same = diff;
            diff = total*(k-1);
        }
        
        System.out.println(same + diff);

        scn.close();
    }
    
}
