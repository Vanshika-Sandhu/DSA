package stacksAndQueues;
import java.util.*;

public class introQueue {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        //Queue class is an interface thus queue can not be newed using Queue<>(), so we use ArrayDeque<>() 
        // interfaces only have function declaration(name) in them but not function definition(body)
        // ArrayDeque class -> implements Deque interface -> which further implements Queue interface
        Queue<Integer> que = new ArrayDeque<>();
        que.add(10);
        System.out.println(que);
        que.add(20);
        System.out.println(que);
        que.add(30);
        System.out.println(que);
        System.out.println(que.peek());
        System.out.println(que);
        System.out.println(que.remove());
        System.out.println(que);
        System.out.println(que.remove());
        System.out.println(que);

        // output
        // [10]
        // [10, 20]
        // [10, 20, 30]
        // 10
        // [10, 20, 30]
        // 10
        // [20, 30]
        // 20
        // [30]



        scn.close();
    }
    
}
