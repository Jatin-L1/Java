package Arrays;
import java.util.*;

public class threesum {
    List<List<Integer>> fans = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        List<Integer> ans = new ArrayList<>();

        for(int i =0;i<n-2;i++){
            for(int j = i+1;j<n-1;j++){
                int sum = arr[i]  + arr[j];
                for(int k = j+1 ; k<n;k++){
                    if(arr[k] == -1*sum){
                        ans.add(arr[i]);
                        ans.add(arr[j]);
                        ans.add(arr[k]);
                        if(ans!=fans.get(fans.size()-1)) fans.add(ans);
                        ans = new ArrayList<>();
                        break;
                    }
                }
            }
        }
        return fans; 
    }
}
