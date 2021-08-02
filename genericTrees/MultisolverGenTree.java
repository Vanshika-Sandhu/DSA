// multisolver is a void function which will update the new data members
// the main purpose of this function is to travel
// in this we will take four data members with initial values as
// size = 0;
// max = Integer.MIN_VALUE;
// min = Integer.MAX_VALUE;
// height = 0;

package genericTrees;
import java.util.*;

public class MultisolverGenTree {
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

      static int size;
      static int min;
      static int max;
      static int height;
      public static void multisolver(Node node, int depth){
        size +=1;
        max = Math.max(max, node.data);
        min = Math.min(min, node.data);
        height = Math.max(height, depth);

        for(Node child : node.children){
            multisolver(child, depth+1);
        }

        System.out.println("Size : " + size + "\n" + "Min : " + min + "\n" + "Max : " + max + "\n" + "height :" + height);

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
        size = 0;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        height = 0;
        multisolver(root, 0);
        // display(root);
        scn.close();
    }
    
}
