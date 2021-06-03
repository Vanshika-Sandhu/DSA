// 1. You are given a number n, representing the number of rows.
// 2. You are given a number m, representing the number of columns.
// 3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
// 4. You are standing in front of left wall and are supposed to dig to the right wall. You can start from 
//      any row in the left wall.
// 5. You are allowed to move 1 cell right-up (d1), 1 cell right (d2) or 1 cell right-down(d3).
// goldmine
// 6. Each cell has a value that is the amount of gold available in the cell.
// 7. You are required to identify the maximum amount of gold that can be dug out from the mine.


// Sample Input
// 6
// 6
// 0 1 4 2 8 2
// 4 3 6 5 0 4
// 1 2 4 1 4 6
// 2 0 7 3 2 2
// 3 1 5 9 2 4
// 2 7 0 8 5 1
// Sample Output
// 33

package dynamicProgrammingAndGreedy;
import java.util.*;

public class goldmine {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = scn.nextInt();
            }
        }

        int[][] dp = new int[n][m];

        for(int j = m-1; j>=0; j--){
            for(int i = n-1; i>=0; i--){
                if(j==m-1){
                    dp[i][j] = arr[i][j];
                }else if(i==0){
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j+1], dp[i+1][j+1]);
                }else if(i==n-1){
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j+1], dp[i-1][j+1]);  
                }else{
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j+1], Math.max(dp[i+1][j+1], dp[i-1][j+1]));
                }
            }
        }
        int max = dp[0][0];
        System.out.println(max);
        for(int i = 1; i<n; i++){
            if(dp[i][0]>max){
                max = dp[i][0];
            }
        }

        for(int i = 0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println(max);
        
        scn.close();
    }
    
}
