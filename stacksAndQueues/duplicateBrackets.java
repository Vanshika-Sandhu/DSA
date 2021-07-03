// 1. You are given a string exp representing an expression.
// 2. Assume that the expression is balanced  i.e. the opening and closing brackets match with each other.
// 3. But, some of the pair of brackets maybe extra/needless. 
// 4. You are required to print true if you detect extra brackets and false otherwise.

// e.g.'
// ((a + b) + (c + d)) -> false
// (a + b) + ((c + d)) -> true

// Sample Input
// (a + b) + ((c + d))
// Sample Output
// true

package stacksAndQueues;
import java.util.*;

public class duplicateBrackets {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String str = scn.nextLine();
        Stack<Character> st = new Stack<>();
        boolean ans = false;

        
        for(int i=0; i<str.length(); i++  ){
            if(str.charAt(i)==')'){
                if(st.peek() == '('){
                    ans = true;
                    break;
                }else{  
                   while(st.peek()!='('){
                       st.pop();
                   }
                   st.pop();
                }
            }else{
                st.push(str.charAt(i));
            }
        }
        
        System.out.println(ans);

        scn.close();

    }
    
}
