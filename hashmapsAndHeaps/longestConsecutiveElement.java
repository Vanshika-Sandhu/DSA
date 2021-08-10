// 1. You are given a number n, representing the size of array a.
// 2. You are given n numbers, representing elements of array a.
// 3. You are required to print the longest sequence of consecutive elements in the array (ignoring duplicates).

// Note -> In case there are two sequences of equal length (and they are also the longest), then print the one for which the starting point of which occurs first in the array.

// Sample Input
// 17
// 12
// 5
// 1
// 2
// 10
// 2
// 13
// 7
// 11
// 8
// 9
// 11
// 8
// 9
// 5
// 6
// 11
// Sample Output
// 5
// 6
// 7
// 8
// 9
// 10
// 11
// 12
// 13

package hashmapsAndHeaps;
import java.util.*;

public class longestConsecutiveElement {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }
        
        HashMap<Integer, Boolean> hm = new HashMap<>();
        for(int val : arr ){
            hm.put(val, true);
        }
        
        for(int val: arr){
            if(hm.containsKey(val-1)){
                hm.put(val, false);
            }
        }
        
        int maxStartPoint = 0;
        int maxLen = 0;
        
        for(int val: arr){
            if(hm.get(val) == true){
                int tl = 1;
                int tsp = val;
                // loop to check how many continuous elements are present
                while(hm.containsKey(tsp + tl)){
                    tl++;
                }
                
                if(tl>maxLen){
                    maxLen = tl;
                    maxStartPoint = val;
                }
            }
        }
        
        for(int i=0; i<maxLen; i++){
            System.out.println(maxStartPoint++);
        }
        
        scn.close();
    }
}
