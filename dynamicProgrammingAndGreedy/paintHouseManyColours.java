// 1. You are given a number n and a number k separated by a space, representing the number of houses and number of
// colors.
// 2. In the next n rows, you are given k space separated numbers representing the cost of painting nth house with
// one of the k colors.
// 3. You are required to calculate and print the minimum cost of painting all houses without painting any consecutive
// house with same color.

// Sample Input
// 4 3
// 1 5 7
// 5 8 4
// 3 2 9
// 1 2 4
// Sample Output
// 8


package dynamicProgrammingAndGreedy;
import java.util.*;

public class paintHouseManyColours {
    public static int minimum(int[][] arr, int r, int currCell){
        int min = Integer.MAX_VALUE;
        for(int j=0; j<arr[0].length; j++){
            if(j==currCell){
                continue;
            }else{
                if(min>arr[r][j])
                    min = arr[r][j];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int c = scn.nextInt();
        
        int[][] arr = new int[n][c];
        for(int i=0; i<n; i++){
            for(int j=0; j<c; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        
        // tabulation
        int[][] dp = new int[n][c];
        for(int j=0; j<c; j++){
            dp[0][j] = arr[0][j];
        }
        for(int i=1; i<n; i++){
            for(int j=0; j<c; j++){
                int min = minimum(dp, i-1, j );
                dp[i][j] = arr[i][j] + min;
            }
        }
        int ans = minimum(dp, n-1, -1);
        System.out.println(ans);


        scn.close();
    }
    
}
