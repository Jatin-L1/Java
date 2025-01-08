package Hashmaps;

import java.util.HashMap;

public class iterateMap {
    public static void main(String[] args) {
        HashMap<String , Integer> map = new HashMap<>();
        map.put("Jatin", 2026);
        map.put("Radhika", 2502);
        map.put("Naman", 2502);
        map.put("Ishaan", 2017);
        map.put("Sambhav", 40);
        for(String key : map.keySet()){
            int val = map.get(key);
            System.out.println(key+" "+val);
        }
        System.out.println();
        //valye se hum key ko print nhi kar sakte but reverse is possible
        for(int val : map.values()){
            System.out.println(val);
        }
        System.out.println();

        for(Object pair : map.entrySet()){
            System.out.println(pair);
        }

    }
    
}
