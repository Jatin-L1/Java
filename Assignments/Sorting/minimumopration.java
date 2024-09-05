package Assignments.Sorting;

import java.util.ArrayList;
import java.util.Scanner;

import Assignments.Pattern.alphabet;

public class minimumopration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the value in array: ");
        // ArrayList brr = new ArrayList<>(n);
        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int count = 0;
        int sum = 0;
        for(int i =0;i<n-1;i++){
                if(arr[i]==arr[i+1]){
                    sum++;
                }
            }
        int[] brr = new int[n-sum]  ;
        for(int i =0;i<n-sum;i++){
            if(arr[i]!=arr[i+1]){
                arr[i]=brr[i];
            }
        }
        for(int j =0;j<n;j++){
       
        for(int i =0;i<n-sum-1;i++){
            if (brr[i]>brr[i+1]) {
                brr[i+1] = brr[i];
                count++;
            }
        }
        
    }
        // for(int ele : arr){
        //     System.out.println(ele);
        // }
        System.out.println(count);
    }
}
