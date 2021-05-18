// 1. You are given a number n and a number m representing number of rows and columns in a maze.
// 2. You are standing in the top-left corner and have to reach the bottom-right corner. 
// 3. In a single move you are allowed to jump 1 or more steps horizontally (as h1, h2, .. ),
// or 1 or more steps vertically (as v1, v2, ..) or 1 or more steps diagonally (as d1, d2, ..). 

// input
// 2
// 2

// output
// [h1v1, v1h1, d1]
package recursion.arraylist;

import java.util.*;

public class getMazePathWithJumps {

    public static ArrayList<String> getPath(int sr, int sc, int dr, int dc) {
        if(sr == dr && sc == dc){
            ArrayList<String> bcp = new ArrayList<>();
            bcp.add("");
            return bcp;
        }

        ArrayList<String> finalPath = new ArrayList<>();

        for(int i = 1; i<= dc-sc; i++){
            ArrayList<String> path = getPath(sr, sc+i, dr, dc );
            for(String p : path){
                finalPath.add("h" + i + p);
            }
        }

        for(int i = 1; i<= dr-sr; i++){
            ArrayList<String> path = getPath(sr+i, sc, dr, dc );
            for(String p : path){
                finalPath.add("v" + i + p);
            }
        }

        for(int i = 1; i<= dr-sr && i<= dc- sc; i++){
            ArrayList<String> path = getPath(sr+i, sc+i, dr, dc );
            for(String p : path){
                finalPath.add("d" + i + p);
            }
        }

        return finalPath;
        
    }
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        System.out.println("enter no. of rows");
        int r = scn.nextInt();
        System.out.println("enter no. of columns");
        int c = scn.nextInt();

        ArrayList<String> path = getPath(1, 1, r, c);
        System.out.println(path);

        scn.close();
        
    }
}
