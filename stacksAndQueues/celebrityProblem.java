// 1. You are given a number n, representing the number of people in a party.
// 2. You are given n strings of n length containing 0's and 1's
// 3. If there is a '1' in ith row, jth spot, then person i knows about person j.
// 4. A celebrity is defined as somebody who knows no other person than himself but everybody else knows him.
// 5. If there is a celebrity print it's index otherwise print "none".

// Note -> There can be only either one or zero celebrity.

// Sample Input
// 4
// 0000
// 1011
// 1101
// 1110
// Sample Output
// 0


package stacksAndQueues;
import java.util.*;

public class celebrityProblem {

    public static void findCelebrity(int[][] arr) {
        // if a celebrity is there print it's index (not position), if there is not then
        // print "none"
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<arr.length; i++){
            st.push(i);
        }
        while(st.size()>=2){
            int i = st.pop();
            int j = st.pop();     
            if(arr[i][j] == 1){
                // if i knows j => i is not a celebrity
                st.push(j);
            }else{
                // else if i doesn't know j => j is not a celebrity
                st.push(i);
            }
        }
        int pot = st.pop();   // potential celeb
        boolean celeb = true;
        for(int i=0; i<arr.length; i++){
            if(i!=pot && arr[i][pot]!=1 && arr[pot][i]!=0){
                celeb = false;
                break;
            }
        }
        if(celeb){
            System.out.println(pot );
        }else{
            System.out.println("none");
        }
    }


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];

        for (int j = 0; j < n; j++) {
            String line = scn.nextLine();
            for (int k = 0; k < n; k++) {
                arr[j][k] = line.charAt(k) - '0';
            }
        }
        findCelebrity(arr);

        scn.close();
    }
    
}
