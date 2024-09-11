package Merge_Sort;

import java.util.Arrays;

import Assignments.Arrays.mergetwo;
import Assignments.Strings.ismorphic;

public class practice {




    public static void main(String[] args) {
        int [] arr = {2,4,6,8};
        int [] brr = {1,3,5,7,9};
        int [] ans = new int[arr.length+brr.length];
        System.out.println(Arrays.toString(mergetwosortedarray(arr,brr , ans)));

    }

    private static int[] mergetwosortedarray(int[] arr, int[] brr, int[] ans) {
        int i =0;
        int j =0;
        int c = 0;

        while (i<arr.length && j<brr.length) {

            if(arr[i]>brr[j]){
                ans[c] = brr[j];
                c++;
                j++;
            }
            if(arr[i]<brr[j]){
                ans[c] = arr[i];
                c++;
                i++;
            }
            
        }
        if(i==arr.length){
            while(j<brr.length) {
                ans[c] = brr[j];
                c++;
                j++;
            }
        }
        if(j==brr.length){
           while (i<arr.length) {
                ans[c] = arr[i];
                c++;
                i++;
            }
        }
        return ans ;
    } 
    
}
