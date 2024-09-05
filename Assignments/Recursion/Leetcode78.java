package Assignments.Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Leetcode78 {
    // public static int numIdenticalPairs(int[] arr) {
    //     int n = arr.length;
    //     int count  =0;
    //     for(int i =0;i<n;i++){
    //         for(int j=i+1;j<n;j++){
    //             if(arr[i]==arr[j]){
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;

        
    // }
     static List<List<Integer>> arr;
     public static void helper(int n , int[] nums , ArrayList<Integer> ans){
        

     }

    


     public List<List<Integer>> subsets(int[] nums) {

        arr = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        helper(0, nums, ans);
        return arr;





     }
     public static void main(String[] args) {
        
     }
}
