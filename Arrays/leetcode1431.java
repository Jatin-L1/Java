import java.util.ArrayList;

public class leetcode1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> ans = new ArrayList<>();
        int n = candies.length;
        int max =Integer.MAX_VALUE;
        for(int ele : candies){
            max = Math.max(max, ele);
        }
        for(int ele : candies){
            if(ele + extraCandies > max) ans.add(true);
            else ans.add(false);
        }
        return ans;
    }
}
