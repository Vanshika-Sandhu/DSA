// import java.util.*;

public class indices {

    public static int max(int[] arr, int idx, int max){
        if(idx == arr.length){
            return max;
        }
        if(arr[idx]>max){
            max = arr[idx];
        }

        int ans = max(arr, idx+1, max);
        return ans;

    }

    public static int min(int[] arr, int idx, int min){
        if(idx == arr.length){
            return min;
        }
        if(arr[idx]<min){
            min = arr[idx];
        }

        int ans = min(arr, idx+1, min);
        return ans;
    }

    public static int firstIndex(int[] arr, int idx, int x){
        if(idx == arr.length)
            return -1;
        
        if(arr[idx] == x)
            return idx;
        else{
            int ans = firstIndex(arr, idx+1, x);
            return ans;
        }
        
        
    }

    public static int lastIndex(int[] arr, int idx, int x){
        if(idx == arr.length)
            return -1;
        
        int ans = lastIndex(arr, idx+1, x);
        if(ans == -1){
            if(arr[idx] == x)
                ans = idx;
        }
        return ans;
    }

    public static int[] allIndices(int[] arr, int idx, int x, int fsf){
        if(idx == arr.length){
            return new int[fsf];
        }

        if(arr[idx] == x){
            int[] ans = allIndices(arr, idx+1, x, fsf+1);
            ans[fsf] = idx;
            return ans;
        }else{
            int[] ans = allIndices(arr, idx+1, x, fsf);
            return ans;
        }
    }
    public static void main(String[] args) {
       
        int[] arr = {1, 2, 3, 5, 7, 7, 1, 5, 13, 9, 4, 7, 1, 2, 5};

        System.out.println("let me assume an array arr = {1, 2, 3, 5, 7, 7, 1, 5, 13, 9, 4, 7, 1, 2, 5} ");

        int maximum = max(arr, 0, Integer.MIN_VALUE);
        int minimum = min(arr, 0, Integer.MAX_VALUE);
        int fIndex = firstIndex(arr, 0, 7);
        int lIndex = lastIndex(arr, 0, 7);
        int[] aIndices = allIndices(arr, 0, 7, 0);

        System.out.println("Maximum of the array is : " + maximum);
        System.out.println("Minimum of the array is : " + minimum);
        System.out.println("First index of 7 in the array is : " + fIndex);
        System.out.println("Last index of 7 in the array is : " + lIndex);
        System.out.println("All indices of 7 in the array are : ");
        for(int elm : aIndices){
            System.out.print(elm + " ");
        }

    }
}
