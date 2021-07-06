// 1. You are given a number n, representing the size of array a.
// 2. You are given n numbers, representing the elements of array a.
// 3. You are given a number k, representing the size of window.
// 4. You are required to find and print the maximum element in every window of size k.

// e.g.
// for the array [2 9 3 8 1 7 12 6 14 4 32 0 7 19 8 12 6] and k = 4, 
// the answer is [9 9 8 12 12 14 14 32 32 32 32 19 19 19]


package stacksAndQueues;
import java.util.*;

public class slidingWindowMaximum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
        arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();

        // step 1 => find an array with next greater element
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];
        nge[n-1] = n;
        st.push(n-1);
        
        for(int i=n-2; i>=0; i--){
            while(st.size()>0 && arr[i]>=arr[st.peek()]){
                st.pop();
            }
            if(st.size()==0){
                nge[i] = n;
            }else{
                nge[i] = st.peek();
            }
            
            st.push(i);
        }
        
        // step 2 => find the max element in the given range of window starting from i
        int j = 0;
        for(int i=0; i<=n-k; i++){
            if(j<i){
                j = i;
            }
            while(nge[j]<i+k){
                j = nge[j];   // j travels from one next greater element to the next within the range
            }
        }
        System.out.println(arr[j]);

        
        scn.close();
    }
    
}
