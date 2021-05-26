package timeAndSpace;

import java.util.*;

public class countSort {
    public static void countSortAlgo(int[] arr, int min, int max) {
        // step 1 => create a new freq array of range given
        int[] farr = new int[max-min+1];
   
        // step 2 => get the freq of every no in the array in freq array
        for(int i = 0; i<arr.length; i++){
            farr[arr[i]-min]++; 
        }

        // eg -> the freq array is 1 1 3 4
        // this loop will give 1 2 5 9 => no. of position of elements at each insertion
        for(int i = 1; i<farr.length; i++){
            farr[i]+=farr[i-1];
        }

        // create a new array
        int[] ans = new int[arr.length];

        // reverse loop => for stable sort i.e. to arrange the order of same number as enetered as
        // they might have had diff properties
        for(int i = arr.length-1; i>=0; i--){
            int pos = farr[arr[i]-min]-1;
            ans[pos] = arr[i];
            farr[arr[i] -min]--;
        }

        // copy value of ans to arr
        for(int i = 0; i<arr.length; i++){
            arr[i] = ans[i];
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
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        System.out.println("Enter elements of the array");
        for (int i = 0; i < n; i++) {
        arr[i] = scn.nextInt();
        max = Math.max(max, arr[i]);
        min = Math.min(min, arr[i]);
        }
        countSortAlgo(arr,min,max);
        System.out.println("\nSorted array is");
        print(arr);
        scn.close();
    }
}
