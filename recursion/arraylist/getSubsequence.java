// input
// abc

// output
// [, c, b, bc, a, ac, ab, abc]

package recursion.arraylist;
import java.util.*;

public class getSubsequence {

    public static ArrayList<String> getSS(String str) {
        if(str.length() == 0){
            ArrayList<String> bcs = new ArrayList<>();
            bcs.add("");
            return bcs;
        }

        String subs = str.substring(1);
        char ch = str.charAt(0);

        ArrayList<String> ans1 = getSS(subs);
        ArrayList<String> finalAns = new ArrayList<>();

        for(String elm : ans1){
            finalAns.add(elm);
        }
        for(String elm : ans1){
            finalAns.add(ch + elm);
        }
        
        // for(int i = 0; i<ans1.size() ; i++){
        //     finalAns.add(ans1.get(i));
        // }
        // for(int i = 0; i<ans1.size(); i++){
        //     finalAns.add(ch + ans1.get(i));
        // }

        return finalAns;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter a string : ");
        String str = scn.nextLine();
        ArrayList<String> ans = getSS(str);
        System.out.println(ans);

        scn.close();
    }
    
}
