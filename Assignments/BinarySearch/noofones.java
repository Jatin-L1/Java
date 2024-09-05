package Assignments.BinarySearch;

import java.util.Scanner;

public class noofones {
    public static int noo(int[] arr) {
        int n = arr.length;
        int lo =0,hi=n-1;
        int count =0;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid]==0){
                lo =mid+1;
            }
            else if(arr[mid]==1){
                if(arr[mid-1]==1){
                    hi = mid-1;
                }
                else if (mid==0 ||arr[mid-1]==0) {
                    return n-mid;
                    
                }

            }

        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.print(noo(arr));
        sc.close();
    }
    }
    

