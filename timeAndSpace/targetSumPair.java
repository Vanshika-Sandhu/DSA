// 1. You are given an array(arr) of distinct integers and a target.
// 2. You have to print all the pairs having their sum equal to the target.

// Sample Input
// 12
// 9 
// -48 
// 100 
// 43 
// 84 
// 74 
// 86 
// 34 
// -37 
// 60 
// -29 
// 44
// 160
// Sample Output
// 60, 100
// 74, 86

package timeAndSpace;
import java.util.*;

public class targetSumPair {

    public static void targetSumPairFunc(int[] arr, int target){

        // merge sort array / sort array
        // inbuilt function
        Arrays.sort(arr);
    
        int l = 0;
        int r = arr.length-1;
        while(l<r){
            if(arr[l]+arr[r] == target){
                System.out.println( arr[l] + ", " + arr[r]);
                l++;
                r--;
            }else if(arr[l]+arr[r]>target){
                r--;
            }else{
                l++;
            }
        }
    
      }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ;i < n; i++){
        arr[i] = scn.nextInt();
        }
        int target = scn.nextInt();
        targetSumPairFunc(arr,target);

        scn.close();
    }
    
}


