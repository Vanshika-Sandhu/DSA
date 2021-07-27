package stacksAndQueues;
import java.util.*;

public class stackToQueueAdaptorAddEff {

    public static class StackToQueueAdapter {
        Stack<Integer> mainS;
        Stack<Integer> helperS;
    
        public StackToQueueAdapter() {
          mainS = new Stack<>();
          helperS = new Stack<>();
        }
    
        int size() {
          return mainS.size();
        }
    
        void add(int val) {
            mainS.push(val);
        }
    
        int remove() {
          if(mainS.size()==0){
              System.out.println("Queue underflow");
              return -1;
          }else{
              while(mainS.size()>1 ){
                  helperS.push(mainS.pop());
              }
              int x = mainS.pop();
              while(helperS.size()>0 ){
                  mainS.push(helperS.pop());
              }
              return x;
          }
        }
    
        int peek() {
          if(mainS.size()==0){
              System.out.println("Queue underflow");
              return -1;
          }else{
              while(mainS.size()>1 ){
                  helperS.push(mainS.pop());
              }
              int x = mainS.pop();
              helperS.push(x);
              while(helperS.size()>0 ){
                  mainS.push(helperS.pop());
              }
              return x;
          }
        }
      }
      
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        StackToQueueAdapter qu = new StackToQueueAdapter();

        String str = scn.nextLine();
        while (str.equals("quit") == false) {
          if (str.startsWith("add")) {
            int val = Integer.parseInt(str.split(" ")[1]);
            qu.add(val);
          } else if (str.startsWith("remove")) {
            int val = qu.remove();
            if (val != -1) {
              System.out.println(val);
            }
          } else if (str.startsWith("peek")) {
            int val = qu.peek();
            if (val != -1) {
              System.out.println(val);
            }
          } else if (str.startsWith("size")) {
            System.out.println(qu.size());
          }
          str = scn.nextLine();
        }

        scn.close();
    }
}
