// 1. You are given a string str. The string str will contains numbers only, where each number stands for a key pressed on a mobile phone.
// 2. The following list is the key to characters map
//     0 -> .;
//    1 -> abc
//    2 -> def
//    3 -> ghi
//    4 -> jkl
//    5 -> mno
//    6 -> pqrs
//    7 -> tu
//    8 -> vwx
//    9 -> yz


// input
// 78

// output
// tv
// tw
// tx
// uv
// uw
// ux

package recursionLevel1.strings;

import java.util.*;

public class printKPC {


    static String[] codes = {".,", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};


    public static void printFunc(String str, String asf){

        if(str.length() == 0){
            System.out.println(asf);
            return;
        }

        String substr = str.substring(1);
        char ch = str.charAt(0);
        String code = codes[ch - '0'];

        for(int i = 0; i<code.length(); i++ ){
            char c = code.charAt(i);
            printFunc(substr, asf+c);
        }

        return;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter a number string :");
        String str = scn.nextLine();
        printFunc(str, "");

        scn.close();
    }
}
