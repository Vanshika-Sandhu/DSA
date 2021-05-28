// 1. You are given an array(arr) of distinct integers, which is sorted and rotated around an unknown point.
// 2. You have to find the smallest element in O(logN) time-complexity


// Sample Input
// 9
// 15
// 16
// 19
// 21
// 23
// 24
// 1
// 2
// 12
// Sample Output
// 1


package timeAndSpace;
import java.util.*;

public class pivotInSnRArray {

    public static int findPivot(int[] arr) {
        int lo = 0; 
        int hi = arr.length-1;

        while(lo<hi){
            int mid = (lo+hi)/2;
            if(arr[mid]<arr[hi]){
                hi = mid;
            }else{
                lo = mid +1;
            }
        }

        return arr[hi];    // here hi = lo = mid

      }
    public static void main(String[] args) {
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
          arr[i] = scn.nextInt();
        }
        int pivot = findPivot(arr);
        System.out.println(pivot);
        scn.close();
    }
}
