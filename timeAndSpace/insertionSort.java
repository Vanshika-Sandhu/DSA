// Sample Input
// 5
// 7 
// -2 
// 4 
// 1 
// 3
// Sample Output
// Comparing -2 and 7
// Swapping 7 and -2
// Comparing 4 and 7
// Swapping 7 and 4
// Comparing 4 and -2
// Comparing 1 and 7
// Swapping 7 and 1
// Comparing 1 and 4
// Swapping 4 and 1
// Comparing 1 and -2
// Comparing 3 and 7
// Swapping 7 and 3
// Comparing 3 and 4
// Swapping 4 and 3
// Comparing 3 and 1
// -2
// 1
// 3
// 4
// 7

// Also called reverse bubbling

// Approach => consider the 1st element to be an array, then insert the 2nd element in front of it or behind it
// depending upon the value, the repeat for the next element


package timeAndSpace;

import java.util.*;

public class insertionSort{

    public static void insertionSortAlgo(int[] arr) {
        // for iterating throughout the array
        for(int i = 1; i<arr.length; i++){
            // in between comparisons
            for(int j = i-1; j>=0; j--){
                if(isGreater(arr, j, j+1)){
                    swap(arr, j, j+1);
                }else{
                    break;
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

  // return true if jth element is greater than ith element
  public static boolean isGreater(int[] arr, int j, int i) {
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
        System.out.println("Enter no. of elements in the array");
        int n = scn.nextInt();
        System.out.println("Enter the elements of array");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
        arr[i] = scn.nextInt();
        }
        insertionSortAlgo(arr);
        System.out.println("\nThe sorted array");
        print(arr);
        scn.close();
    }
}