package Assignments.BinarySearch;

import java.util.Scanner;

public class perfectSquare {
    public static int square(int n){
        int lo =0, hi=n;

        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
                if(mid*mid==n){
                    return mid;
                }
                else if (mid*mid>n) {
                    hi = mid-1;
                    
                }
                else{
                    lo = mid+1;
                }
            }
        return 2435;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.print(square(n));
        sc.close();
    }
}
