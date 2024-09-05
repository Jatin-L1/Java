package BinarySearch;



public class Practice {
    public static void main(String[] args) {
      int[] arr = {10,15,21,34,81,105,180,500};
      int n = arr.length;
      int target = 81;
      int lo = 0;
      int hi = n-1;
      boolean flag = false;
      while(lo<=hi){
        int mid = lo + (hi-lo)/2;
        if(arr[mid]>target) hi = mid-1;
        else if(arr[mid]<target) lo = mid+1;
        else if(arr[mid]==target){
            flag = true ;
            break;
        } 
      }
      if(flag){
        System.out.print("The number is present in the array");
      }
      else{
        System.out.print("The number is not present in the array");
      }
      


    }   
}
