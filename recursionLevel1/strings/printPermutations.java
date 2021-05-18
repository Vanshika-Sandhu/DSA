//  input
// abc

// output
// abc
// acb
// bac
// bca
// cab
// cba

package recursionLevel1.strings;

import java.util.*;

public class printPermutations {

    public static void printpermutations(String str, String asf) {
        if(str.length() == 0){
            System.out.println(asf);
            return;
        }

        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);
            String subs1 = str.substring(0, i);
            String subs2 = str.substring(i+1);
            printpermutations(subs1 + subs2, asf+ch);
        }

        return;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter a string : ");
        String str = scn.nextLine();
        
        printpermutations(str, "");

        scn.close();
    }    
}
