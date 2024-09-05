package Assignments.Recursion;

import java.util.Arrays;

public class GfGMinMax {
    

    public static void main(String[] args) {
        int[] arr = {5,2,8,4,1,3,0};
        int[] ans = new int[2];
        System.out.println( Arrays.toString(minMax(0 ,arr,ans)));
    }

    public static int[] minMax(int i ,int[] arr , int[] ans) {
        if(i==arr.length){
            return ans;
        }
        int Max = ans[1];
        int Min = ans[0];
        if(arr[i]>Max) ans[1] = arr[i];
        if(arr[i]<Min) ans[0] = arr[i];
        minMax(i+1, arr, ans);
        return ans;

    }
}
