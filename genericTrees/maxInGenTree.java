package genericTrees;
import java.util.*;

public class maxInGenTree {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
      }
    
      public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
          str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);
    
        for (Node child : node.children) {
          display(child);
        }
      }
    
      public static Node construct(int[] arr) {
        Node root = null;
    
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
          if (arr[i] == -1) {
            st.pop();
          } else {
            Node t = new Node();
            t.data = arr[i];
    
            if (st.size() > 0) {
              st.peek().children.add(t);
            } else {
              root = t;
            }
    
            st.push(t);
          }
        }
    
        return root;
      }
    
      public static int size(Node node) {
        int s = 0;
    
        for (Node child : node.children) {
          s += size(child);
        }
        s += 1;
    
        return s;
      }
    
      public static int max(Node node) {
        // no need to write the base case as it is handled in loop for children
        // if(node==null){
        //     return Integer.MIN_VALUE;
        // }
        
        int max = Integer.MIN_VALUE;
        for(Node child: node.children){
             int maxC = max(child);
             max = Math.max(maxC, max);
        }
        
        return Math.max(max, node.data);
      }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];
        String[] values = scn.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(values[i]);
        }

        Node root = construct(arr);
        int max = max(root);
        System.out.println(max);
        // display(root);

        scn.close();

        scn.close();
    }
    
}
