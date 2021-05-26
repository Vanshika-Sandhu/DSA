// 1. You are given an array(arr) of integers and a pivot.
// 2. You have to re-arrange the given array in such a way that all elements smaller or equal to pivot lie on the left side of pivot and all elements greater than pivot lie on its right side.
// 3. You have to achieve this in linear time.

// Sample Input
// 5
// 7 
// -2 
// 4 
// 1 
// 3
// 3
// Sample Output
// Swapping -2 and 7
// Swapping 1 and 7
// Swapping 3 and 4
// -2 1 3 7 4 


package timeAndSpace;

import java.util.*;

public class partitionArray {

    public static void partition(int[] arr, int pivot){
        // three regions will be formed
        // i-> end => unknowns
        // j->i-1 => greater than pivot
        // 0->i => less than or equal to pivot
        int i = 0;
        int j = 0;

        while(i<arr.length){
            if(arr[i]>pivot){
                i++;
            }else{
                swap(arr, i, j);
                i++;
                j++;
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
    
      public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
          System.out.print(arr[i] + " ");
        }
        System.out.println();
      }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter no. of elements in the array");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < n; i++) {
        arr[i] = scn.nextInt();
        }
        System.out.println("Enter the pivot");
        int pivot = scn.nextInt();
        partition(arr,pivot);
        System.out.println("\nPartitioned array");
        print(arr);

        scn.close();
    }
}
