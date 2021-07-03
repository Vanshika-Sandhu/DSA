package stacksAndQueues;
import java.util.*;

public class introStacks {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // Stack<Integer> st; => only declaration
        Stack<Integer> st = new Stack<>();  //declaration and definition
        st.push(10);
        System.out.println(st + " -> " + st.peek() + " " + st.size() );
        st.push(20);
        System.out.println(st + " -> " + st.peek() + " " + st.size() );
        st.push(30);
        System.out.println(st + " -> " + st.peek() + " " + st.size() );
        st.push(40);
        System.out.println(st + " -> " + st.peek() + " " + st.size() );
        st.pop();
        System.out.println(st + " -> " + st.peek() + " " + st.size() );
        st.pop();
        System.out.println(st + " -> " + st.peek() + " " + st.size() );
        st.pop();
        System.out.println(st + " -> " + st.peek() + " " + st.size() );
        st.pop();
        System.out.println(st + " -> " + st.size() );
        // this last peek will notshow anything in empty stack thus giving error
        // System.out.println(st + " -> " + st.peek() + " " + st.size() );


        // OUTPUT
        // [10] -> 10 1
        // [10, 20] -> 20 2
        // [10, 20, 30] -> 30 3
        // [10, 20, 30, 40] -> 40 4
        // [10, 20, 30] -> 30 3
        // [10, 20] -> 20 2
        // [10] -> 10 1
        // [] -> 0

        scn.close();
    }
    
}
