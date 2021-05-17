// 1. You are given a number n, representing the count of elements.
// 2. You are given n numbers.
// 3. You are given a number "tar".
// 4. Calculate and print all subsets of given elements, the contents of which sum to "tar". 

// input
// 5
// 10
// 20
// 30
// 40
// 50
// 60

// output
// 10, 20, 30, .
// 10, 50, .
// 20, 40, .

import java.util.*;

public class targetSum {

    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
        // set is the subset
        // sos is sum of subset
        // tar is target
        if(idx == arr.length){
            if(sos == tar){
                System.out.println(set + ".");
            }
            return;
        }

        printTargetSumSubsets(arr, idx+1, set + arr[idx] + ", ", sos + arr[idx], tar);
        printTargetSumSubsets(arr, idx+1, set, sos, tar);

        return;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter length of array ");
        int n = scn.nextInt();
        System.out.println("Enter elements of array ");
        int[] arr = new int[n];
        
        for(int i = 0; i<n ; i++){
            arr[i] = scn.nextInt();
        }
        System.out.println("Enter target ");
        int tar = scn.nextInt();

        printTargetSumSubsets(arr, 0, " ", 0, tar);

        scn.close();
    }
    
}
