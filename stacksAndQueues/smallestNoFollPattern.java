// 1. You are given a pattern of upto 8 length containing characters 'i' and 'd'.
// 2. 'd' stands for decreasing and 'i' stands for increasing
// 3. You have to print the smallest number, using the digits 1 to 9 only without repetition, such that 
// the digit decreases following a d and increases follwing an i.

// e.g.
// d -> 21
// i -> 12
// ddd -> 4321
// iii -> 1234
// dddiddd -> 43218765
// iiddd -> 126543

// Sample Input
// ddddiiii
// Sample Output
// 543216789

package stacksAndQueues;
import java.util.*;

public class smallestNoFollPattern {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String str = scn.nextLine();

        Stack<Integer> st = new Stack<>();
        int count = 1;
        for(int j=0; j<str.length(); j++){
            char ch = str.charAt(j);
            
            if(ch == 'd'){
                st.push(count++);
            }else{
                st.push(count++);
                while(st.size()>0){
                    System.out.print(st.pop());
                }
            }
        }
        st.push(count++);    // for the remaining extra number
        while(st.size()>0){
            System.out.print(st.pop());
        }

        scn.close();
    }
    
}
