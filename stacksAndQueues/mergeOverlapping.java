// 1. You are given a number n, representing the number of time-intervals.
// 2. In the next n lines, you are given a pair of space separated numbers.
// 3. The pair of numbers represent the start time and end time of a meeting (first number is start time and
// second number is end time)
// 4. You are required to merge the meetings and print the merged meetings output in increasing order of start time.

// E.g. Let us say there are 6 meetings
// 1 8
// 5 12
// 14 19
// 22 28
// 25 27
// 27 30

// Then the output of merged meetings will belongs
// 1 12
// 14 19
// 22 30

// Note -> The given input maynot be sorted by start-time.

// Sample Input
// 6
// 22 28
// 1 8
// 25 27
// 14 19
// 27 30
// 5 12
// Sample Output
// 1 12
// 14 19
// 22 30


package stacksAndQueues;
import java.util.*;

public class mergeOverlapping {
    // implements Comparable <Pair> is an interface that helps java know what to compare while using function sort
    public static class Pair implements Comparable <Pair>{
        int st;
        int et;
        
        Pair(int st, int et){
            this.st = st;
            this.et = et;
        }
        
        // two objects are being compared => this and other(passed in parameter)
        // this > other => return +ve value
        // this == other => return 0
        // this < other => return -ve value
        public int compareTo(Pair other){
            if(this.st != other.st){
                return this.st - other.st;
            }else{
                return this.et - other.et;
            }
        }
    }

    public static void mergeOverlappingIntervals(int[][] arr) {
        // merge overlapping intervals and print in increasing order of start time
        Pair[] pairs = new Pair[arr.length];
        
        for(int i=0; i<arr.length; i++){
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }
        
        Arrays.sort(pairs);
        
        Stack<Pair> stk = new Stack<>();
        
        for(int i=0; i<pairs.length; i++){
            if(i==0){
                stk.push(pairs[i]);
            }else{
                
                Pair top = stk.peek();
                
                if(top.et < pairs[i].st){
                    stk.push(pairs[i]);
                }else{
                    top.et = Math.max(pairs[i].et, top.et);
                }
            }
        }
        
        Stack<Pair> revstk = new Stack<>();
        while(stk.size()>0){
            revstk.push(stk.pop());
        }
        
        while(revstk.size()>0){
            Pair p = revstk.pop();
            System.out.println(p.st + " " + p.et);
        }
         
        
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            // String line = scn.nextLine();
            // arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            // arr[j][1] = Integer.parseInt(line.split(" ")[1]);
            arr[j][0] = scn.nextInt();
            arr[j][1] = scn.nextInt();
        }

        mergeOverlappingIntervals(arr);
        scn.close();
    }
    
}
