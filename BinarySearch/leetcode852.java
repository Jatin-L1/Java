package BinarySearch;

import java.util.Scanner;

public class leetcode852 {
    public static int peak(int[] arr) {
        int n = arr.length;
        int lo =0 , hi=n-1;
        while (lo<=hi) {
            int mid = lo+(hi-lo)/2;
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) return mid;
            else if (arr[mid]>arr[mid-1] && arr[mid]<arr[mid+1])  {
                lo = mid+1;
                
            }
            else if(arr[mid]<arr[mid-1] && arr[mid]>arr[mid+1]){
                hi = mid-1;
            }

            
        }
        return 8460;
        
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size of Array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        } 
        System.out.print(peak(arr));
        sc.close();
    }
}
