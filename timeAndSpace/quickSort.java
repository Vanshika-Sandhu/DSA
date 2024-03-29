// Sample Input
// 5
// 7 
// -2 
// 4 
// 1 
// 3
// Sample Output
// pivot -> 3
// Swapping -2 and 7
// Swapping 1 and 7
// Swapping 3 and 4
// pivot index -> 2
// pivot -> 1
// Swapping -2 and -2
// Swapping 1 and 1
// pivot index -> 1
// pivot -> -2
// Swapping -2 and -2
// pivot index -> 0
// pivot -> 4
// Swapping 4 and 7
// pivot index -> 3
// pivot -> 7
// Swapping 7 and 7
// pivot index -> 4
// -2 1 3 4 7 


package timeAndSpace;

import java.util.*;

public class quickSort {

    public static void quickSortAlgo(int[] arr, int lo, int hi) {
        //write your code here
        if(lo>hi){
            return;
        }
        int pivot = arr[hi];
        int pi = partition(arr, pivot, lo, hi);
        quickSortAlgo(arr, lo, pi-1);
        quickSortAlgo(arr, pi+1, hi);
        return;
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
        System.out.println("Enter no. of elements in the array");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of array");
        for (int i = 0; i < n; i++) {
        arr[i] = scn.nextInt();
        }
        quickSortAlgo(arr, 0, arr.length - 1);
        System.out.println("\nSorted array is");
        print(arr);

        scn.close();
    }
}
