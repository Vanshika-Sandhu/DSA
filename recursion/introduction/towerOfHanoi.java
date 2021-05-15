// 1. There are 3 towers. Tower A has n disks, where n is a positive number. Tower B and C are empty.
// 2. The disks are increasingly placed in terms of size such that the smallest disk is on top and largest disk is at bottom.
// 3. You are required to 
//     3.1. Print the instructions to move the disks.
//     3.2. from tower A to tower B using tower C
//     3.3. following the rules
//         3.3.1 move 1 disk at a time.
//         3.3.2 never place a smaller disk under a larger disk.
//         3.3.3 you can only move a disk at the top.

// SAMPLE INPUT
// 3

// SAMPLE OUTPUT
// 1[A -> B]
// 2[A -> C]
// 1[B -> C]
// 3[A -> B]
// 1[C -> A]
// 2[C -> B]
// 1[A -> B]


import java.util.*;

public class towerOfHanoi {

    public static void TOH(int n, char st, char dt, char ht){
        if(n==0){
            return;
        }

        TOH(n-1, st, ht, dt);
        System.out.println(n + "[" + st + " -> " + dt + "]" );
        TOH(n-1, ht, dt, st);

        return;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number of disks : ");
        int n = scn.nextInt();
        TOH(n, 'A', 'B', 'C');

        scn.close();
    }
}
