// 1. You are given an array(arr) of integers.
// 2. You have to find the k-th smallest element in the given array using the quick-select algorithm.

// Sample Input
// 5
// 7 
// -2 
// 4 
// 1 
// 3
// 3
// Sample Output
// pivot -> 3
// Swapping -2 and 7
// Swapping 1 and 7
// Swapping 3 and 4
// pivot index -> 2
// 3

package timeAndSpace;

import java.util.*;

public class quickSelect {

    public static int quickSelectAlgo(int[] arr, int lo, int hi, int k) {
        if(lo>=hi){
            return 0;
        }
        
        int pivot = arr[hi];
        
        int pi = partition(arr,pivot, lo, hi );
        
        int ki = 0;
        
        if(k==pi){
            ki = arr[k];
        }else if(k<pi){
            ki = quickSelectAlgo(arr, lo, pi-1, k);
        }else{
            ki = quickSelectAlgo(arr, pi+1, hi, k);
        }
        
        return ki;
      }
    
      public static int partition(int[] arr, int pivot, int lo, int hi) {
        System.out.println("pivot -> " + pivot);
        int i = lo, j = lo;
        while (i <= hi) {
          if (arr[i] <= pivot) {
            swap(arr, i, j);
            i++;
            j++;
          } else {
            i++;
          }
        }
        System.out.println("pivot index -> " + (j - 1));
        return (j - 1);
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
        System.out.println("Enter the no. of elements in array");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of array");
        for (int i = 0; i < n; i++) {
        arr[i] = scn.nextInt();
        }
        System.out.println("Enter the kth position");
        int k = scn.nextInt();
        System.out.print("The " + k + "th smallest element in the array is : ");
        System.out.println(quickSelectAlgo(arr,0,arr.length - 1,k - 1));
        scn.close();
    }
}
