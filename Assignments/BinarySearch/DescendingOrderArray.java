package Assignments.BinarySearch;

import java.util.Scanner;

public class DescendingOrderArray {
    public static int descending(int[] arr, int k){
        int n = arr.length;
        int lo =0 , hi=n-1;
        while(lo<=hi){
            int mid = lo +(hi-lo)/2;
            if (lo==0 && hi==0) {
                return 0;
                
            }
            if(arr[mid]==k){
                return mid;
            }
            else if (arr[mid]>k) {
                lo = mid+1;
                
            }
            else{
                hi =mid-1;
            }

        }

        return 2435;

    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the Element you want to search: ");
        int k = sc.nextInt();



        System.out.print(descending(arr,k));
        sc.close();


    }
}
