// Sample Input
// 4
// -2 
// 5 
// 9 
// 11
// 3
// 4 
// 6 
// 8
// Sample Output
// -2
// 4
// 5
// 6
// 8
// 9
// 11

package timeAndSpace;

import java.util.*;

public class mergeSortTwoArrays {

    public static int[] mergeTwoSortedArrays(int[] a, int[] b){
        //write your code here
        int[] arr = new int[a.length + b.length];
        
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i<a.length && j<b.length){
            if(a[i]>b[j]){
                arr[k++] = b[j++];
            }else{
                arr[k++] = a[i++];
            }
        }
        
        while(i<a.length){
            arr[k++] = a[i++];
        }
        while(j<b.length){
            arr[k++] = b[j++];
        }
        
        return arr;
      }

      public static void print(int[] arr){
        for(int i = 0 ; i < arr.length; i++){
          System.out.println(arr[i]);
        }
      }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter no. of elements in array A");
        int n = scn.nextInt();
        int[] a = new int[n];
        System.out.println("Enter elements of array A");
        for(int i = 0 ; i < n; i++){
        a[i] = scn.nextInt();
        }
        System.out.println("Enter no. of elements in array B");
        int m = scn.nextInt();
        int[] b = new int[m];
        System.out.println("Enter elements of array B");
        for(int i = 0 ; i < m; i++){
        b[i] = scn.nextInt();
        }
        int[] mergedArray = mergeTwoSortedArrays(a,b);
        System.out.println("\nMerged array");
        print(mergedArray);
        scn.close();
    }
}
