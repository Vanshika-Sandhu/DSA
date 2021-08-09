// 1. You are given a partially written BST class.
// 2. You are given a value. You are required to print all pair of nodes which add up to the given value. Make sure all pairs print the smaller value first and avoid duplicacies. Make sure to print the pairs in increasing order. Use the question video to gain clarity.
// 3. Input and Output is managed for you. 

// Sample Input
// 21
// 50 25 12 n n 37 30 n n n 75 62 60 n n 70 n n 87 n n
// 100
// Sample Output
// 25 75
// 30 70

package binarySearchTree;
import java.util.*;
import java.io.*;

public class targetSumPair {
    public static class Node {
        int data;
        Node left;
        Node right;
    
        Node(int data, Node left, Node right) {
          this.data = data;
          this.left = left;
          this.right = right;
        }
      }
    
      public static class Pair {
        Node node;
        int state;
    
        Pair(Node node, int state) {
          this.node = node;
          this.state = state;
        }
      }
    
      public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);
    
        Stack<Pair> st = new Stack<>();
        st.push(rtp);
    
        int idx = 0;
        while (st.size() > 0) {
          Pair top = st.peek();
          if (top.state == 1) {
            idx++;
            if (arr[idx] != null) {
              top.node.left = new Node(arr[idx], null, null);
              Pair lp = new Pair(top.node.left, 1);
              st.push(lp);
            } else {
              top.node.left = null;
            }
    
            top.state++;
          } else if (top.state == 2) {
            idx++;
            if (arr[idx] != null) {
              top.node.right = new Node(arr[idx], null, null);
              Pair rp = new Pair(top.node.right, 1);
              st.push(rp);
            } else {
              top.node.right = null;
            }
    
            top.state++;
          } else {
            st.pop();
          }
        }
    
        return root;
      }
    
      public static void display(Node node) {
        if (node == null) {
          return;
        }
    
        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);
    
        display(node.left);
        display(node.right);
      }
      
      
    // approach 1 => inefficient =>time : O(n*height) = O(nlogn), space : height = logn => targetSumPair1 is recursive which itsef calls find function which is also a recursive function
      public static void targetSumPair1(Node root, Node node, int tar){
          if(node == null){
              return;
          }
          targetSumPair1(root, node.left, tar);
          
          int comp = tar - node.data;
          if(node.data < comp){
              if(find(root, comp) == true){
                  System.out.println(node.data + " " + comp);
              }
          }
          targetSumPair1(root, node.right, tar);
     }
     
      public static boolean find(Node node, int data){
          if(node == null){
              return false;
          }
          if(data < node.data){
              return find(node.left, data);
          }else if(data > node.data){
              return find(node.right, data);
          }else {
              return true;
          }
      }
    
    //  approach 2 => inefficient =>time : O(n), space : n => targetSumPair2 is iterative which reduces time complexity but increases space complexity
      static ArrayList<Integer> list;
      public static void travelAndFill(Node node){
          if(node == null){
              return;
          }
          travelAndFill(node.left);
          list.add(node.data);
          travelAndFill(node.right);
      }
      
    //   approach 3 => best approach => time : O(n), space : O(logn = height) => due to the use of stack and inorder approach, the stack at any instance of time is only filled at max till the height of the tree
    
      public static class ITPair{
          Node node;
          int state;
          
          ITPair(Node node, int state){
              this.node = node;
              this.state = state;
          }
          
      }
      public static void TargetSumPair3(Node root, int tar){
          Stack<ITPair> ls = new Stack<>();
          Stack<ITPair> rs = new Stack<>();
          
          ls.push(new ITPair(root, 0));
          rs.push(new ITPair(root, 0));
          
          Node left = getNextFromNormalInorder(ls);
          Node right = getNextFromReverseInorder(rs);
          
          while(left.data<right.data){
              if(left.data+right.data<tar){
                  left = getNextFromNormalInorder(ls);
              }else if(left.data + right.data > tar){
                  right = getNextFromReverseInorder(rs);
              }else{
                  System.out.println(left.data + " " + right.data);
                  left = getNextFromNormalInorder(ls);
                  right = getNextFromReverseInorder(rs);
              }
          }
          
      }
      
      
      public static Node getNextFromNormalInorder(Stack<ITPair> st){
          while(st.size()>0){
              ITPair top = st.peek();
              if(top.state == 0){
                  if(top.node.left!=null){
                      st.push(new ITPair(top.node.left, 0));
                  }
                  top.state++;
              }else if(top.state == 1){
                  if(top.node.right!=null){
                      st.push(new ITPair(top.node.right, 0));
                  }
                  top.state++;
                  return top.node;
              }else{
                  st.pop();
              }
          }
          return null;
      }
      
        public static Node getNextFromReverseInorder(Stack<ITPair> st){
          while(st.size()>0){
              ITPair top = st.peek();
              if(top.state == 0){
                  if(top.node.right!=null){
                      st.push(new ITPair(top.node.right, 0));
                  }
                  top.state++;
              }else if(top.state == 1){
                  if(top.node.left!=null){
                      st.push(new ITPair(top.node.left, 0));
                  }
                  top.state++;
                  return top.node;
              }else{
                  st.pop();
              }
          }
          return null;
      }
    
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
          if (values[i].equals("n") == false) {
            arr[i] = Integer.parseInt(values[i]);
          } else {
            arr[i] = null;
          }
        }
    
        int data = Integer.parseInt(br.readLine());
    
        Node root = construct(arr);
        // approach 1
        // targetSumPair1(root, root, data);
        
        // approach 2
        // list = new ArrayList<>();
        // travelAndFill(root);
        
        // int l = 0;
        // int r = list.size()-1;
        // while(l<r){
        //     if(list.get(l) + list.get(r) > data){
        //         r--;
        //     }else if(list.get(l) + list.get(r) < data){
        //         l++;
        //     }else{
        //         System.out.println(list.get(l) + " " + list.get(r));
        //         l++;
        //         r--;
        //     }
        // }
        
        // approach 3
        TargetSumPair3(root, data);
        
      }
    
}
