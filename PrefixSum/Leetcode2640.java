package PrefixSum;

public class Leetcode2640 {
    public long[] findPrefixScore(int[] arr) {
        int n = arr.length;
        long[] ans = new long[arr.length];
        int max = arr[0];
        ans[0] = (long)(arr[0] + max);
        for(int i =1;i<n;i++){
            if(arr[i]>max) max = arr[i];
            ans[i] = (long)(arr[i] + max);
        }
        for(int i = 1 ;i<n;i++){
            ans[i]  = ans[i] + ans[i-1];
        }
        return ans;
        
    }

public static void main(String[] args) {
}
}