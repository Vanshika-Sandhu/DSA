// 1. You are given a number n1, representing the size of array a1.
// 2. You are given n1 numbers, representing elements of array a1.
// 3. You are given a number n2, representing the size of array a2.
// 4. You are given n2 numbers, representing elements of array a2.
// 5. You are required to find the intersection of a1 and a2. To get an idea check the example below:
 
// if a1 -> 1 1 2 2 2 3 5
// and a2 -> 1 1 1 2 2 4 5
// intersection is -> 1 1 2 2 5

package hashmapsAndHeaps;
import java.util.*;

public class getCommonElement2 {
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
                int oldFreq = hm.get(arr2[i]);
                if(oldFreq-1!=0){
                    hm.put(arr2[i], oldFreq-1);
                }else{
                    hm.remove(arr2[i]);
                }
            }
        }
        scn.close();
 }

}
