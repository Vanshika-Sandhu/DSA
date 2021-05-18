package recursionLevel1.arrays;

import java.util.*;

public class display {
    public static void displayArr(int[] arr, int idx) {
        if(idx == arr.length){
            return;
        }
        System.out.print(arr[idx] + " ");
        displayArr(arr, idx+1);
        return;
    }

    public static void reverseDisplayArr(int[] arr, int idx){
        if(idx == arr.length){
            return;
        }
        reverseDisplayArr(arr, idx+1);
        System.out.print(arr[idx] + " ");
        return;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter length of the array : ");
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            System.out.print("Enter value for array at position " + i + " : ");
            arr[i] = scn.nextInt();
        }

        System.out.println("Entered array");
        displayArr(arr, 0);
        System.out.println();
        System.out.println("Entered array in reverse order");
        reverseDisplayArr(arr, 0);

        scn.close();
    }
}
