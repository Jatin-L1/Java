package Hashmaps;

import java.util.HashMap;
import java.util.HashSet;

public class Leetcode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashSet<Integer> numbers = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            if (map1.containsKey(nums1[i])) {
                int freq = map1.get(nums1[i]);
                map1.put(nums1[i], freq + 1);
            } 
            else map1.put(nums1[i], 1);
        }

        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map2.containsKey(nums2[i])) {
                int freq = map2.get(nums2[i]);
                map2.put(nums2[i], freq + 1);
            } 
            else map2.put(nums2[i], 1);
        }

        for (Integer key : map1.keySet()) {
            if (map2.containsKey(key)) {
                numbers.add(key);
            }
        }
        int[] result = new int[numbers.size()];
        int i =0;
        for(int ele : numbers){
            result[i] = ele;
            i++;
        }
        return result;
    }
}
