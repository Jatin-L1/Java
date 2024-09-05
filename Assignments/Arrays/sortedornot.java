package Assignments.Arrays;

import java.util.Scanner;

public class sortedornot {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the size of array: " );
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Please enter the values of array: " );
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
            int mid = n/2;
            if(arr[mid]>arr[mid-1] && arr[mid]<arr[mid+1]){
                System.out.print("Sorted");
            }
            else System.out.print("Not sorted");
        sc.close();
}
}
