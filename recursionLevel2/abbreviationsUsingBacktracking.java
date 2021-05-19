// 1. You are given a word.
// 2. You have to generate all abbrevations of that word.

// Sample Input
// pep

// Sample Output
// pep
// pe1
// p1p
// p2
// 1ep
// 1e1
// 2p
// 3

package recursionLevel2;

import java.util.*;


public class abbreviationsUsingBacktracking {

    public static void abrSolution(String str, String asf, int count, int pos) {
        
    }

    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);

        String str = scn.nextLine();
        abrSolution(str,"",0,0);

        scn.close();
    }
}
