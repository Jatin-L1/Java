package Assignments.Recursion;

import java.util.Arrays;

public class GfGInsertionSort {
    public static int[] InsertionSort(int[] arr , int i){
        int n = arr.length;
        if(i==n){
            return arr;
        }
        for(int j=i;j>=1;j--){
            if(arr[j]<arr[j-1]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1]=temp;
            }
        }
        
        return InsertionSort(arr, i+1);
    }
    public static void main(String[] args) {
        int[] arr = {5,8,7,1,9};

       System.out.println(Arrays.toString(InsertionSort(arr , 1)));

    }
    
}
