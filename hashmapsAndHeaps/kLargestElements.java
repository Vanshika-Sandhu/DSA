// 1. You are given a number n, representing the size of array a.
// 2. You are given n numbers, representing elements of array a.
// 3. You are given a number k.
// 4. You are required to find and print the k largest elements of array in increasing order.

// Sample Input
// 13
// 12
// 62
// 22
// 15
// 37
// 99
// 11
// 37
// 98
// 67
// 31
// 84
// 99
// 4
// Sample Output
// 84
// 98
// 99
// 99

package hashmapsAndHeaps;
import java.util.*;
import java.io.*;

public class kLargestElements {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
  
        for (int i = 0; i < n; i++) {
           arr[i] = Integer.parseInt(br.readLine());
        }
  
        int k = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pqr = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int val: arr){
            pqr.add(val);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<k; i++){
           pq.add(pqr.peek());
           pqr.remove();
        }
        
        while(pq.size()>0){
            System.out.println(pq.peek());
            pq.remove();
        }
      }
}
