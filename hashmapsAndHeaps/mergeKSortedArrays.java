// 1. You are given a list of lists, where each list is sorted.
// 2. You are required to complete the body of mergeKSortedLists function. The function is expected to merge k sorted lists to create one sorted list.

// Sample Input
// 4
// 5
// 10 20 30 40 50
// 7
// 5 7 9 11 19 55 57
// 3
// 1 2 3
// 2
// 32 39
// Sample Output
// 1 2 3 5 7 9 10 11 19 20 30 32 39 40 50 55 57 

package hashmapsAndHeaps;
import java.util.*;
import java.io.*;

public class mergeKSortedArrays {
    public static class Pair implements Comparable<Pair> {
        int li;  // list index
        int di;  // data index
        int data; // data value
  
        Pair(int li, int di, int data){
           this.li = li;
           this.di = di;
           this.data = data;
        }
  
        // stores in decreasing order on the basis of data
        public int compareTo(Pair o){
           return this.data - o.data;
        }
     }
  
     public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
        ArrayList<Integer> rv = new ArrayList<>();
  
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        //   to add 0th element of each list in priority queue
        for(int i = 0; i < lists.size(); i++){
           //   p = the 0th element of ith list in the arraylist which which contains k arraylist
           Pair p = new Pair(i, 0, lists.get(i).get(0));
           pq.add(p);
        }
  
        while(pq.size() > 0){
           Pair p = pq.remove(); // removes the smallest of all the elements presendt in priority queue
           rv.add(p.data);
           p.di++;               // move the data index/pointer forward
  
           //   check if data index is less than the list size of index li
           if(p.di < lists.get(p.li).size()){
              p.data = lists.get(p.li).get(p.di);// update value of p from list li at index pi
              pq.add(p);
           }
        }
  
        return rv;
     }
  
     public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for(int i = 0; i < k; i++){
           ArrayList<Integer> list = new ArrayList<>();
  
           int n = Integer.parseInt(br.readLine());
           String[] elements = br.readLine().split(" ");
           for(int j = 0; j < n; j++){
              list.add(Integer.parseInt(elements[j]));
           }
  
           lists.add(list);
        }
  
        ArrayList<Integer> mlist = mergeKSortedLists(lists);
        for(int val: mlist){
           System.out.print(val + " ");
        }
        System.out.println();
     }
}
