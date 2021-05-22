// 1. You are given a 10*10 2-D array(arr) containing only '+' and '-' characters, which represents a 
//     crossword puzzle. 
// 2. You are also given n number of words which need to be filled into the crossword.
// 3. Cells containing '-' are to be filled with the given words.

// Input Format
// 10 * 10 grid of characters containing only '+' and '-' 
// A number n
// str1
// str2
// ...n strings

// Sample Input
// +-++++++++
// +-++++++++
// +-++++++++
// +-----++++
// +-+++-++++
// +-+++-++++
// +++++-++++
// ++------++
// +++++-++++
// +++++-++++
// 4
// LONDON
// DELHI 
// ICELAND 
// ANKARA

// Sample Output
// +L++++++++
// +O++++++++
// +N++++++++
// +DELHI++++
// +O+++C++++
// +N+++E++++
// +++++L++++
// ++ANKARA++
// +++++N++++
// +++++D++++

import java.util.*;

public class crossword {


    // can place functions => check if the given word can be placed from a given cell
    public static boolean canPlaceHorizontally(char[][] arr, String word, int i, int j){
        // eg => +DELHI++++ => here it checks for the + before D
        if(j-1>=0 && arr[i][j-1] != '+'){
            return false;
        }

        // eg => +DELHI++++ => here it checks for the + after D
        if(j+word.length()<arr[0].length && arr[i][j+word.length()]!='+'){
            return false;
        }
        // checks if the word fits or not
        for(int x = 0; x<word.length(); x++ ){
            // returns false if word length because of it's position becomes more than the array length
            if(x+j>=arr[0].length)
                return false; 
            if(arr[i][j+x] == '-' || arr[i][j+x] == word.charAt(x) ){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
    
    public static boolean canPlaceVertically(char[][] arr, String word, int i, int j){
        
        if(i-1>=0 && arr[i-1][j] != '+'){
            return false;
        }
        if(i+word.length()<arr.length && arr[i+word.length()][j]!='+'){
            return false;
        }
        
        for(int x = 0; x<word.length(); x++ ){
            if(x+i>=arr.length)
                return false;
            
            if(arr[i+x][j] == '-' || arr[i+x][j] == word.charAt(x) ){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
    
    // place functions => return a boolean array marking true only those places where the letters were placed
    // eg for delhi , iceland and london in the above input, if we want to place delhi
    // the code will not overwrite the d of london and i of iceland and only place e, l, h, and mark true in boolean array for the same
    public static boolean[] placeHorizontal(char[][]arr, String word, int i, int j){
        boolean[] check = new boolean[word.length()];
        
        for(int x = 0; x<word.length(); x++ ){
            if(arr[i][j+x]=='-'){
                check[x] = true;
                arr[i][j+x] = word.charAt(x);
            }
        }
        
        return check;
    }
    
    public static boolean[] placeVertical(char[][]arr, String word, int i, int j){
        boolean[] check = new boolean[word.length()];
        
        for(int x = 0; x<word.length(); x++ ){
            if(arr[i+x][j]=='-'){
                check[x] = true;
                arr[i+x][j] = word.charAt(x);
            }
        }
        
        return check;
    }
    
    // remove functions => remove the leters only where we placed them earlier
    // eg for delhi, iceland and london in the above input, if we take the case of removing delhi
    // the code will not remove the d and i letters from london and iceland respectively
    public static void removeHorizontal(char[][]arr, boolean[] check, int i, int j){
        for(int x = 0; x<check.length; x++){
            if(check[x]== true){
                arr[i][j+x] = '-';
            }
        }
    }
    
    public static void removeVertical(char[][]arr, boolean[] check, int i, int j){
        for(int x = 0; x<check.length; x++){
            if(check[x]== true){
                arr[i+x][j] = '-';
            }
        }
    }
    
	public static void solution(char[][] arr, String[] words, int vidx){
		// base case
        if(vidx == words.length){
            print(arr);
            return;
        }
        
        String word = words[vidx];
        
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j]==word.charAt(0) || arr[i][j]=='-'){
                    // we did not use else for horizontal and vertical calls because every word will have two options
                    // horizontal   
                    if(canPlaceHorizontally(arr, word, i, j)==true){
                        boolean[] check = placeHorizontal(arr, word, i, j);   // returns a boolean array with true values only at place where
                        solution(arr, words, vidx+1);                         // we placed the letters of the word helping to avoid overlap                    
                        removeHorizontal(arr, check, i, j);                   // and then passing the same array as a parameter while removing the alphabets
                    }
                    // vertical
                    if(canPlaceVertically(arr, word, i, j)==true){
                        boolean[] check = placeVertical(arr, word, i, j);
                        solution(arr, words, vidx+1);
                        removeVertical(arr, check, i, j);
                    }  
                }
            }
        }
        
	}

	public static void print(char[][] arr){
		for(int i = 0 ; i < arr.length; i++){
			for(int j = 0 ; j < arr.length; j++){
				System.out.print(arr[i][j]);
			}
                  System.out.println();
		}
		
	}
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char[][] arr = new char[10][10];
		for(int i = 0 ; i < arr.length; i++){
			String str = scn.next();
			arr[i] = str.toCharArray();
		}
		int n = scn.nextInt();
		String[] words = new String[n];
		for(int i = 0 ; i  < words.length; i++){
			words[i] = scn.next();
		}
		
		solution(arr, words, 0);

        scn.close();
	}
}