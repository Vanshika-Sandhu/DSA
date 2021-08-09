// 1. You are given a string str.
// 2. You are required to find the character with maximum frequency.

// Sample Input
// zmszeqxllzvheqwrofgcuntypejcxovtaqbnqyqlmrwitc
// Sample Output
// q

package hashmapsAndHeaps;
import java.util.*;


public class highestFreqChar {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        String str = scn.nextLine();
        HashMap<Character, Integer> hm = new HashMap<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(hm.containsKey(ch)){
                int oldFreq = hm.get(ch);
                hm.put(ch, oldFreq+1);
            }else{
                hm.put(ch, 1);
            }
        }

        int maxFreq = 0; 
        char maxFreqChar = ' ';
        for(Character key : hm.keySet()){
            int val = hm.get(key);
            if(val>maxFreq){
                maxFreq = val;
                maxFreqChar = key;
            }
        }

        System.out.println(maxFreqChar);

        scn.close();
    }
    
}
