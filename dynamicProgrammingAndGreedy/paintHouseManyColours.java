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
    // public static int minimum(int[][] arr, int r, int currCell){
    //     int min = Integer.MAX_VALUE;
    //     for(int j=0; j<arr[0].length; j++){
    //         if(j==currCell){
    //             continue;
    //         }else{
    //             if(min>arr[r][j])
    //                 min = arr[r][j];
    //         }
    //     }
    //     return min;
    // }

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
        
        int[][] dp = new int[n][c];

        // tabulation

        // APPROACH 1 => complexity => O(n^3)
        // for(int j=0; j<c; j++){
        //     dp[0][j] = arr[0][j];
        // }
        // for(int i=1; i<n; i++){
        //     for(int j=0; j<c; j++){
        //         int min = minimum(dp, i-1, j );
        //         dp[i][j] = arr[i][j] + min;
        //     }
        // }
        // int ans = minimum(dp, n-1, -1);
        // System.out.println(ans);



        // APPROACH 2 => complexity => O(n^2) => reduces a loop to find min everytime
        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE;

        for(int j=0; j<c; j++){
            dp[0][j] = arr[0][j];

            // eg -> if dp[0][j] = 3, least = 5, sleast = 7
            // => least = 3, sleast = 5
            if(dp[0][j]<=least){
                sleast = least;
                least = dp[0][j];
            }
            // eg -> if dp[0][j] = 6, least = 5, sleast = 7
            // => least = 5, sleast = 6
            else if(dp[0][j]<=sleast){
                sleast = dp[0][j];
            }
        }

        for(int i=1; i<n; i++){
            int nleast = Integer.MAX_VALUE;
            int nsleast = Integer.MAX_VALUE;

            for(int j=0; j<c; j++){
                if(dp[i-1][j]==least){
                    dp[i][j] = arr[i][j] + sleast;
                }else{
                    dp[i][j] = arr[i][j] + least;
                }
                if(dp[i][j]<=nleast){
                    nsleast = nleast;
                    nleast = dp[i][j];
                }else if(dp[i][j]<=nsleast){
                    nsleast = dp[i][j];
                }
            }
            sleast = nsleast;
            least = nleast;
        }

        System.out.println(least);


        scn.close();
    }
    
}
