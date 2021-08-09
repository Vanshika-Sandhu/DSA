package hashmapsAndHeaps;

import java.util.*;

public class introHashmaps {
    public static void main(String[] args) {
        // has a key and a value
        // useful when table of information is given
        // we can't control in which order the elements would be stored
        // all the inbuilt functions discussed in this java program are of order 0(1);
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 135);
        hm.put("China", 200);
        hm.put("USA", 70);
        hm.put("Pakistan", 45);
        hm.put("UK", 15);

        System.out.println(hm);

        hm.put("USA", 65);    // updates value of USA
        hm.put("Russia", 80); // inserts a key Russia with value 80

        System.out.println(hm);

        System.out.println(hm.get("India")); // prints value stored for key India
        System.out.println(hm.get("Utopia")); // prints null as no key of such name is present

        System.out.println(hm.containsKey("India"));  // prints true
        System.out.println(hm.containsKey("Utopia")); // prints false

        Set<String> keys = hm.keySet();     // keys :  [USA, Pakistan, China, UK, India, Russia]
        System.out.println(keys);           // used when we require a loop

        // eg
        for(String key : hm.keySet()){
            Integer val = hm.get(key);
            System.out.println(key + " -> " + val);
        }

           
    }
}
