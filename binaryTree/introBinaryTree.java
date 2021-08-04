package binaryTree;
import java.util.*;
import java.io.*;

public class introBinaryTree {
    // node class used for binary tree
    public static class Node{
        int data;
        Node left;
        Node right;
        
        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static class Pair{
        Node node;
        int state;

        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }

    public static void display(Node node){
        if(node == null){
            return;
        }

        String str = "";
        str += node.left==null?"." : node.left.data + "";
        str += "<-" + node.data +"->";
        str += node.right==null?"." : node.right.data + "";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }

    public static void traversalPre(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.data + " ");
        traversalPre(node.left);
        traversalPre(node.right);
    }

    public static void traversalIn(Node node){
        if(node==null){
            return;
        }
        traversalIn(node.left);
        System.out.print(node.data + " ");
        traversalIn(node.right);
    }

    public static void traversalPost(Node node){
        if(node==null){
            return;
        }
        traversalPost(node.left);
        traversalPost(node.right);
        System.out.print(node.data + " ");
    }
    public static void main(String[] args) throws Exception{
        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};

        Stack<Pair> st = new Stack<>();
        Node root = new Node(arr[0], null, null);
        Pair rootPair = new Pair(root, 1);

        st.push(rootPair);

        int idx = 0;
        while(st.size()>0){
            Pair top = st.peek();

            if(top.state == 1){
                idx++;
                if(arr[idx]!=null){
                    Node leftNode = new Node(arr[idx], null, null);
                    top.node.left = leftNode;

                    Pair leftPair = new Pair(leftNode, 1);
                    st.push(leftPair);
                }else{
                    top.node.left = null;
                }
            }else if(top.state == 2){
                idx++;
                if(arr[idx]!=null){
                    Node rightNode = new Node(arr[idx], null, null);
                    top.node.right = rightNode;

                    Pair rightPair = new Pair(rightNode, 1);
                    st.push(rightPair);
                }else{
                    top.node.right = null;
                }
            }else{
                st.pop();
            }
            top.state++;
        }

        display(root);
        System.out.print("Preorder : ");
        traversalPre(root);
        System.out.print("\nInorder : ");
        traversalIn(root);
        System.out.print("\nPostorder : ");
        traversalPost(root);

    }
    
}
