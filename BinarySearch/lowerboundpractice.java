package BinarySearch;

import java.util.Scanner;

public class lowerboundpractice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {-1,0,3,5,9,12};
        int n = arr.length;
        int x = sc.nextInt();
        int lb = n;

        int lo =0 , hi = n-1;

        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(arr[mid]>=x){
                lb = Math.min(mid, lb);
                hi = mid-1;
            }
            else lo = mid+1;
        }
        System.out.print(lb);




        sc.close();

    }
}
