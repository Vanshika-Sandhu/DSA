// 1. Here are a few sets of inputs and outputs for your reference
// Input1 -> 1
// Output1 -> 1 1 1

// Input2 -> 2
// Output2 -> 2 1 1 1 2 1 1 1 2

// Input2 -> 3
// Output3 -> 3 2 1 1 1 2 1 1 1 2 3 2 1 1 1 2 1 1 1 2 3
package recursion.introduction;

import java.util.*;

public class printZigZag {

    public static void printZZ(int n){
        if(n==0)
            return;

        System.out.print(n); // prefix
        printZZ(n-1);        // first call
        System.out.print(n); // infix
        printZZ(n-1);        // second call
        System.out.print(n); // postfix

        return;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        System.out.print("Enter a number : ");
        int n = scn.nextInt();
        printZZ(n);
        scn.close();
    }
}
