package DP;

import java.util.ArrayList;
import java.util.List;

public class lenghtoflongestSubstring {
    public static int longest(List<Integer> nums , int target , int sum , int i , int length){
        if(i==nums.size()){
            if(sum==target) return 0;
            else return 0;

        }
        int skip = longest(nums, target, sum , i+1 , length);
        if(sum+nums.get(i)>target) return skip;
        int pick = 1 + longest(nums, target,sum+nums.get(i), i+1 , length+1);
        return Math.max(skip, pick);


    }

    public static  int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        return longest(nums , target ,  0,0 , 0);
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr= new ArrayList<>();
        arr.add(4);
        arr.add(1);
        arr.add(3);
        arr.add(2);
        arr.add(1);
        arr.add(5);
        int target = 7;
        System.out.println(lengthOfLongestSubsequence(arr , target));
    }
}
