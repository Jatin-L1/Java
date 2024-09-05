package Assignments.Sorting;

import java.util.Scanner;

public class minimumsum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        // binary search
        // for(int i = 0;i<n-1;i++){
        //     for(int x=0;x<n-1-i;x++){
        //        if (arr[x]>arr[x+1]) {
        //             int temp =arr[x];
        //             arr[x] = arr[x+1];
        //             arr[x+1] = temp;
        //        } 

        //     }
        // }

        //Selection Sort
        // for(int i =0;i<n-1;i++){
        //     int min = Integer.MAX_VALUE;
        //     int mindx = -1;

        //     for(int j=i;j<n;j++){
        //         if(arr[j]<min){
        //             min = arr[j];
        //             mindx = j;
        //         }
        //     }
        //     int temnp = arr[i];
        //     arr[i] = arr[mindx];
        //     arr[mindx] = temnp;
        // } 


        // insertion sort

        for(int i =1 ; i<n ; i++){
            for(int j= i;j>=1;j--){
                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                }
            }
        }



        int sum = arr[0] +  arr[1];
        System.out.println("Smallest sum is :" + sum);
        sc.close();

    }
    public static void swap(int[] arr   ,int a , int b){
        int temp = arr[a];
        arr[a] =arr[b];
        arr[b] = temp;
    }
}
