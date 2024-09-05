package Assignments.Sorting;

import java.util.Scanner;

public class kthsmallest {
    public static void swap(int[] arr   ,int a , int b){
        int  temp = arr[a];
        arr[a] =arr[b];
        arr[b] = temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        System.out.print("Enter the numbers less that the size of array: ");
        int k = sc.nextInt();

        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        for(int i =0;i<n;i++){
            for(int j =i;j>=1;j--){
                if(arr[j]<arr[j-1]){
                    swap(arr, j, j-1);
                }
            }
        }
        System.out.print(k+"th smallest elemnt in array is: "+ arr[k]);
        sc.close();
    }
}
