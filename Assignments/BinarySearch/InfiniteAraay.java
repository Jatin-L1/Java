package Assignments.BinarySearch;

import java.util.Scanner;

public class InfiniteAraay {

    public static int binarySearch(int lo , int hi , int[] arr , int k){
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(arr[mid]==k){
                return mid;
            }
            else if (arr[mid]>k) {
                hi = mid-1;
                
            }
            else{
                lo = mid+1;
            }
        }
        return 2435;
    }


    public static int updation(int []arr , int k){
        int lo = 0;
        int hi = 1;
        if(arr[hi]<k){
            lo = hi;
            hi *=2;
        } 

        return binarySearch( lo , hi , arr , k);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[1000];
        
        for(int i =0;i<1000;i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the number you want to search");
        int k = sc.nextInt();

        System.out.print(updation(arr , k));
        sc.close();
    }
}
