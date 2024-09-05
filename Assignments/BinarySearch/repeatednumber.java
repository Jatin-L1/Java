package Assignments.BinarySearch;

import java.util.Scanner;

public class repeatednumber {
    public static int repeat(int[] arr){
        int n = arr.length;
        int lo =0 , hi = n-1;

        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid]==arr[mid+1] ){
                return arr[mid];
            }
            else if (mid==0 || arr[mid]==arr[mid-1]) {
                return arr[mid];
                
            }
            else if (arr[mid]>=mid+1) {
                lo = mid+1;
            }
            else{
                hi = mid-1;
            }

        }
        return 6932;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.print(repeat(arr));


        sc.close();
    }
}
