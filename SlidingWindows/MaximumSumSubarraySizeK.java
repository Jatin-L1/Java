package SlidingWindows;

public class MaximumSumSubarraySizeK {
    public static void main(String[] args) {
        int[] arr = {10,20,1,3,-40,80,10};
        int k = 3;
        int n = arr.length;
        int maxSum = 0;

        // brute force
        // for(int i =0;i<n-k+1;i++){
        //     int sum = 0;
        //     for(int j =i;j<=i+k-1;j++){
        //         sum +=arr[j];
        //     }
        //     maxSum = Math.max(maxSum, sum);
        // }
        // System.out.println(maxSum);


        // slinding windows code
        int i =0 , j=k-1,sum=0;
        for(int a = i;a<=j;a++){
            sum+=arr[a];
        }
        i++ ; j++;
        while(j<n){ // n-k times 
            sum = sum - arr[i-1]+arr[j];
            maxSum = Math.max(maxSum, sum);
            i++;j++;
        }
        System.out.println(maxSum);
    }
    public int minSubArrayLen(int target, int[] arr) {
        int n = arr.length, minLen = Integer.MAX_VALUE;
        int i = 0, j =0,sum =0;
        while (j<n && sum<target) {
          sum +=arr[j++];  
        }
        j--;
        //sliding windows
        while (j<n) {
           int len = j-i+1;
           minLen = Math.min(minLen, len);
           sum -=arr[i];
           i++;
           while (j<n && sum<target) {
             sum +=arr[j++];
           } 
           j--;
        }
        if(minLen==Integer.MAX_VALUE) return 0;
        return minLen;
    }
    public int longestSubarray(int[] arr) {
        int n = arr.length , i = 0,j=0;
        int zeroes = 0, maxLen = 0;
        while (i<n && arr[i++]==0);
        j = i;
        while(j<n){
            if(arr[j++]==1);
            else{
                if(zeroes==0){
                    j++;
                    zeroes++;
                }
                else{ //zeroes==1
                    int len = j-i-1;
                    maxLen = Math.max(maxLen, len);
                    j++;
                    while (i<n && arr[i]==1) i++;
                    i++;
                }
            }
        }
        if(zeroes==1){
            int len = j-i-1;
             maxLen = Math.max(maxLen, len);
        }
        if (zeroes==0) return n-1;
        return maxLen;
    }
}
