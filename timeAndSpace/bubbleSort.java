// 1. You are given an array(arr) of integers.
// 2. You have to sort the given array in increasing order using bubble sort.

// TIME COMPLEXITY => 

// Sample Input
// 5
// 7 
// -2 
// 4 
// 1 
// 3
// Sample Output
// Comparing -2 and 7
// Swapping -2 and 7
// Comparing 4 and 7
// Swapping 4 and 7
// Comparing 1 and 7
// Swapping 1 and 7
// Comparing 3 and 7
// Swapping 3 and 7
// Comparing 4 and -2
// Comparing 1 and 4
// Swapping 1 and 4
// Comparing 3 and 4
// Swapping 3 and 4
// Comparing 1 and -2
// Comparing 3 and 1
// Comparing 1 and -2
// -2
// 1
// 3
// 4
// 7

package timeAndSpace;

import java.util.*;

public class bubbleSort {
    public static void bubbleSortAlgo(int[] arr) {
        // the loop runs for n-1 iterations 
        // outer loop to travel throughout the array
        for(int i = 1; i<arr.length-1; i++){
          // inner loop to compare each element with it's next one in every iteration in one complete outer loop
          for(int j = 0; j<arr.length -1; j++){
            if(isSmaller(arr, j+1, j)){   // compares the jth element from it's next element
              swap(arr, j+1, j);          // if ismaller condition is true swaps both the elements
            }
          }
        }
        
      }
    
      // used for swapping ith and jth elements of array
      public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    
      // return true if ith element is smaller than jth element
      public static boolean isSmaller(int[] arr, int i, int j) {
        System.out.println("Comparing " + arr[i] + " and " + arr[j]);
        if (arr[i] < arr[j]) {
          return true;
        } else {
          return false;
        }
      }
    
      public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
          System.out.println(arr[i]);
        }
      }    

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter no. of elements ");
        int n = scn.nextInt();
        System.out.println("Enter the elements");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        // call
        bubbleSortAlgo(arr);
        System.out.println("\nSorted array");
        print(arr);

        scn.close();
        
    }
    
}
