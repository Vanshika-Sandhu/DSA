package genericTrees;
import java.util.*;
import java.io.*;

public class levelOrderTraversalMoreApproaches {

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
    
      public static void levelOrderLinewiseZZ(Node node){
        Stack<Node> mainSt = new Stack<>();
        mainSt.push(node);
        
        Stack<Node> childSt = new Stack<>();
        
        int level = 1;
        while(mainSt.size()>0){
            node = mainSt.pop();
            System.out.print(node.data + " ");
            
            if(level%2==0){
                // children stored in reverse order so that when they are popped out, the order is non reverse
                for(int i = node.children.size()-1; i>=0; i--){
                    childSt.push(node.children.get(i));
                }
            }else{
                // children stored in normal way so that when they pop out, they are printed in reverse order
                for(int i=0; i< node.children.size(); i++){
                    childSt.push(node.children.get(i));
                }
            }
        
            if(mainSt.size()==0){
                System.out.println();
                mainSt = childSt;
                childSt = new Stack<>();
                level++;
            }
        }

        
    }
    
    public static void levelOrderLineWise3(Node node) {
        Queue<Node> que = new ArrayDeque<>();
        que.add(node);

        while(que.size()>0){
            int sizeTillNow = que.size();
            for(int i=0; i<sizeTillNow; i++){
                node = que.remove();
                System.out.print(node.data + " ");

                for(Node child : node.children){
                    que.add(child);
                }
            }
            System.out.println();
        }
    }

    public static void levelOrderLineWise2(Node node) {
        Queue<Node> que = new ArrayDeque<>();
        // m1 and m2 are markers
        Node m1 = new Node();
        m1.data = -1;
        que.add(node);
        que.add(m1);

        while(que.size()>0){
            node = que.remove();
            if(node.data==-1){
                System.out.println();
                if(que.size()>0){
                    Node m2 = new Node();
                    m2.data = -1;
                    que.add(m2);
                }
            }else{
                System.out.print(node.data + " ");
                for(Node child : node.children){
                    que.add(child);
                }
            }
        }
    }

    private static class Pair{
      Node node;
      int level;

      Pair(Node node, int level){
        this.node = node;
        this.level = level;
      }
  }

    public static void levelOrderLineWise4(Node node){
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(node, 1));
        int level = 1;
        while(q.size()>0){
          Pair p = q.remove();
          node = p.node;
          if(p.level>level){
            level = p.level;
            System.out.println(); 
          }
          System.out.print(node.data+" ");
          for(Node child: node.children){
            q.add(new Pair(child, level+1));
          }
        }

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
        levelOrderLineWise2(root);
        levelOrderLineWise3(root);
    }
    
}
