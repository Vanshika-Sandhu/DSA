// 1. You are given a postfix expression.
// 2. You are required to evaluate it and print it's value.
// 3. You are required to convert it to infix and print it.
// 4. You are required to convert it to prefix and print it.
// Note -> Use brackets in infix expression for indicating precedence. Check sample input output for more details.

// Sample Input
// 264*8/+3-
// Sample Output
// 2
// ((2+((6*4)/8))-3)
// -+2/*6483


package stacksAndQueues;
import java.util.*;

public class prefixConvAndEval {

    public static int calc(int a, int b, char op){
        if(op=='+'){
            return a+b;
        }else if(op=='-'){
            return a-b;
        }else if(op=='*'){
            return a*b;
        }else{
            return a/b;
        }
    }
  
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String exp = scn.nextLine();

        Stack<Integer> val = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> prefix = new Stack<>();
        
        for(int i=0; i<exp.length(); i++){
            char ch = exp.charAt(i);
            
            if(ch=='+' || ch == '-' || ch == '*' || ch == '/'){
                // for value
                int v2 = val.pop();   
                int v1 = val.pop();
                int v = calc(v1, v2, ch);
                val.push(v);
                
                // for prefix
                String p2 = prefix.pop();
                String p1 = prefix.pop();
                String p = ch + p1 + p2;
                prefix.push(p);
                
                // for infix
                String i2 = infix.pop();
                String i1 = infix.pop();
                String inf = "(" + i1 + ch + i2 + ")";
                infix.push(inf);
            }
            else{
                val.push(ch-'0');
                infix.push(ch+"");
                prefix.push(ch+"");
            }
        }
        
        System.out.println(val.peek());
        System.out.println(infix.peek() );
        System.out.println(prefix.peek() );

        scn.close();
    }
    
}
