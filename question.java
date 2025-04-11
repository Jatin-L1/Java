public class question {
    public int longestNiceSubarray(int[] arr) {
        int n = arr.length;
        int maxLength = 0;
        int left = 0;
        int mask = 0;  
        for (int right = 0; right < n; right++) {
            while ((mask & arr[right]) != 0) {
                mask ^= arr[left];
                left++;
            }
            mask |= arr[right];
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
        
    }
}
