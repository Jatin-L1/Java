package Hashmaps;

import java.util.HashMap;

public class leetcode242 {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> smap = new HashMap<>();

        for(int i =0;i<s.length();i++){
            char key = s.charAt(i);
            if(smap.containsKey(key)){
                int freq = smap.get(key);
                smap.put(key, freq+1);
            }
            else smap.put(key , 1);
        }

        HashMap<Character,Integer> tmap = new HashMap<>();
        for(int i =0;i<t.length();i++){
            char key = t.charAt(i);
            if(tmap.containsKey(key)){
                int freq = smap.get(key);
                tmap.put(key , freq+1);
            }
            else tmap.put(key,1);
        }

        for(Character key : smap.keySet()){
            int val1 = smap.get(key);
            if(!tmap.containsKey(key)) return false;
            int val2 = tmap.get(key);
            if(val1!=val2) return false;
        }
        return true;
    }
}
