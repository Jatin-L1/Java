package Arrays;

import java.util.Arrays;
public class Leetcode217 {
    public static boolean duplicate(int[] arr){
        
        int n = arr.length;
        Arrays.sort(arr);
        for(int i =0;i<n-1;i++){
            // if(i==n){
            //     return false;
            // }
            if(arr[i]==arr[i+1]){
                return true;
            }
        }
        return false;
    } 


    
    public static void main(String[] args) {
        int [] arr = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(duplicate(arr));
    }
}
