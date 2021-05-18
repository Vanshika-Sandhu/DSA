// 1. You are given a number n representing number of stairs in a staircase.
// 2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.

// input
// 3

// output
// [111, 12, 21, 3]

package recursion.arraylist;

import java.util.*;

public class getStairsPath {

    public static ArrayList<String> getPath(int n){
        if(n == 0){
            ArrayList<String> bcp = new ArrayList<>();
            bcp.add("");
            return bcp;
        }
        
        ArrayList<String> pathFinal = new ArrayList<>();

        ArrayList<String> p1 = getPath(n-1);
        for(String p : p1){
            pathFinal.add("1" + p);
        }
        if(n>=2){
            ArrayList<String> p2 = getPath(n-2);
            for(String p : p2){
                pathFinal.add("2" + p);
            }
        }

        if(n>=3){
            ArrayList<String> p3 = getPath(n-3);
            for(String p : p3){
                pathFinal.add("3" + p);
            }
        }

        return pathFinal;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter number of Stairs : ");
        int n = scn.nextInt();

        ArrayList<String> path = getPath(n);
        System.out.println(path);

        scn.close();
    }
}
