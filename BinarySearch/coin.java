package BinarySearch;

import java.util.Scanner;

public class coin {
    public static int count(int n ){
        int lo = 0 , hi = n;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            int curr = mid *(mid+1)/2;
            if(curr==n) return mid;
            if(curr>n) hi = mid-1;
            else lo = mid+1;
        }
        return lo-1;

    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(count(n));
        
    }
}
