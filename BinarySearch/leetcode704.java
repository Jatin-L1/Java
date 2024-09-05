package BinarySearch;

import java.util.Scanner;

public class leetcode704 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {-1,0,3,5,9,12};
        int n = arr.length;
        int k = sc.nextInt();

        int lo =0 , hi=n-1;
        boolean flag = false;
        while (lo<=hi) {
            int mid = lo + (hi-lo)/2;
            if(arr[mid]>k){
                hi = mid-1;
            }
            else if (arr[mid]<k) {
                lo = mid+1;
                
            }
            else if (arr[mid]==k) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.print("Element is present in arr");
        }
        else{
            System.out.print("Element is not present in array ");
        }
        sc.close();
    }
}
