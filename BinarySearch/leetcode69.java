package BinarySearch;

import java.util.Scanner;

public class leetcode69 {
    
    public static int sqrt(int n ) {

        int lo =0 , hi = n;
        while (lo<=hi) {
            int mid = lo + (hi-lo)/2;
            if(mid*mid==(long)n) return (int)mid;
            else if (mid*mid>(long)n) {
                hi  = mid-1;
                
            }
            else if(mid*mid<(long)n){
                lo = mid+1;
            }
        }
        return (int)hi;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();
        System.out.print(sqrt(n));
        sc.close();
    }
}
