// import java.io.*;
package recursion.introduction;
import java.util.*;
// import java.util.Scanner;

public class print {

    public static void printIncreasing(int n) {
        if(n == 0){
            return;
        }

        printIncreasing(n-1);
        System.out.print(n + " "); 
    }

    public static void printDecreasing(int n) {
        if(n == 0){
            return;
        }

        System.out.print(n + " "); 
        printDecreasing(n-1);
    }

    public static void printIncDec(int n) {
        if(n == 0){
            return;
        }
        System.out.print(n + " "); 
        printIncDec(n-1);
        System.out.print(n + " "); 
    }
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.print("Enter number : ");
        int n = scn.nextInt();

        System.out.println("Printing first " + n + " numbers in increaring order");
        printIncreasing(n);
        System.out.println();
        System.out.println("Printing first " + n + " numbers in decreasing order");
        printDecreasing(n);
        System.out.println();
        System.out.println("Printing first " + n + " numbers in increaring order and then decreasing order");
        printIncDec(n);

        scn.close();
        // if you do not close the Scanner then Java will not garbage collect the Scanner
        // object and you will have a memory leak in your program
        // void close(): closes the Scanner and allows Java to reclaim the Scanner's memory.
        // You cannot re-use a Scanner so you should get rid of it as soon as you exhaust its input.
    }
}
