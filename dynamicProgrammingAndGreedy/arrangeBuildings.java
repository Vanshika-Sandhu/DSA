// 1. You are given a number n, which represents the length of a road. The road has n plots on it's each side.
// 2. The road is to be so planned that there should not be consecutive buildings on either side of the road.
// 3. You are required to find and print the number of ways in which the buildings can be built on both side
// of roads.

// Sample Input
// 6
// Sample Output
// 441

// same approach as the previous one

package dynamicProgrammingAndGreedy;
import java.util.*;

public class arrangeBuildings {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
    
        int n = scn.nextInt();
        
        int ospace = 1;
        int obuild = 1;
        
        for(int i=2; i<n+1; i++){
            int nbuild = ospace;
            int nspace = ospace + obuild;
            
            ospace = nspace;
            obuild = nbuild;
        }
        long total = ospace+obuild;
        // we take square as there will be x ways for both the sides separately so the final total is x*x
        total*=total;
        
        
        System.out.println(total);

        scn.close();
    }
    
}
