// 1. You are given a number n1, representing the size of array a1.
// 2. You are given n1 numbers, representing elements of array a1.
// 3. You are given a number n2, representing the size of array a2.
// 4. You are given n2 numbers, representing elements of array a2.
// 5. You are required to print all elements of a2 which are also present in a1 (in order of their occurence in a2). Make sure to not print duplicates (a2 may have same value present many times).

// Sample Input
// 9
// 5
// 5
// 9
// 8
// 5
// 5
// 8
// 0
// 3
// 18
// 9
// 7
// 1
// 0
// 3
// 6
// 5
// 9
// 1
// 1
// 8
// 0
// 2
// 4
// 2
// 9
// 1
// 5
// Sample Output
// 9
// 0
// 3
// 5
// 8

package hashmapsAndHeaps;
import java.util.*;

public class getCommonElement1 {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n1 = scn.nextInt();
        int[] arr1 = new int[n1];
        for(int i=0; i<n1; i++){
            arr1[i] = scn.nextInt();
        }
        int n2 = scn.nextInt();
        int[] arr2 = new int[n2];
        for(int i=0; i<n2; i++){
            arr2[i] = scn.nextInt();
        }
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<n1; i++){
            if(hm.containsKey(arr1[i])){
                int oldFreq = hm.get(arr1[i]);
                hm.put(arr1[i], oldFreq+1);
            }else{
                hm.put(arr1[i], 1);
            }
        }
        
        for(int i=0; i<n2; i++){
            if(hm.containsKey(arr2[i])){
                System.out.println(arr2[i]);
                hm.remove(arr2[i]);
            }
        }
        scn.close();
     }
}
