package BinarySearch;

import java.util.Scanner;

public class leetcode33 {
    public static int  index(int[] arr , int k ) {
        int n = arr.length;
        int lo =0 ,hi=n-1;
        while (lo<=hi) {

            int mid = lo+(hi-lo)/2;
            if(arr[mid]==k) return mid;
            else if (arr[mid]<=arr[hi]) { 
                // right sorted part main hain
                if(arr[mid]<k && arr[hi]>=k){
                    lo = mid+1;
                } 
                else{
                    hi = mid-1;
                }
                
            }
            else{
                //left sorted part main hain hum
                if(arr[mid]>k && arr[lo]<=k){
                    hi =mid-1;
                }
                else{
                    lo = mid+1;
                }
            }
            
        }
        return -1;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size of Array: ");
        int n = sc.nextInt();
        System.out.print("Enter the number");
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.print(index(arr,k));
        sc.close();


    }
}
