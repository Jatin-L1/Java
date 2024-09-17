package CycleSort;

import java.util.ArrayList;
import java.util.List;

public class FindingAllDuplicates {
    static ArrayList<Integer> ans = new ArrayList<>();
    public static void swap(int[]arr , int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
       arr[b] = temp;
    }
    
    public static List<Integer> find(int[] arr) {
        int n = arr.length;
        int i =0;
        while (i<n) {
            if (arr[i]-1==i || arr[i]==arr[arr[i]-1]) i++;
            else{
                swap(arr , i , arr[i]-1);
            } 
        }
        for(i =0;i<n;i++){
            if (arr[i]!=i+1) {
                ans.add(arr[i]);
            }
        }
        return ans;
        
    }
    public static void main(String[] args) {
        int[] arr = {1};
        ans = new ArrayList<>();
        find(arr);
       for(int ele : arr){
        System.out.print(ele+" ");
       }
       System.out.println();
       System.out.println(ans);
    }
}
