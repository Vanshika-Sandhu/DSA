// 1. You are required to complete the code of our QueueToStackAdapter class. 
// 2. As data members you've two queues available - mainQ and helperQ. mainQ is to contain data
// and helperQ is to assist in operations. (This is cryptic - take hint from video)
// 3. Here is the list of functions that you are supposed to complete
//      3.1. push -> Should accept new data in LIFO manner.
//      3.2. pop -> Should remove and return data in LIFO manner. If not available, print 
//       Stack underflow" and return -1.
//      3.3. top -> Should return data in LIFO manner. If not available, print "Stack 
//      underflow" and return -1.
//      3.4. size -> Should return the number of elements available in the stack.
// 4. Input and Output is managed for you.

// Note -> push and size should work in constant time. pop and top should work in linear time.

package stacksAndQueues;
import java.util.*;

public class queueToStackAdapterPushEff {

    public static class QueueToStackAdapter {
        Queue<Integer> mainQ;
        Queue<Integer> helperQ;
    
        public QueueToStackAdapter() {
          mainQ = new ArrayDeque<>();
          helperQ = new ArrayDeque<>();
        }
    
        int size() {
          return mainQ.size();
        }
    
        // push efficient
        void push(int val) {
          while(mainQ.size()>0){
              helperQ.add(mainQ.remove());
          }
          mainQ.add(val);
          while(helperQ.size()>0){
              mainQ.add(helperQ.remove());
          }
          
        }
    
        int pop() {
          if(mainQ.size()==0){
              System.out.println("Stack underflow");
              return -1;
          }else{
              return mainQ.remove();
          }
        }
    
        int top() {
          if(mainQ.size()==0){
              System.out.println("Stack underflow");
              return -1;
          }else{
              return mainQ.peek();
          }
        }
      }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        QueueToStackAdapter st = new QueueToStackAdapter();

        String str = scn.nextLine();
        while (str.equals("quit") == false) {
        if (str.startsWith("push")) {
            int val = Integer.parseInt(str.split(" ")[1]);
            st.push(val);
        } else if (str.startsWith("pop")) {
            int val = st.pop();
            if (val != -1) {
            System.out.println(val);
            }
        } else if (str.startsWith("top")) {
            int val = st.top();
            if (val != -1) {
            System.out.println(val);
            }
        } else if (str.startsWith("size")) {
            System.out.println(st.size());
        }
        str = scn.nextLine();
        }

        scn.close();
    }
    
}
