package recursionLevel1.introduction;
import java.util.*;

public class factorial {

    public static int fact(int n){
        if(n == 0)
            return 1;
        return n*fact(n-1);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter a number : ");
        int n = scn.nextInt();
        int f = fact(n);
        System.out.println("Factorial of " + n + " is : " + f );
        scn.close();
    }
}
