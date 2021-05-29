// 1. You are given a number n, representing the number of stairs in a staircase.
// 2. You are on the 0th step and are required to climb to the top.
// 3. In one move, you are allowed to climb 1, 2 or 3 stairs.
// 4. You are required to print the number of different paths via which you can climb to the top.

// Sample Input
// 4
// Sample Output
// 7

package dynamicProgrammingAndGreedy;

import java.util.*;

public class climbStairs {

    // using dp  => tabulation method => uses iteration over recusrion
    // can be done by memoization too instead of tabulation both ans will be the same
    public static int climbStairsTabulation(int n) {
        int[] qb = new int[n+1]; // array size n+1 is passed to store values from pos 0->n
        qb[0] = 1;               // 0 has one path just like 2^0 from 0 to 0
        for(int i = 1; i<n+1; i++){
            if(i==1)
                qb[i] = qb[i-1];
            else if(i==2)
                qb[i] = qb[i-1] + qb[i-2];
            else
                qb[i] = qb[i-1] + qb[i-2] + qb[i-3];
        }

        return qb[n];
        
    }

    // without using dp
    public static int climbStairsWoDP(int n) {
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        int s1 = climbStairsWoDP(n-1);
        int s2 = climbStairsWoDP(n-2);
        int s3 = climbStairsWoDP(n-3);
        return s1+s2+s3;
    }



    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter the no. of stairs");
        int n = scn.nextInt();
        int ans = climbStairsTabulation(n);  
        System.out.println("The total paths that can be used to take " +n +" no. of stairs are : " + ans);
        scn.close();
    }
}