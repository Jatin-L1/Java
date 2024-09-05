package Recursion;

public class ArrayTarget {
    public static int find(int[] arr  ,int target , int index) {
        if (index ==arr.length) {
            return -1;
            
        }
        if(arr[index]==target){
            return index;
        }
         return  find(arr , target  , index+1);
    }
    public static void main(String[] args) {
        int[] arr  ={1,2,3,4,5,6};
        System.out.print(find(arr , 7 , 0));
    }

    
}
