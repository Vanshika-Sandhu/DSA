package binarySearchTree;

public class introBinarySearchTree {
    // node class used for binary search tree
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

    public static Node constructor(int[] arr, int lo, int hi){
        if(lo>hi){
            return null;
        }
        int mid = (lo+hi)/2;
        int midData = arr[mid];
        Node lc = constructor(arr, lo, mid-1);
        Node rc = constructor(arr, mid+1, hi);

        Node node = new Node(midData, lc, rc);
        return node;
    }
    public static void main(String[] args) throws Exception {
        int[] arr = {12, 25, 37, 52, 68, 74, 104};
        Node root = constructor(arr, 0, arr.length-1);
        display(root);
    }
    
}