package Assignments.Recursion;

public class sortedornot {
    public static boolean sorted(int[] arr , int i){
        int n = arr.length;
        if(i==n-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return sorted(arr, i+1);
    }



    public static void main(String[] args) {
        int[] arr = {1,2,3,6,5};

       System.out.println(sorted(arr , 0));
    }
    
}
