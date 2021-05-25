// Sample Input
// 5
// 7 
// -2 
// 4 
// 1 
// 3
// Sample Output
// Comparing -2 and 7
// Comparing 4 and -2
// Comparing 1 and -2
// Comparing 3 and -2
// Swapping 7 and -2
// Comparing 4 and 7
// Comparing 1 and 4
// Comparing 3 and 1
// Swapping 7 and 1
// Comparing 7 and 4
// Comparing 3 and 4
// Swapping 4 and 3
// Comparing 4 and 7
// Swapping 7 and 4
// -2
// 1
// 3
// 4
// 7


// Approach => find smallest element and swap with the 1st and the next consecutive positions for each iteration

package timeAndSpace;

import java.util.*;

public class selectionSort {

  public static void selectionSortAlgo(int[] arr) {
    //outer loop for iterating all over the array => runs for n-1 times
    for(int i = 0; i<arr.length-1; i++){
        int mIdx = i;                           // a min index to keep a tab on minimum in each iteration
        for(int j = i+1; j<arr.length; j++){
            if(isSmaller(arr, j, mIdx)){        // if arr[mIdx] > arr[j] =>  mIdx = j => the arr[j] element is smaller
                mIdx = j;
            }
        }
        swap(arr, i, mIdx);                     // swap the ith index and min index after one complete iteration
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

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    System.out.println("Enter no. of elements in the array");
    int n = scn.nextInt();
    System.out.println("Enter elements of the array");
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    selectionSortAlgo(arr);
    System.out.println("\nSorted Array ");
    print(arr);

    scn.close();
  }
    
}
