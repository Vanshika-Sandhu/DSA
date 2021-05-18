// 1. You are given a number n and a number m representing number of rows and columns in a maze.
// 2. You are standing in the top-left corner and have to reach the bottom-right corner. Only two
// moves are allowed 'h' (1-step horizontal) and 'v' (1-step vertical).

// input
// 3
// 3

// output
// [hhvv, hvhv, hvvh, vhhv, vhvh, vvhh]

package recursionLevel1.arraylist;

import java.util.*;

public class getMazePath {
    
    public static ArrayList<String> getPath(int sr, int sc, int dr, int dc){

        if(dr == sr && dc == sc){
            ArrayList<String> bcp = new ArrayList<>();
            bcp.add("");
            return bcp;
        }

        ArrayList<String> finalPath = new ArrayList<>();

        if(sc<dc){
            ArrayList<String> p1 = getPath(sr, sc+1, dr, dc);
            for(String p : p1){
                finalPath.add("h" + p);
            }
        }
        if(sr<dr){
            ArrayList<String> p2 = getPath(sr+1, sc, dr, dc);
            for(String p : p2){
                finalPath.add("v" + p);
            }
        }

        return finalPath;

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("enter no. of rows ");
        int r = scn.nextInt();
        System.out.println("enter no. of columns");
        int c = scn.nextInt();

        ArrayList<String> path = getPath(1, 1, r, c);
        System.out.println(path);

        scn.close();
    }
}
