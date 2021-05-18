// 1. You are given a number n and a number m representing number of rows and columns in a maze.
// 2. You are standing in the top-left corner and have to reach the bottom-right corner. 
// 3. In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ), or
// 1 or more steps vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..). 

// input
// 3
// 3

// output
// h1h1v1v1
// h1h1v2
// h1v1h1v1
// h1v1v1h1
// h1v1d1
// h1v2h1
// h1d1v1
// h2v1v1
// h2v2
// v1h1h1v1
// v1h1v1h1
// v1h1d1
// v1h2v1
// v1v1h1h1
// v1v1h2
// v1d1h1
// v2h1h1
// v2h2
// d1h1v1
// d1v1h1
// d1d1
// d2
package recursionLevel1.strings;


import java.util.*;

public class printMazePathWithJumps {
    public static void printPath(int sr, int sc, int dr, int dc, String psf){

        if(sr == dr && sc == dc){
            System.out.println(psf);
            return;
        }


        // horizontal
        for(int i = 1; i<=dc - sc; i++){
            printPath(sr, sc+i, dr, dc, psf + "h" + i);
        }
        // vertical
        for(int i = 1; i<=dr - sr; i++){
            printPath(sr+i, sc, dr, dc, psf + "v" + i);
        }
        // diagonal
        for(int i = 1; i<=dc - sc; i++){
            printPath(sr+i, sc+i, dr, dc, psf + "d" + i);
        }

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
