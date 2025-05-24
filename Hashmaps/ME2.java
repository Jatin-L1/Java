package Hashmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ME2 {
    public List<Integer> majorityElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();    
        for(int i = 0;i<n;i++) map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        for(int i = 0;i<n;i++) if(map.get(arr[i]) > n/3 && !ans.contains(arr[i])) ans.add(arr[i]);
        return ans;
    }
}
