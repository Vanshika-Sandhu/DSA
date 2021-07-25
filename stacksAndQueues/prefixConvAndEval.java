// 1. You are given a prefix expression.
// 2. You are required to evaluate it and print it's value.
// 3. You are required to convert it to infix and print it.
// 4. You are required to convert it to postfix and print it.

// Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.

// Sample Output
// 2
// ((2+((6*4)/8))-3)
// 264*8/+3-

package stacksAndQueues;
import java.util.*;

public class prefixConvAndEval {

    public static int calc(int v1, int v2, char op){
        if(op=='+'){
            return v1 + v2;
        }else if(op=='-'){
            return v1 - v2;
        }else if(op=='*'){
            return v1 * v2;
        }else{
            return v1 / v2;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String exp = scn.nextLine();

        // code
        Stack<Integer> val = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> postfix = new Stack<>();
        
        for(int i=exp.length()-1; i>=0; i-- ){
            char ch = exp.charAt(i);
            
            if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
                int v1 = val.pop();
                int v2 = val.pop();
                int v = calc(v1, v2, ch);
                val.push(v);
                
                String in1 = infix.pop();
                String in2 = infix.pop();
                String in = "(" + in1 + ch + in2 + ")";
                infix.push(in);
                
                String post1 = postfix.pop();
                String post2 = postfix.pop();
                String post = post1 + post2 + ch ;
                postfix.push(post);
            }else{
                val.push(ch-'0');
                infix.push(ch+"");
                postfix.push(ch+"");
            }
        }
    
        
        System.out.println(val.pop());
        System.out.println(infix.pop());
        System.out.println(postfix.pop());
        

        scn.close();
    }
    
}
