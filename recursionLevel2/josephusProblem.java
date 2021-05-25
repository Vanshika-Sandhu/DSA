// 1. You are given two numbers N and K.
// 2. N represents the total number of soldiers standing in a circle having position marked from 0 to N-1.
// 3. A cruel king wants to execute them but in a different way.
// 4. He starts executing soldiers from 0th position and proceeds around the circle in clockwise direction.
// 5. In each step, k-1 soldiers are skipped and the k-th soldier is executed.
// 6. The elimination proceeds around the circle (which is becoming smaller and smaller as the executed
// soldiers are removed), until only the last soldier remains, who is given freedom.
// 7. You have to find the position of that lucky soldier.

// Sample Input
// 8
// 3

// Sample Output
// 6


package recursionLevel2;


import java.util.*;

public class josephusProblem {

    public static int solution(int n, int k){

        if(n==0){
            return 1;
        }
        
        int a1 = solution(n-1, k);
        // so that the ans can be converted into final ans
        // eg for n = 5, k = 3
        // a1 = 0 => ans = 0+3%5 = 3
        // for more, look at the dry run in notebook
        int ans = (a1+k)%n;

        return ans;
      }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter no. of soldiers");
        int n = scn.nextInt();
        System.out.println("Enter no. of soldiers to be skipped");
        int k = scn.nextInt();
        System.out.print("The soldier that would not be killed would be standing at position ");
        System.out.print(solution(n,k));
        scn.close();
    }
    
}
