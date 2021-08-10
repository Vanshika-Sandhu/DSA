package hashmapsAndHeaps;
import java.util.*;

public class priorityQueue {
    public static void main(String[] args) {
        
        // by default gives priority to smaller values
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();

        // gives priority to larger values
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

        int[] ranks = {22, 99, 1, 7, 80, 45, 76, 11};

        for(int val : ranks){
            pq1.add(val);
            pq2.add(val);
        }

        // smallest priority
        System.out.println("smallest priority");
        while(pq1.size()>0){
            System.out.println(pq1.peek());
            pq1.remove();
        }

        // largest priority
        System.out.println("largest priority");
        while(pq2.size()>0){
            System.out.println(pq2.peek());
            pq2.remove();
        }

    }
    
}
