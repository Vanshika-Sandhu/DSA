// 1. You are given a number n and a number m representing number of rows and columns in a maze.
// 2. You are standing in the top-left corner and have to reach the bottom-right corner. Only two
// moves are allowed 'h' (1-step horizontal) and 'v' (1-step vertical).

// input
// 2
// 2

// output
// hv
// vh

package recursion.strings;

import java.util.*;

public class printMazePath {

    public static void printPath(int sr, int sc, int dr, int dc, String psf){
        // sr - source row
	    // sc - source column
	    // dr - destination row
	    // dc - destination column

        if(sr == dr && sc == dc){
            System.out.println(psf);
            return;
        }

        if(sr > dr || sc > dc){
            return;
        }

        printPath(sr, sc+1, dr, dc, psf + "h");
        printPath(sr+1, sc, dr, dc, psf + "v");

        return;


    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter number of rows of the maze : ");
        int r = scn.nextInt();
        System.out.println();
        System.out.println("Enter number of columns of the maze : ");
        int c = scn.nextInt();

        printPath(1, 1, r, c, "");
        scn.close();
    }
    
}
