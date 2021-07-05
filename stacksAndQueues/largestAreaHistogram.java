// 1. You are given a number n, representing the size of array a.
// 2. You are given n numbers, representing the height of bars in a bar chart.
// 3. You are required to find and print the area of largest rectangle in the histogram.

// e.g.
// for the array [6 2 5 4 5 1 6] -> 12

// Sample Input
// 7
// 6
// 2
// 5
// 4
// 5
// 1
// 6
// Sample Output
// 12

package stacksAndQueues;
import java.util.*;

public class largestAreaHistogram {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
        arr[i] = scn.nextInt();
        }

        int[] rb = new int[arr.length]; // nse on the right
        Stack<Integer> st = new Stack<>();

        st.push(arr.length - 1);
        rb[arr.length - 1] = arr.length;
        for (int i = arr.length - 2; i >= 0; i--) {
        while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
            st.pop();
        }

        if (st.size() == 0) {
            rb[i] = arr.length;
        } else {
            rb[i] = st.peek();
        }

        st.push(i);
        }

        int[] lb = new int[arr.length]; // nse on the left
        st = new Stack<>();

        st.push(0);
        lb[0] = -1;
        for (int i = 1; i < arr.length; i++) {
        while (st.size() > 0 && arr[i] <= arr[st.peek()]) {
            st.pop();
        }

        if (st.size() == 0) {
            lb[i] = -1;
        } else {
            lb[i] = st.peek();
        }

        st.push(i);
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
        int width = rb[i] - lb[i] - 1;
        int area = width * arr[i];
        if (area > max) {
            max = area;
        }
        }

        System.out.println(max);


            scn.close();   
        }
    
}
