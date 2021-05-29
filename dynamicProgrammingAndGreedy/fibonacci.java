// 1. You are given a number n.
// 2. You are required to print the nth element of fibonacci sequence.

// Sample Input
// 10
// Sample Output
// 55

package dynamicProgrammingAndGreedy;

import java.util.*;

public class fibonacci {

    // using dp
    public static int fibonacciMemoization(int n, int[] qb) {

        if(n==0 || n==1){
            return n;
        }

        if(qb[n]!=0){
            return qb[n];
        }

        int f1 = fibonacciMemoization(n-1, qb);
        int f2 = fibonacciMemoization(n-2, qb);
        qb[n] = f1 + f2;
        return qb[n];
    }

    // without using dp
    public static int fibonacciWoDP(int n) {

        if(n==0 || n==1){
            return n;
        }
        int f1 = fibonacciWoDP(n-1);
        int f2 = fibonacciWoDP(n-2);
        return f1+f2;
    }



    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter the nth element to be printed of fibonacci series");
        int n = scn.nextInt();
        int ans = fibonacciMemoization(n, new int[n+1]);  // array size n+1 is passed to store values from pos 0->n 
        System.out.println("The " + n + "th element in the fibonacci series is : " + ans);
        scn.close();
    }
}