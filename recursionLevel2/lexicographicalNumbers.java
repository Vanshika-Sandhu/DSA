// 1. You are given a number.
// 2. You have to print all the numbers from 1 to n in lexicographical order
// LEXICOGRAPHICAL ORDER => DICTIONARY ORDER

// depth first search is applied here

// Sample Input
// 14

// Sample Output
// 1
// 10
// 11
// 12
// 13
// 14
// 2
// 3
// 4
// 5
// 6
// 7
// 8
// 9

package recursionLevel2;


import java.util.*;

public class lexicographicalNumbers {
    public static void sol(int i, int n){
        if(i>n)
            return;
        
        System.out.println(i);
        for(int j = 0; j<=9; j++){
            sol(10*i+j, n);
        }
        return;
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        System.out.println("Enter a number");
		int n = scn.nextInt();

        System.out.println("\n" + n +" numbers in lexicographical order are as follows :");
        for(int i = 1; i<=9; i++){
            sol(i, n);
        }
        scn.close();
        
	}
}
