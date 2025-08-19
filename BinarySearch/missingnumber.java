package BinarySearch;

import java.util.Arrays;

public class missingnumber {
    public static int number(int[] arr) {
        int n = arr.length;
        int lo = 0, hi = n - 1;
        if (arr[0] != 1) return 1;
    
        if (arr[n-1] != n+1) return n+1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] != mid + 1) {
                if (mid == 0 || arr[mid-1] == mid) {
                    return mid + 1;
                }
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        return -1; 
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6};  
        
        int missingNumber = number(arr);
        System.out.println("Missing number: " + missingNumber);
        
    
        int[] arr2 = {1, 3, 4, 5};  
        System.out.println("Missing number in second array: " + number(arr2));
    }
}