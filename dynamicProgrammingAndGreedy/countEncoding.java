// 1. You are given a string str of digits. (will never start with a 0)
// 2. You are required to encode the str as per following rules
//     1 -> a
//     2 -> b
//     3 -> c
//     ..
//     25 -> y
//     26 -> z
// 3. You are required to calculate and print the count of encodings for the string str.

//      For 123 -> there are 3 encodings. abc, aw, lc
//      For 993 -> there is 1 encoding. iic 
//      For 013 -> This is an invalid input. A string starting with 0 will not be passed.
//      For 103 -> there is 1 encoding. jc
//      For 303 -> there are 0 encodings. But such a string maybe passed. In this case 
//      print 0.


// Sample Input
// 123 
// Sample Output
// 3

// tabulation

package dynamicProgrammingAndGreedy;
import java.util.*;

public class countEncoding {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        String str = scn.next();
        
        int[] dp = new int[str.length()];
        dp[0] = 1;
        
        for(int i=1; i<dp.length; i++){
            // for number 123005
            // case 1 => 00
            if(str.charAt(i-1)=='0' && str.charAt(i)=='0'){
                dp[i] = 0;
            }
            // case 2 => 01 to 09 => no combination thus only the previous count shouls be restored
            else if(str.charAt(i-1)=='0' && str.charAt(i)!='0'){
                dp[i] = dp[i-1];
            }
            // case 3 => for no. 10 to 90
            // if case works only if no. is 20 or 10
            else if(str.charAt(i-1)!='0' && str.charAt(i)=='0'){
                if(str.charAt(i-1)=='1'||str.charAt(i-1)=='2'){
                    if(i-2>0){
                        dp[i] = dp[i-2];  
                    }else{
                        dp[i] = 1;
                    }
                }else{
                    dp[i] = 0;
                } 
            }
            // case 4 => for all other numbers
            // works only for no. <=26
            else{
                if(Integer.parseInt(str.substring(i-1, i+1))<=26){
                    if(i-2>0){
                        dp[i] = dp[i-1] + dp[i-2];  
                    }else{
                        dp[i] = dp[i-1] + 1;
                    }
                }else{
                    dp[i] = dp[i-1];
                }
                
            }
        }
        
        System.out.println(dp[dp.length-1]);
        
        scn.close();
    }
    
}
