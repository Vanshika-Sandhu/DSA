// 1. You are given a string exp representing an expression.
// 2. You are required to check if the expression is balanced i.e. closing brackets and opening brackets match up well.

// e.g.
// [(a + b) + {(c + d) * (e / f)}] -> true
// [(a + b) + {(c + d) * (e / f)]} -> false
// [(a + b) + {(c + d) * (e / f)} -> false
// ([(a + b) + {(c + d) * (e / f)}] -> false

// Sample Input
// [(a + b) + {(c + d) * (e / f)}]
// Sample Output
// true

package stacksAndQueues;
import java.util.*;

public class balancedBrackets {

    public static boolean handleClosing(Stack<Character> st, char openbr){
        if(st.size()==0){
            return false;
        }else if(st.peek()!=openbr){
            return false;
        }else{
            st.pop();
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String str = scn.nextLine();
        Stack<Character> st = new Stack<>();
        boolean ans = true;
        
        for(int i=0; i<str.length(); i++ ){
            char ch = str.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){
                st.push(ch);
            }
            else if(ch==')'){
                if(!handleClosing(st, '(')){
                    ans = false;
                    break;
                }
            }else if(ch=='}'){
                if(!handleClosing(st, '{')){
                    ans = false;
                    break;
                }
            }else if(ch==']'){
                if(!handleClosing(st, '[')){
                    ans = false;
                    break;
                }
            }
            else{
                continue;
            }
        }
        if(st.size()>0){
            ans = false;
        }
        
        System.out.println(ans);

        scn.close();
    }
    
}
