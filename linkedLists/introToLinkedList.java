// 1. You are given a partially written LinkedList class.
// 2. Here is a list of existing functions:
//     2.1 addLast - adds a new element with given value to the end of Linked List
//     2.2. display - Prints the elements of linked list from front to end in a single line. 
//     All elements are separated by space
//     2.3. size - Returns the number of elements in the linked list.
//     2.4. removeFirst - Removes the first element from Linked List. 
//     2.5. getFirst - Returns the data of first element. 
//     2.6. getLast - Returns the data of last element. 
//     2.7. getAt - Returns the data of element available at the index passed. 
//     2.8. addFirst - adds a new element with given value in front of linked list.
//     2.9. addAt - adds a new element at a given index.
//     2.10. removeLast - removes the last element of linked list.
//     2.11. removeAt - remove an element at a given index.
// 3. You are required to complete the body of reverseDI function. The function should be
// an iterative function and should reverse the contents of linked list by changing the "data" property of nodes.
// 4. Input and Output is managed for you.


package linkedLists;
import java.util.*;

public class introToLinkedList {

    public static class Node {
        int data;    
        Node next;    // this would be addressing the next node. they have the same interface(Node type)
      }
    
      public static class LinkedList {
        Node head;    // address of first node in ll
        Node tail;    // address of last node in ll
        int size;     // size of ll
    
        // and the rest functions of linked list
        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;
            if(size == 0){
              //   creating first node where head and tail are the same
                head = tail = temp;
            }else{
              //   linking to the last node which is stored in tail
                tail.next = temp;
                tail = temp;
            }
            size++;
          }

        public int size(){
            return size;
          }
      
        public void display(){
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
          }

        public void removeFirst(){
              if(size == 0){
                  System.out.println("List is empty");
              }else if(size==1){
                  head = tail = null;
                  size = 0;
              }
              else{
                  head = head.next;
                  size--;
              }
          }
        
        public int getFirst(){
          if(size == 0){
              System.out.println("List is empty");
              return -1;
          }else{
              return head.data;
          }
        }
    
        public int getLast(){
          if(size == 0){
              System.out.println("List is empty");
              return -1;
          }else{
              return tail.data;
          }
        }
    
        public int getAt(int idx){
          if(size == 0){
              System.out.println("List is empty");
              return -1;
          }else if(idx >= size || idx<0){
              System.out.println("Invalid arguments");
              return -1;
          }else{
              Node temp = head;
              for(int i=0; i<idx; i++){
                  temp = temp.next;
              }
              return temp.data;
          }
        }

        public void addFirst(int val) {
          Node temp = new Node();
          temp.data = val;
          temp.next = head;
          
          head = temp;
          if(size==0){
              tail = head;
          }
          size++;
        }
    
        public void addAt(int idx, int val){
          if(idx>size || idx<0){
              System.out.println("Invalid arguments");
          }else if(idx == 0){
              addFirst(val);
          }else if(idx == size){
              addLast(val);
          }else{
              Node node = new Node();
              node.data = val;
              
              Node temp = head;
              for(int i=0; i<idx-1; i++){
                  temp = temp.next;
              }
              node.next = temp.next;  // temp.next has address to the next node
              temp.next = node;       // to insert node after temp
              size++;
          }
        }

        public void removeLast(){
          if(size == 0){
              System.out.println("List is empty");
          }else if(size==1){
              head = tail = null;
              size = 0;
          }else{
              Node temp = head;
              for(int i=0; i<size-2; i++){ // to move till the 2nd last element
                temp = temp.next;
              }
              temp.next = null;
              tail = temp;
              size--;
          }
      }

        public void removeAt(int idx) {
          if(idx<0 || idx>=size){
              System.out.println("Invalid arguments");
          }else if(idx == 0){
              removeFirst();
          }else if(idx == size-1){
              removeLast();
          }else{
              Node temp = head;
              for(int i=0; i<idx-1; i++){
                  temp = temp.next;
              }
              temp.next = temp.next.next;
              size--;
          }
        }

        // a helper function
        private Node getNodeAt(int idx){
          Node temp = head;
          for (int i = 0; i < idx; i++) {
            temp = temp.next;
          }
          return temp;
      }
  
        // data iterative
        public void reverseDI() {
          int li = 0;
          int ri = size - 1;
          
          while(li<ri){
              Node left = getNodeAt(li);
              Node right = getNodeAt(ri);
              
              int temp = left.data;
              left.data = right.data;
              right.data = temp;
              
              li++;
              ri--;
          }
      }
        
        // pointer iterative
        public void reversePI(){
          Node prev = null;
          Node curr = head;
          
          while(curr!=null){
              Node next = curr.next;  // to save the curr.next
              curr.next = prev;
              
              prev = curr;
              curr = next;
          }
          Node temp = head;
          head = tail;
          tail = temp;
        }

        


      }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        LinkedList list = new LinkedList();

        String str = scn.nextLine();
        while (str.equals("quit") == false) {
          if (str.startsWith("addLast")) {
            int val = Integer.parseInt(str.split(" ")[1]);
            list.addLast(val);
          } else if (str.startsWith("size")) {
            System.out.println(list.size());
          } else if (str.startsWith("display")) {
            list.display();
          } else if (str.startsWith("removeFirst")) {
            list.removeFirst();
          } else if (str.startsWith("getFirst")) {
            int val = list.getFirst();
            if (val != -1) {
              System.out.println(val);
            }
          } else if (str.startsWith("getLast")) {
            int val = list.getLast();
            if (val != -1) {
              System.out.println(val);
            }
          } else if (str.startsWith("getAt")) {
            int idx = Integer.parseInt(str.split(" ")[1]);
            int val = list.getAt(idx);
            if (val != -1) {
              System.out.println(val);
            }
          } else if (str.startsWith("addFirst")) {
            int val = Integer.parseInt(str.split(" ")[1]);
            list.addFirst(val);
          } else if (str.startsWith("addAt")) {
            int idx = Integer.parseInt(str.split(" ")[1]);
            int val = Integer.parseInt(str.split(" ")[2]);
            list.addAt(idx, val);
          } else if (str.startsWith("removeLast")) {
            list.removeLast();
          } else if (str.startsWith("removeAt")) {
            int idx = Integer.parseInt(str.split(" ")[1]);
            list.removeAt(idx);
          } else if(str.startsWith("reverseDI")){
            list.reverseDI();
          } else if(str.startsWith("reversePI")){
            list.reversePI();
          }
          str = scn.nextLine();
        }
        scn.close();
    }
}
