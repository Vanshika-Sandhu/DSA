// Sample Input
// 5
// 7 
// -2 
// 4 
// 1 
// 3
// Sample Output
// Merging these two arrays 
// left array -> 7 
// right array -> -2 
// Merging these two arrays 
// left array -> -2 7 
// right array -> 4 
// Merging these two arrays 
// left array -> 1 
// right array -> 3 
// Merging these two arrays 
// left array -> -2 4 7 
// right array -> 1 3 
// Sorted Array -> -2 1 3 4 7 


package timeAndSpace;

import java.util.*;

public class mergeSort {

    public static int[] mergeSortAlgo(int[] arr, int lo, int hi) {
        //write your code here
        if(lo==hi){
            int[] bc = new int[1];
            bc[0]  = arr[lo];
            return bc;
        }else if(lo>hi){
            return null;
        }
        
        int mid = (lo+hi)/2;
        
        int[] a = mergeSortAlgo(arr, lo, mid);
        int[] b = mergeSortAlgo(arr, mid+1, hi);
        
        int[] ans = mergeTwoSortedArrays(a, b);
        
        return ans;
        
      }

      public static int[] mergeTwoSortedArrays(int[] a, int[] b){
        System.out.println("Merging these two arrays ");
        System.out.print("left array -> ");
        print(a);
        System.out.print("right array -> ");
        print(b);
        int i = 0, j =0, k = 0;
        int[] ans = new int[a.length + b.length];
        while(i < a.length && j < b.length){
            if(a[i] <= b[j]){
              ans[k] = a[i];
              i++;
              k++;
            }else{
              ans[k] = b[j];
              j++;
              k++;
            }
        }
    
        while(i < a.length){
          ans[k] = a[i];
          k++;
          i++;
        }
    
        while(j < b.length){
          ans[k] = b[j];
          k++;
          j++;
        }
        
        return ans;
      }

      public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
          System.out.print(arr[i] + " ");
        }
        System.out.println();
      }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter no. of elements in array");
        int n = scn.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of array");
        for (int i = 0; i < n; i++) {
        arr[i] = scn.nextInt();
        }
        int[] sa = mergeSortAlgo(arr,0,arr.length - 1);
        System.out.print("Sorted Array -> ");
        print(sa);
        scn.close();
    }
    
}
