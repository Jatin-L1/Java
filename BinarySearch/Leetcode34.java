package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class Leetcode34 {
    public static int[] fandlast(int[] arr , int k,int[]ans,int n){
        int lo =0,hi=n-1;
        boolean flag = false;
        //serching the arrray
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(arr[mid]==k){
                flag = true;
                break;
            }
            else if (arr[mid]>k) {
                hi =mid-1;
            }
            
            else if (arr[mid]<k) {
                lo =mid+1;
            }


        }
        if (flag==false) {
            return ans;
        }
        //lower bound
        int lb = n ; lo=0 ; hi=n-1;
        while (lo<=hi) {
            int mid = lo+(hi-lo)/2;
            if(arr[mid]>=k){
                lb = Math.min(lb,mid);
                hi = mid-1;
            }
            else lo = mid+1;
            
        }
        ans[0] = lb;

        //upper bound
        int ub = n ; lo=0 ; hi=n-1;
        while (lo<=hi) {
            int mid = lo+(hi-lo)/2;
            if(arr[mid]>k){
                lb = Math.min(ub,mid);
                hi = mid-1;
            }
            else lo = mid+1; 
        }
        ans[1] = ub-1;
        return ans;


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size of Array: ");
        int n = sc.nextInt();
        int[] ans = {-1,-1};

        int[] arr = new int[n];

        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the number: ");
        int k = sc.nextInt();
        int[] result = fandlast(arr ,k ,ans,n);
        System.out.println(Arrays.toString(result));
        sc.close();
        
    }
}
