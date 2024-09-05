package Assignments.BinarySearch;

import java.util.Scanner;

public class lastoccurence {
    public static int lp(int[] arr , int k) {
        int n = arr.length;
        int lo =0,hi=n-1;
        while (lo<=hi) {
            int mid = lo+(hi-lo)/2;
            if (arr[mid]==k) {
                if(arr[mid]==arr[mid+1]){
                    lo = mid;
                }
                else{
                    return mid;
                }
                
            }
            else if(arr[mid]>k){
                hi = mid-1;
            }
            else if (arr[mid]<k) {
                lo=mid+1;
                
            }
        }
        return -1;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        System.out.print("Enter the nmbrt whose last occurence you want: ");
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.print(lp(arr,k));
        sc.close();
    }
}
