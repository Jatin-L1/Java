package Assignments.Recursion;

import java.util.Arrays;

public class GfGBubbleSort {

    public static int[] Bubble(int i , int[] arr , int m){
        int n = arr.length;
        if(m>0){
            return Bubble(i, arr, m-1);
        }
        if(i==arr.length){
            i=0;
        }
        if(arr[i]>arr[i+1]){
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
        Bubble(i+1, arr, m-1);
        return arr;
    }


    public static void main(String[] args) {
        int[] arr = {5,8,9,1,2};

       System.err.println(Arrays.toString(Bubble(0 , arr , arr.length-1)));
    }
    
}
