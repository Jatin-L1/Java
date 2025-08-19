public class LargestNonAdjacent {
    public static void main(String[] args) {
        int[] arr = {2,4,5,7,1,6,8};
        int n = arr.length;
        int k = 3; 
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        int maxSum = windowSum;     
        for (int i = k; i < n; i++) {
            windowSum = windowSum + arr[i] - arr[i-k];
           
            maxSum = Math.max(maxSum, windowSum);
        }
        
        System.out.println(maxSum);
    }
}