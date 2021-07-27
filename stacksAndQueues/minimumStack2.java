package stacksAndQueues;
import java.util.*;

public class minimumStack2 {

    public static class MinStack {
        Stack<Integer> data;
        int min;
    
        public MinStack() {
          data = new Stack<>();
        }
    
        int size() {
          // write your code here
          return data.size();
        }
    
        void push(int val) {
          // write your code here
          if(data.size()==0 ){
              data.push(val);
              min = val;
          }else{
              if(val<min){
                  data.push(2*val-min); // storing a fake smaller value
                  min = val;            // original value stored in min
              }else{
                  data.push(val);
              }
          }
        }
    
        int pop() {
          // write your code here
          if(data.size()==0){
              System.out.println("Stack underflow");
              return -1;
          }else{
              if(data.peek()<min){
                  int x = data.pop();    // fake value
                  int newMin = 2*min - x;  // the previous min
                  int actualVal = min;     // actual value is stored in min
                  min = newMin;            // replace the new min with previous min
                  return actualVal;
              }else{
                  return data.pop();
              }
          }
        }
    
        int top() {
          // write your code here
          if(data.size()==0){
              System.out.println("Stack underflow");
              return -1;
          }else{
              if(data.peek()<min){
                  return min;     // actual value is stored in min
              }else{
                  return data.peek();
              }
          }
        }
    
        int min() {
          // write your code here
          if(data.size()==0){
              return -1;
          }else{
              return min;
          }
        }
      }
      
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        MinStack st = new MinStack();

        String str = scn.nextLine();
        while(str.equals("quit") == false){
        if(str.startsWith("push")){
            int val = Integer.parseInt(str.split(" ")[1]);
            st.push(val);
        } else if(str.startsWith("pop")){
            int val = st.pop();
            if(val != -1){
            System.out.println(val);
            }
        } else if(str.startsWith("top")){
            int val = st.top();
            if(val != -1){
            System.out.println(val);
            }
        } else if(str.startsWith("size")){
            System.out.println(st.size());
        } else if(str.startsWith("min")){
            int val = st.min();
            if(val != -1){
            System.out.println(val);
            }
        }
        str = scn.nextLine();
        }

        scn.close();
    }
    
}
