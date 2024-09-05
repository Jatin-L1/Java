package Assignments.BinarySearch;

import java.util.Scanner;

public class noofCompleterows {
    public static int row(int arr){

        int lo =0 , hi=arr; 
        while(lo<=hi){
            int mid = lo +(hi-lo)/2;
            if(mid*(mid+1)/2==arr){
                return mid;
            }
            else if (mid*(mid+1)/2<arr) {
                lo = mid+1;
                
            }
            else {
                hi = mid-1;
                
            }
        }




        return hi;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
       

        System.out.print(row(n));
        sc.close();
    }
}
