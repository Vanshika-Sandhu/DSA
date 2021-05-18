// 1. You are given a number n representing number of stairs in a staircase.
// 2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.

// input
// 3

// output
// 111
// 12
// 21
// 3

package recursion.strings;

import java.util.*;

public class printStairPath{
    public static void printPath(int s, String asf){
        if(s == 0){
            System.out.println(asf);
            return;
        }
        if(s<0)
            return;

        printPath(s-1, asf + "1");
        printPath(s-2, asf + "2");
        printPath(s-3, asf + "3");     

        return;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter number of stairs : ");
        int stairs = scn.nextInt();
        printPath(stairs, "");
        scn.close();
    }
}