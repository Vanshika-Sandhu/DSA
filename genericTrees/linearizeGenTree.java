// 1. You are given a partially written GenericTree class.
// 2. You are required to complete the body of linearize function. The function is expected to create a linear tree i.e. every node will have a single child only. For details check the question video.
// 3. Input and Output is managed for you.

// Sample Input
// 24
// 10 20 50 -1 60 -1 -1 30 70 -1 80 110 -1 120 -1 -1 90 -1 -1 40 100 -1 -1 -1
// Sample Output
// 10 -> 20, .
// 20 -> 50, .
// 50 -> 60, .
// 60 -> 30, .
// 30 -> 70, .
// 70 -> 80, .
// 80 -> 110, .
// 110 -> 120, .
// 120 -> 90, .
// 90 -> 40, .
// 40 -> 100, .
// 100 -> .


package genericTrees;
import java.util.*;
import java.io.*;

public class linearizeGenTree {
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
    
      public static void traversals(Node node) {
        System.out.println("Node Pre " + node.data);
    
        for (Node child : node.children) {
          System.out.println("Edge Pre " + node.data + "--" + child.data);
          traversals(child);
          System.out.println("Edge Post " + node.data + "--" + child.data);
        }
    
        System.out.println("Node Post " + node.data);
      }
    
      public static void levelOrderLinewiseZZ(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.add(node);
    
        Stack<Node> cstack = new Stack<>();
        int level = 0;
    
        while (stack.size() > 0) {
          node = stack.pop();
          System.out.print(node.data + " ");
    
          if (level % 2 == 0) {
            for (int i = 0; i < node.children.size(); i++) {
              Node child = node.children.get(i);
              cstack.push(child);
            }
          } else {
            for (int i = node.children.size() - 1; i >= 0; i--) {
              Node child = node.children.get(i);
              cstack.push(child);
            }
          }
    
          if (stack.size() == 0) {
            stack = cstack;
            cstack = new Stack<>();
            level++;
            System.out.println();
          }
        }
      }
    
      public static void mirror(Node node) {
        for (Node child : node.children) {
          mirror(child);
        }
        Collections.reverse(node.children);
      }
    
      public static void removeLeaves(Node node) {
        for (int i = node.children.size() - 1; i >= 0; i--) {
          Node child = node.children.get(i);
          if (child.children.size() == 0) {
            node.children.remove(i);
          }
        }
    
        for(Node child: node.children){
          removeLeaves(child);
        }
      }
    
      private static Node getTail(Node node){
          while(node.children.size()==1){
              node = node.children.get(0);
          }
          return node;
      }
    
      // approach 1
      public static void linearize(Node node){
        //   faith
        for(Node child : node.children){
            linearize(child);
        }
        while(node.children.size()>1){
            Node lastChild = node.children.remove(node.children.size()-1);
            // this same index gives second last child as the last child is removed and now the second last child has become the last child
            Node secondLastChild = node.children.get(node.children.size()-1);
            Node secondLastChildTail = getTail(secondLastChild);
            secondLastChildTail.children.add(lastChild);
        }
      }

      // approach 2
      public static Node linearize2(Node node){

        if(node.children.size()==0){
          return node;
        }
        //   faith
        Node lastChildTail = linearize2(node.children.get(node.children.size()-1));
        
        while(node.children.size()>1){
            Node lastChild = node.children.remove(node.children.size()-1);
            // this same index gives second last child as the last child is removed and now the second last child has become the last child
            Node secondLastChild = node.children.get(node.children.size()-1);
            Node secondLastChildTail = linearize2(secondLastChild);
            secondLastChildTail.children.add(lastChild);
        }

        return lastChildTail;
      }
    

    public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];
      String[] values = br.readLine().split(" ");
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(values[i]);
      }
  
      Node root = construct(arr);
      levelOrderLinewiseZZ(root);
    }
    
}
