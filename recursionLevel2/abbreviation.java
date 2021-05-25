// 1. You are given a word.
// 2. You have to generate all abbrevations of that word.

// Sample Input
// pep

// Sample Output
// pep  => 000
// pe1  => 001
// p1p  => 010
// p2   => 011  => 02
// 1ep  => 100 
// 1e1  => 101
// 2p   => 110  => 20
// 3    => 111  => 3

package recursionLevel2;

import java.util.*;


public class abbreviation {

    public static void abrSolution(String str, String asf, int count, int pos) {
        // base case
        if(pos == str.length() ){
            if(count == 0){
                System.out.println(asf);
            }else{
                System.out.println(asf + count);
            }
            return;
        }

        // 2 calls, one for yes and one for no
        
        // yes
        // if count > 0 => add count and char to asf, make count = 0
        // else, only add char, dont change the count
        char ch = str.charAt(pos);
        if(count>0){
            abrSolution(str, asf+count+ch, 0, pos+1);
        }else{
            abrSolution(str, asf+ch, count, pos+1);
        }

        // no => increase the count
        abrSolution(str, asf, count+1, pos+1);

        return;
        
    }

    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter a string");
        String str = scn.nextLine();
        abrSolution(str,"",0,0);

        scn.close();
    }
}
