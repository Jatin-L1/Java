package BinarySearch;

public class Curator1 {

    public static int postion(int[] arr , int target){
        int n = arr.length;
        int lo = 0 , hi = n-1;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid]==target) return mid;
            if(arr[mid]>target) hi = mid-1;
            else lo = mid+1;
        }
        return lo;
    }
    public static void main(String[] args) {
        int[] arr = {1 , 3,4,5};
        int target = 2; 

        System.out.println(postion(arr, target));
    }
    
}
