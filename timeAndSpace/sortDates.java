// 1. You are given an array(arr) of different dates in format DD-MM-YYYY.
// 2. You have to sort these dates in increasing order.

// Sample Input
// 5
// 12041996
// 20101996
// 05061997
// 12041989
// 11081987
// Sample Output
// 11081987
// 12041989
// 12041996
// 20101996
// 05061997


package timeAndSpace;

import java.util.*;

public class sortDates {

    public static void sortDatesFunc(String[] arr) {

        // range + 1 is passed since the array would be of of the range 0 to range-1
        // date 
        countSort(arr, 1000000, 100, 32);
        // day
        countSort(arr, 10000, 100, 13);
        // year
        countSort(arr, 1, 10000, 2501);
      }
    
      public static void countSort(String[] arr,int div, int mod, int range) {
            int[] farr = new int[range];
           
           for(int i = 0; i<arr.length; i++){
                // Integer.parseInt(arr[i], 10) => to convert the string type data(arr[i]) in int type with base 10
               farr[(Integer.parseInt(arr[i],10)/div)%mod]++; 
           }
           for(int i = 1; i<farr.length; i++){
               farr[i]+=farr[i-1];
           }
           String[] ans = new String[arr.length];
           for(int i = arr.length-1; i>=0; i--){
               int pos = farr[(Integer.parseInt(arr[i],10)/div)%mod]-1;
               ans[pos] = arr[i];
               farr[(Integer.parseInt(arr[i],10)/div)%mod]--;
           }
           for(int i = 0; i<arr.length; i++){
               arr[i] = ans[i];
           }
      }
    
      public static void print(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
          System.out.println(arr[i]);
        }
      }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
        String str = scn.next();
        arr[i] = str;
        }
        sortDatesFunc(arr);
        print(arr);

        scn.close();
    }
    
}
