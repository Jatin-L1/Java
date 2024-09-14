package CycleSort;

import java.util.ArrayList;

public class DissapearedNumber {
    static ArrayList<Integer> ans = new ArrayList<>();
    public static void swap(int[] arr , int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    public static ArrayList Dissaper(int[] arr) {
        int n = arr.length;
        int i =0;
        while (i<n) {
            if (arr[i]==i+1 || arr[i] == arr[arr[i]-1]) i++;
            else{
                swap(arr , i , arr[i]-1);
            } 
        }
        for(i =0;i<n;i++){
            if (arr[i]!=i+1) {
                ans.add(i+1);
            }

        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        ans = new ArrayList<>();
        Dissaper(arr);
        System.out.println(ans);
    }

    
}
