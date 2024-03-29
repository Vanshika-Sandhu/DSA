// 1. You are given an array(arr) containing only 0's, 1's, and 2's.
// 2. You have to sort the given array in increasing order and in linear time.

// Sample Input
// 10
// 1
// 0
// 2
// 2
// 1
// 0
// 2
// 1
// 0
// 2
// Sample Output
// Swapping index 1 and index 0
// Swapping index 2 and index 9
// Swapping index 2 and index 8
// Swapping index 2 and index 1
// Swapping index 3 and index 7
// Swapping index 5 and index 2
// Swapping index 6 and index 6
// 0
// 0
// 0
// 1
// 1
// 1
// 2
// 2
// 2
// 2

package timeAndSpace;

import java.util.*;

public class sort012 {

    public static void sort012Func(int[] arr){
        //write your code here
        int i = 0;
        int j = 0;
        int k = arr.length-1;

        //   i -> k   => unknowns
        //   0 -> j-1 => 0
        //   j -> i-1 => 1
        // k+1 -> end => 2
        
        while(i<=k){
            if(arr[i] == 0){
                swap(arr, i, j);
                i++;
                j++;
            }else if(arr[i]==1){
                i++;
            }else{
                swap(arr, i, k);
                k--;
            }
        }
      }

      // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping index " + i + " and index " + j);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr){
        for(int i = 0 ; i < arr.length; i++){
        System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ;i < n; i++){
        arr[i] = scn.nextInt();
        }
        sort012Func(arr);
        print(arr);

        scn.close();
    }
}
