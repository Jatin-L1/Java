package BinarySearch;

import java.util.Random;

public class lowerbound {
    public static void main(String[] args) {
        int[] arr = {1,4,6,7,9,11,15};
        int target = 7;
        int n = arr.length;
        int lb = n;
        int lo =0 ,hi =n-1;
        while (lo<=hi) {
            int mid = lo +(hi-lo)/2;
            if(arr[mid]>=target){
                lb = Math.min(lb,mid);
                hi = mid-1;
            }
            else lo = mid+1;
            
        }     
        // System.out.println(lb); 
        Random random = new Random();
        int x = random.nextInt();
        System.out.println(x);  
    }

}
