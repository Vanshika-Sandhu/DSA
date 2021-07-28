// 1. You are given a partially written LinkedList class.
// 2. You are required to complete the body of addLast function. This function is supposed
// to add an element to the end of LinkedList. You are required to update head, tail and size as required.
// 3. Input and Output is managed for you. Just update the code in addLast function.

// Sample Input
// addLast 10
// addLast 20
// addLast 30
// addLast 40
// addLast 50
// quit
// Sample Output
// 10
// 20
// 30
// 40
// 50
// 5
// 50

package linkedLists;
import java.util.*;

public class addLastInLl {

    public static class Node{
        int data;
        Node next;
    }

    public static class LinkedList{
        Node head;
        Node tail;
        int size;

        void addLast(int val) {
            
            Node temp = new Node();
            temp.data = val;
            temp.next = null;
            if(size == 0){
              //   creating first node where head and tail are the same
                head = tail = temp;
                size++;
            }else{
              //   linking to the last node which is stored in tail
                tail.next = temp;
                tail = temp;
                size++;
            }
          }
    }

    public static void testList(LinkedList list) {
        for (Node temp = list.head; temp != null; temp = temp.next) {
          System.out.println(temp.data);
        }
        System.out.println(list.size);
    
        if (list.size > 0) {
          System.out.println(list.tail.data);
        } 
      }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        LinkedList list = new LinkedList();

        String str = scn.nextLine();
        while(str.equals("quit") == false){
          if(str.startsWith("addLast")){
            int val = Integer.parseInt(str.split(" ")[1]);
            list.addLast(val);
          } 
          str = scn.nextLine();
        }
    
        testList(list);
        scn.close();
    }
    
}
