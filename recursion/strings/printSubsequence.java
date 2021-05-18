// INPUT
// yvTA

// OUTPUT
// yvTA => yvTA
// yvT  => yvT_
// yvA  => yv_A
// yv   => yv__
// yTA  => y_TA
// yT   => y_T_
// yA   => y__A
// y    => y___
// vTA  => _vTA
// vT   => _vT_
// vA   => _v_A
// v    => _v__
// TA   => __TA
// T    => __T_
// A    => ___A

package recursion.strings;


import java.util.*;

public class printSubsequence {

    public static ArrayList<String> getSubSeq(String str){
        if(str.length() == 0){
            ArrayList<String> bcs =  new ArrayList<>();
            bcs.add("");   //to have a size of array list so that the loop1 and loop2 can be executed
            return bcs;
        }

        char ch = str.charAt(0);
        String substr = str.substring(1);

        ArrayList<String> subs = getSubSeq(substr);
        
        ArrayList<String> finalSubs = new ArrayList<>();
        for( String s : subs){ //loop1
            finalSubs.add(ch + s);
        }
        for( String s : subs){  //loop2
            finalSubs.add(s);
        }

        return finalSubs;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter a string");
        String str = scn.nextLine();
        ArrayList<String> Subseq = getSubSeq(str);
        System.out.println(Subseq);

        scn.close();

    }
    
}
