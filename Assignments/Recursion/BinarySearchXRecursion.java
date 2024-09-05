package Assignments.Recursion;

public class BinarySearchXRecursion {

    public static boolean BinarySearch(int lo , int hi , int k , int[] arr){
        if(lo>=hi){
            return false;

        }
        int mid = lo +(hi-lo)/2;
        if (arr[mid]==k) {
            return true;
            
        }
        if(arr[mid]>k) BinarySearch(lo, mid-1, k, arr);
        if(arr[mid]<k) BinarySearch(mid+1, hi, k, arr);
        return false;
    }
    
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int k = 10;
        System.out.println(BinarySearch(0,arr.length, k , arr));
    }
}
