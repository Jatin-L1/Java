package Hashmaps;

import java.util.HashSet;

import Arrays.reverse;

public class Setiterate {
    

        public static void main(String[] args) {
        HashSet<Integer>  s = new HashSet<>();
        s.add(20);
        s.add(100);
        s.add(10);
        s.add(200);
        s.add(-8);

        for(int ele : s){
            System.err.println(ele);
        }
    }
    
}
