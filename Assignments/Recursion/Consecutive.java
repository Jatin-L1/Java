package Assignments.Recursion;

import java.util.Arrays;

public class Consecutive {
    public static int[] sum(int[] arr , int i){
        if(i==arr.length-1){
            return arr;
        }
        arr[i] = arr[i] + arr[i+1];
        return sum(arr , i+1);

    }
    public static void print(int[] arr){
        int n = arr.length;
        if (n==1) {
            System.out.print(Arrays.toString(arr));
            return;
        }
        System.out.println(Arrays.toString(arr));
        int[] newArr = new int[arr.length-1];
        // for(int i=0;i<arr.length-1;i++){
        //     newArr[i] = arr[i] + arr[i+1];

        // }
        sum(newArr , 0);
        print(newArr);

    }
    


    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};

        print(arr);
    }
}
