// 1. You are given an infix expression.
// 2. You are required to convert it to postfix and print it.
// 3. You are required to convert it to prefix and print it.

// Input Format
// Input is managed for you

// Output Format
// postfix
// prefix

// Constraints
// 1. Expression is balanced
// 2. The only operators used are +, -, *, /
// 3. Opening and closing brackets - () - are used to impact precedence of operations
// 4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
// 5. In two operators of equal precedence give preference to the one on left.
// 6. All operands are single digit numbers.

// Sample Input
// a*(b-c+d)/e
// Sample Output
// abc-d+*e/

package stacksAndQueues;
import java.util.*;

public class infixConversion {
    public static int precedence(char op){
        if(op == '+' || op == '-'){
          return 1;
        } else if(op == '*' || op == '/'){
          return 2;
        } else {
          return 0;
        }
      }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String exp = scn.nextLine();

    // code
    
    Stack<String> pre = new Stack<>();
    Stack<String> post = new Stack<>();
    Stack<Character> operators = new Stack<>();
    
    for(int i=0; i<exp.length(); i++ ){
        char ch =  exp.charAt(i);
        
        if(ch == '('){
            operators.push(ch);
        }
        else if((ch>='0'&&ch<='9') || (ch>='a'&&ch<='z') || (ch>='A'&&ch<='Z')){
            pre.push(ch + "");
            post.push(ch + "");
            
        }
        else if(ch == ')'){
            while(operators.peek()!='('){
                Character op= operators.pop();
                // v2 is upper in stack and v1 is lower
                String prev2 = pre.pop();
                String prev1 = pre.pop();
                String prev = op + prev1 + prev2;
                pre.push(prev);
                
                String postv2 = post.pop();
                String postv1 = post.pop();
                String postv = postv1 + postv2 + op;
                post.push(postv);
            }
            operators.pop();   // an extra for the opening bracket left
        }
        else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
            while(operators.size()>0 && operators.peek()!='(' && precedence(ch)<=precedence(operators.peek())){
                Character op= operators.pop();
                // v2 is upper in stack and v1 is lower
                String prev2 = pre.pop();
                String prev1 = pre.pop();
                String prev = op + prev1 + prev2;
                pre.push(prev);
                
                String postv2 = post.pop();
                String postv1 = post.pop();
                String postv = postv1 + postv2 + op;
                post.push(postv);
            }
            operators.push(ch);
        }
    }
    
    while(operators.size()>0){
        Character op= operators.pop();
                // v2 is upper in stack and v1 is lower
                String prev2 = pre.pop();
                String prev1 = pre.pop();
                String prev = op + prev1 + prev2;
                pre.push(prev);
                
                String postv2 = post.pop();
                String postv1 = post.pop();
                String postv = postv1 + postv2 + op;
                post.push(postv);
    }
    
    System.out.println(post.peek());
    System.out.println(pre.peek());

        scn.close();
    }
    
}
