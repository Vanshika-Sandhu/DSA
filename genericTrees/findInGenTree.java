// 1. You are given a partially written GenericTree class.
// 2. You are required to complete the body of find function. The function is expected to find the given data in the tree, if found it should return true or return false.
// 3. Input and Output is managed for you.

// Sample Input
// 24
// 10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
// 120
// Sample Output
// true


package genericTrees;
import java.util.*;

public class findInGenTree {

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
    
      public static boolean find(Node node, int data) {
        if(node == null){
            return false;
        }
        if(node.data == data){
            return true;
        }else{
            boolean ans = false;
            for(Node child : node.children){
                boolean ca = find(child, data);
                if(ca){
                    ans = true;
                }
            }
            return ans;
        }
      }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        String[] values = scn.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
          arr[i] = Integer.parseInt(values[i]);
        }
    
        int data = scn.nextInt();
    
        Node root = construct(arr);
        boolean flag = find(root, data);
        System.out.println(flag);
        // display(root);
        scn.close();
    }
}
