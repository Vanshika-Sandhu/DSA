// 1. You are given a partially written GenericTree class.
// 2. You are required to complete the body of levelorderLineWise function. The function is expected to visit every node in "levelorder fashion" and print them from left to right (level by level). All nodes on same level should be separated by a space. Different levels should be on separate lines. Please check the question video for more details.
// 3. Input is managed for you.

// Sample Input
// 24
// 10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
// Sample Output
// 10 
// 20 30 40 
// 50 60 70 80 90 100 
// 110 120

package genericTrees;
import java.util.*;

public class levelOrderLineWise {

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
        int m = Integer.MIN_VALUE;
    
        for (Node child : node.children) {
          int cm = max(child);
          m = Math.max(m, cm);
        }
        m = Math.max(m, node.data);
    
        return m;
      }
    
      public static int height(Node node) {
        int h = -1;
    
        for (Node child : node.children) {
          int ch = height(child);
          h = Math.max(h, ch);
        }
        h += 1;
    
        return h;
      }
    
      public static void traversals(Node node){
        System.out.println("Node Pre " + node.data);
    
        for(Node child: node.children){
          System.out.println("Edge Pre " + node.data + "--" + child.data);
          traversals(child);
          System.out.println("Edge Post " + node.data + "--" + child.data);
        }
    
        System.out.println("Node Post " + node.data);
      }
    
      public static void levelOrderLinewise(Node node){
        Queue<Node> mainQ = new ArrayDeque<>();
        mainQ.add(node);
        Queue<Node> childQ = new ArrayDeque<>();
        while(mainQ.size()>0||childQ.size()>0){
            node = mainQ.remove();
            System.out.print(node.data + " ");
            for(Node child : node.children){
                childQ.add(child);
            }
            
            if(mainQ.size()==0){
                System.out.println();
                while(childQ.size()>0){
                    mainQ.add(childQ.remove());
                }
            }
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
    
        Node root = construct(arr);
        levelOrderLinewise(root);

        scn.close();
    }
    
}