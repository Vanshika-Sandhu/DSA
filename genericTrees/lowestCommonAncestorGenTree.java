// 1. You are given a partially written GenericTree class.
// 2. You are required to complete the body of lca function. The function is expected to return the lowest common ancestor of two data values that are passed to it. 
// Please watch the question video to understand what lca is.
// 3. Input and Output is managed for you.

// Sample Input
// 24
// 10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
// 120
// 80
// Sample Output
// 80

package genericTrees;
import java.util.*;

public class lowestCommonAncestorGenTree {
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
    
      public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
        if (node.data == data) {
          ArrayList<Integer> path = new ArrayList<>();
          path.add(node.data);
          return path;
        }
    
        for (Node child : node.children) {
          ArrayList<Integer> ptc = nodeToRootPath(child, data);
          if (ptc.size() > 0) {
            ptc.add(node.data);
            return ptc;
          }
        }
    
        return new ArrayList<>();
      }
    
      public static int lca(Node node, int d1, int d2) {
        // write your code here
        ArrayList<Integer> p1 = nodeToRootPath(node, d1);
        ArrayList<Integer> p2 = nodeToRootPath(node, d2);
        
        int i = p1.size()-1;
        int j = p2.size()-1;
        while(i>=0 && j>=0 && p1.get(i)==p2.get(j)){
            i--;
            j--;
        }
        // out of this loop, we get the first unequal elements
        
        // to get to the equal elements i.e. the lowest common ancestor
        return p1.get(i+1);
      }
    

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        String[] values = scn.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
          arr[i] = Integer.parseInt(values[i]);
        }
    
        int d1 = scn.nextInt();
        int d2 = scn.nextInt();
    
        Node root = construct(arr);
        int lca = lca(root, d1, d2);
        System.out.println(lca);
        // display(root);
        scn.close();
    }
    
}