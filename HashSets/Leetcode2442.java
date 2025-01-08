package HashSets;

import java.util.HashSet;

public class Leetcode2442 {
    public int reverse(int x){
        int ans =0;
        while(x!=0){
            int rem= x%10;
            x/=10;
            ans = ans*10+rem;
        }
        return ans;
    }
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i =0;i<nums.length;i++){
            set.add(nums[i]);
            set.add(reverse(nums[i]));
        }
        return set.size();
    }
    public static void main(String[] args) {
        
    }   
}
