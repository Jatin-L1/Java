package Assignments.Recursion;

import java.util.Arrays;

public class GfGBubbleSort {

    public static int[] Bubble( int[] arr , int m){
        int n = arr.length;
        if(m==1){
            return arr;
        }
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
            // for(int ele : arr){
            //     System.out.print(ele +" ");
            // }
            // System.out.println();

        }
        Bubble(arr, m-1);
        return arr;
    }


    public static void main(String[] args) {
        int[] arr = {5,8,9,1,2};

       System.err.println(Arrays.toString(Bubble( arr , arr.length-1)));
    }
    
}
