// Sample Input
// 5
// 7 
// 2 
// 4 
// 1 
// 3
// Sample Output
// After sorting on 1 place -> 1 2 3 4 7 
// 1 2 3 4 7 

// uses count sort as a medium to sort the array
// count sort is called based on the preference and priority

package timeAndSpace;

import java.util.*;

public class radixSort {

    public static void radixSortAlgo(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int elm : arr){
            if(elm>max){
                max = elm;
            }
        }
        
        int exp = 1;
        while(exp<=max){
            countSort(arr, exp);
            exp*=10;
        }
      }

      public static void countSort(int[] arr, int exp) {
        int[] farr = new int[10];
       
       for(int i = 0; i<arr.length; i++){
           farr[(arr[i]/exp)%10]++; 
       }
       for(int i = 1; i<farr.length; i++){
           farr[i]+=farr[i-1];
       }
       int[] ans = new int[arr.length];
       for(int i = arr.length-1; i>=0; i--){
           int pos = farr[(arr[i]/exp)%10]-1;
           ans[pos] = arr[i];
           farr[(arr[i]/exp)%10]--;
       }
       for(int i = 0; i<arr.length; i++){
           arr[i] = ans[i];
       }
        System.out.print("After sorting on " + exp + " place -> ");
        print(arr);
      }
    
      public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
          System.out.print(arr[i] + " ");
        }
        System.out.println();
      }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
          arr[i] = scn.nextInt();
        }
        radixSortAlgo(arr);
        print(arr);
        scn.close();
    }
}
