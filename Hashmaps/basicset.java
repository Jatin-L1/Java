package Hashmaps;

import java.util.HashSet;

public class basicset {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>(); // this is a interface

        //Insert : TC = O(1)
        set.add(20);
        set.add(100);
        set.add(10);
        set.add(200);
        set.add(-8);

        //search -true/false: TC = O(1)
        System.out.println(set.contains(101));

        // size set ka 
        System.out.println("Size is "+set.size());

        // set main se remove

        set.remove(100);

        System.out.println(set);

        Object[] arr = set.toArray();


    }
    
}
