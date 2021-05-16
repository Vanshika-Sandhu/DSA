// 1. You are given a string str. The string str will contains numbers only, where each number stands for a key pressed on a mobile phone.
// 2. The following list is the key to characters map :
//     0 -> .;
//     1 -> abc
//     2 -> def
//     3 -> ghi
//     4 -> jkl
//     5 -> mno
//     6 -> pqrs
//     7 -> tu
//     8 -> vwx
//     9 -> yz

// input
// 78

// output
// [tv, tw, tx, uv, uw, ux]

import java.util.*;

public class getKPC {

    static String[] codes = { ".,", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"}; 

    public static ArrayList<String> getkpc(String str){
        if(str.length() == 0){
            ArrayList<String> bcs = new ArrayList<>();
            bcs.add("");
            return bcs;
        } 

        String subs = str.substring(1);
        char ch = str.charAt(0);
        String code = codes[ch - '0'];

        ArrayList<String> finalAns = new ArrayList<>();

        for(int i = 0; i<code.length(); i++){
            char c = code.charAt(i);
            ArrayList<String> ans = getkpc(subs);
            for(String elm : ans){
                finalAns.add(c + elm);
            }
        }

        return finalAns;

    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter a keypad combination : ");
        String str = scn.nextLine();

        ArrayList<String> ans = getkpc(str);
        System.out.println(ans);

        scn.close();
        
    }
    
}
