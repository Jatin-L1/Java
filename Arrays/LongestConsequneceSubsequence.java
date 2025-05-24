import java.util.Arrays;
import java.util.HashMap;

public class LongestConsequneceSubsequence {
    public int longestConsecutive(int[] arr) {
        int n = arr.length;
        int seq =0;
        int count = 0;
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i =0;i<n;i++) map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        Arrays.sort(arr);

        for(int i =0;i<n;i++){
            if(map.containsKey(arr[i])){
                count = 1;
                int j = arr[i];
                while(map.containsKey(j+1)){
                    count++;
                    j++;
                    map.remove(j);
                }
                seq = Math.max(seq, count);
                map.remove(arr[i]);
                while(map.containsKey(arr[i]-1)){
                    count++;
                    arr[i]--;
                    map.remove(arr[i]);
                }
            }
        }
        
        return seq;
        
    }
}
