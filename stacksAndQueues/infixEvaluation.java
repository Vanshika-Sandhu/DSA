// 1. You are given an infix expression.
// 2. You are required to evaluate and print it's value.

// Constraints
// 1. Expression is balanced
// 2. The only operators used are +, -, *, /
// 3. Opening and closing brackets - () - are used to impact precedence of operations
// 4. + and - have equal precedence which is less than * and /. * and / also have equal precedence.
// 5. In two operators of equal precedence give preference to the one on left.
// 6. All operands are single digit numbers.

// Sample Input
// 2 + 6 * 4 / 8 - 3
// Sample Output
// 2

package stacksAndQueues;
import java.util.*;

public class infixEvaluation {

    public static int operation(int val1, int val2, char op){
        if(op == '+'){
          return val1 + val2;
        } else if(op == '-'){
          return val1 - val2;
        } else if(op == '*'){
          return val1 * val2;
        } else {
          return val1 / val2;
        }
      }

      public static int precedence(char op){
        if(op == '+'){
          return 1;
        } else if(op == '-'){
          return 1;
        } else if(op == '*'){
          return 2;
        } else {
          return 2;
        }
      }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        String exp = scn.nextLine();

        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
    
        for (int i = 0; i < exp.length(); i++) {
          char ch = exp.charAt(i);
            // case 1
          if (ch == '(') {
            operators.push(ch);
          }
            // case 2 
          else if (Character.isDigit(ch)) {
            operands.push(ch - '0');
          }
            // case 3
          else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            //   ch waits so that higher priority operators solve themselves first
            while (operators.size() > 0 && operators.peek() != '(' && 
                   precedence(ch) <= precedence(operators.peek())) {
              int val2 = operands.pop();
              int val1 = operands.pop();
              char op = operators.pop();
    
              int opval = operation(val1, val2, op);
              operands.push(opval);
            }
            // ch is pushing itself now
            operators.push(ch);
          }     
            // case 4 
          else if (ch == ')') {
            while (operators.size() > 0 && operators.peek() != '(') {
              int val2 = operands.pop();
              int val1 = operands.pop();
              char op = operators.pop();
    
              int opval = operation(val1, val2, op);
              operands.push(opval);
            }

            if (operators.size() > 0) {
              operators.pop();
            }
          }
        }
    
        // to calculate the remaining elements in stack
        while (operators.size() > 0) {
          int val2 = operands.pop();
          int val1 = operands.pop();
          char op = operators.pop();
    
          int opval = operation(val1, val2, op);
          operands.push(opval);
        }
    
        int val = operands.pop();
        System.out.println(val);


        scn.close();

    }
    
}
