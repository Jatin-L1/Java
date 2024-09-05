package Assignments.BinarySearch;

import java.util.Scanner;

public class MahaBaalshali {
    public static boolean Target(int[] arr ,  int k){
        int lo = 0 , hi = arr.length-1;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            
            if(arr[mid]==k){
                return true;
            }
            if(arr[mid]<arr[hi]) //right sorted part main hain hum
            {
                if (arr[mid]<k && arr[hi]>=k) {
                    lo = mid+1;
                    
                }
                else{
                    hi = mid-1;
                }
            }
            else{ //left sorted part main hain
                if(arr[mid]==k){
                    return true;
                }
                else if (arr[mid]>k && arr[lo]<=k) {
                    hi = mid-1;
                    
                }
                else{
                    lo = mid+1;
                }


            }
        }
        return false;
    
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the numeber you want to search: ");
        int k = sc.nextInt();
        System.out.print(Target(arr,k));
        sc.close();
        }
}
