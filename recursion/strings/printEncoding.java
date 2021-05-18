// 1. You are given a string str of digits. (will never start with a 0)
// 2. You are required to encode the str as per following rules
//     1 -> a
//     2 -> b
//     3 -> c
//     ..
//     25 -> y
//     26 -> z
// Use the input-output below to get more understanding on what is required
// 123 -> abc, aw, lc
// 993 -> iic
// 013 -> Invalid input. A string starting with 0 will not be passed.
// 103 -> jc
// 303 -> No output possible. But such a string maybe passed. In this case print nothing.

// input
// 655196

// output
// feeaif
// feesf

package recursion.strings;

import java.util.*;

public class printEncoding {

    public static void printAns(String num, String asf){
        // base case
        if(num.length() == 0){
            System.out.println(asf);
            return;
        }else if(num.length() == 1){
            char chb = num.charAt(0);
            int nb = chb - '0';
            if(nb == 0){
                return;
            }else{
                char c = (char)('a' + nb - 1);
                System.out.println(asf + c);
                return;
            }
        }

        // calculation for single digit
        char ch1 = num.charAt(0);
        int n1 = ch1 - '0';
        if(n1 > 0){
            char c = (char)('a' + n1 - 1);  // first the code converst if into int and then completely into char
            String subs = num.substring(1);
            printAns(subs, asf + c);
        }

        // calculation for two digit
        char ch2 = num.charAt(1);
        int n2 = ch2 - '0';
        int n = (n1*10) + n2;
        if(n>0 && n<27){
            char c = (char)('a' + n - 1); 
            String subs = num.substring(2);
            printAns(subs, asf + c);
        }

        return;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter the numbers : ");
        String num = scn.nextLine();
        printAns(num, "");

        scn.close();
    }
}
