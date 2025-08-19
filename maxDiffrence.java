import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class maxDiffrence {
    public int maxDifference(String s) {

        int n = s.length();
        HashMap<Character  ,Integer> map = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for(char ch : s.toCharArray()) map.put(ch , map.getOrDefault(ch, 0)+1);
        int ans = 0;
        for(char ch : map.keySet()){
            arr.add(map.get(ch));
        }
        Collections.sort(arr);

        return arr.get(arr.size()-1) - arr.get(0);
    }
    
}
