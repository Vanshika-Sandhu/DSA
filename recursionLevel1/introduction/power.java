package recursionLevel1.introduction;
import java.util.*;

public class power {

    // time complexity = O(n)
    public static double linearPower(int x, int n) {
        if(n == 0)
            return 1;
        
        double ans = x*linearPower(x, n-1);
        if(n<0){
            return 1/ans;
        }
        return ans;
    }

    // time complexity = O(logn)
    public static double logarithmicPower(int x, int n) {
        if(n == 0)
            return 1;

        double ans = logarithmicPower(x, n/2)*logarithmicPower(x, n/2);
        if(n%2!=0){
            ans = ans*x;
        } 
        if(n<0){
            return 1/ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter a number : ");
        int x = scn.nextInt();
        System.out.print("Enter the power : ");
        int n = scn.nextInt();

        double linearAns = linearPower(x, n);
        double logarithmicAns = logarithmicPower(x, n);

        System.out.println("For linear solution\n" + x + " raise to the power " + n +" = " + linearAns);
        System.out.println("For logarithmic solution\n" + x + " raise to the power " + n +" = " + logarithmicAns);
        
        scn.close();
    }
}
