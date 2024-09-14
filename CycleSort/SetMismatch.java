package CycleSort;

import java.util.Arrays;

public class SetMismatch {
    public static void swap(int[] arr , int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    
    public static int[] Set(int[] arr) {
        int n =arr.length;
        int i =0;
        int[] ans = new int[2];
        while (i<n) {
            if(arr[i]==i+1 || arr[i]==arr[arr[i]-1]) i++;
            else{
                swap(arr , i,arr[i]-1);
            }

        }
        for( i =0;i<n;i++){
            if (arr[i]-1!=i) {
                ans[0] = arr[i];
                ans[1] = i+1;
            }

        }
        // for(int ele: ans){
        //     System.out.println(ele+" ");
        // }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,1};
        System.out.println(Arrays.toString(Set(arr)));
        
    }

    
}
