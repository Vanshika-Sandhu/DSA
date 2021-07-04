// 1. You are given a number n, representing the size of array a.
// 2. You are given n numbers, representing elements of array a.
// 3. You are required to "next greater element on the right" for all elements of array
// 4. Input and output is handled for you.

// "Next greater element on the right" of an element x is defined as the first element to right of
// x having value greater than x.
// Note -> If an element does not have any element on it's right side greater than it, consider -1
// as it's "next greater element on right"
// e.g.
// for the array [2 5 9 3 1 12 6 8 7]
// Next greater for 2 is 5
// Next greater for 5 is 9
// Next greater for 9 is 12
// Next greater for 3 is 12
// Next greater for 1 is 12
// Next greater for 12 is -1
// Next greater for 6 is 8
// Next greater for 8 is -1
// Next greater for 7 is -1

// Sample Input
// 5
// 5
// 3
// 8
// -2
// 7
// Sample Output
// 8
// 8
// -1
// 7
// -1

package stacksAndQueues;

import java.util.*;

public class nextGreaterElmToTheRight {

    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();
    
        for(int val: a){
          sb.append(val + "\n");
        }
        System.out.println(sb);
      }

    public static int[] solve(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        

        // APPROACH 1
        ans[arr.length-1] = -1;
        st.push(arr[arr.length-1]);
        for(int i=arr.length-2; i>=0; i--){
             //-a+
             // step 1 => pop
             while(st.size()>0&&st.peek()<=arr[i]){
                 st.pop();
             }
             // step 2 => ans
             if(st.size()>0){
                 ans[i] = st.peek();
             }else{
                 ans[i] = -1;
             }
             // step 3 => push
             st.push(arr[i]);
        } 


        // APPROACH 2
        // st.push(0);
        // for(int i=1; i<arr.length; i++){
        //     //step 1 => pop position of elements less than you and add yourself as ans
        //     while(st.size()>0 && arr[i]>=arr[st.peek()] ){
        //         int pos = st.peek();
        //         ans[pos] = arr[i];
        //         st.pop();
        //     }
        //     // step 2 => add your position in the stack
        //     st.push(i);
        // }
        // //step 3 => add -1 as ans for the remaining positions in the stack   
        // while(st.size()>0){
        //     int pos = st.peek();
        // ans[pos] = -1;
        // st.pop();
        // }

        
        return ans;
        
      }
    public static void main(String[] args) {
            // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int n = Integer.parseInt(br.readLine());
        // int[] a = new int[n];
        // for(int i = 0; i < n; i++){
        //   a[i] = Integer.parseInt(br.readLine());
        // }

        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int a[] = new int[n];
        for(int i=0; i<n; i++){
            a[i] = scn.nextInt();
        }
 
    
        int[] nge = solve(a);
        display(nge);

        scn.close();
    }
    
}
