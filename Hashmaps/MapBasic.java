package Hashmaps;

import java.util.HashMap;

public class MapBasic {
    public static void main(String[] args) {
        HashMap<String , Integer> map = new HashMap<>();
        map.put("Jatin", 2026);
        map.put("Radhika", 2502);
        map.put("Ishaan", 2017);
        map.put("Sambhav", 40);

        // System.out.println(map);
        // System.out.println(map.containsKey("Jatin"));
        // System.out.println(map.containsValue(40));
        System.out.println(map.entrySet());

    }
}
