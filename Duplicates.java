import java.util.ArrayList;
import java.util.HashSet;
public class Duplicates {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 3, 3};
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> duplicates = new ArrayList<>();
        HashSet<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (!seen.contains(num)) {
                ans.add(num); 
                seen.add(num);
            } else {
                duplicates.add(num); 
            }
        }
        ans.addAll(duplicates); 
        for(int i =0;i<n;i++){
            arr[i] = ans.get(i);
        }
        // System.out.println(ans); 
        for(int i =0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
