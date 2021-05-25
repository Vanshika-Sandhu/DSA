// 1. You are given a list of words, a list of alphabets(might be repeating) and score of every alphabet 
//      from a to z.
// 2. You have to find the maximum score of any valid set of words formed by using the given 
//      alphabets.
// 3. A word can not be used more than one time.
// 4. Each alphabet can be used only once. 
// 5. It is not necessary to use all the given alphabets.

// Input Format
// A number N representing number of words
// N space separated strings
// A number M representing number of alphabets(might be repeating)
// M space separated characters
// 26 numbers representing score of unique alphabets from a to z.

// Sample Input
// 4
// dog cat dad good
// 9
// a b c d d d g o o
// 1 0 9 5 0 0 3 0 0 0 0 0 0 0 2 0 0 0 0 0 0 0 0 0 0 0

// Sample Output
// 23

package recursionLevel2;


import java.util.*;

public class maxScore {

    public static int solution(String[] words, int[] farr, int[] score, int idx) {
		// base case
		if(idx == words.length){
    		return 0;
		}
		
		int sword = 0;              // freq of curr word
		String word = words[idx];   // current word
		
        // the word at index idx doesn't gets included
        int sno = sword + solution(words, farr, score, idx+1);
        
        // the word at index idx want's to get included
        // we have to check if it can be included or not
        boolean flag = true;         // to keep a check if the word can be included
        for(int i = 0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(farr[ch-'a'] == 0)    // if freq is already zero
            {
                flag = false;		
            }
            
            farr[ch - 'a']--;
            sword += score[ch-'a'];
        }
        
		// if all the conditions are satisfied
        int syes = 0;
        if(flag){
            syes = sword + solution(words, farr, score, idx+1);
        }

        // backtracking
        for(int  i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            farr[ch-'a']++;
        }
        
        return Math.max(sno, syes);
		
	}
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

		// enter words
		System.out.println("Enter no. of words in the string array");
        int nofWords = scn.nextInt();
		String[] words = new String[nofWords];
		System.out.println("Enter the words of string array");
		for(int i = 0 ; i < words.length; i++) {
			words[i] = scn.next();
		}

		// enter characters
		System.out.println("Enter no. of characters allowed");
		int nofLetters = scn.nextInt();
		char[] letters = new char[nofLetters];
		System.out.println("Enter the characters");
		for (int i = 0; i < letters.length; i++) {
			letters[i] = scn.next().charAt(0);
		}

		// get scores
		int[] score = new int[26];
		System.out.println("Enter the score of all alphabets");
		for (int i = 0; i < score.length; i++) {
			score[i] = scn.nextInt();
		}

		// if no word is entered
		if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
				|| score.length == 0) {
			System.out.println(0);
			scn.close();
			return;
		}

		// convert letter array into freq of char array
		int[] farr = new int[score.length];
		for (char ch : letters) {
			farr[ch - 'a']++;
		}

		System.out.println(solution(words, farr, score, 0));

        scn.close();
    }
    
}
