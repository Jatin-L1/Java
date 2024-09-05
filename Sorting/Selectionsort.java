package Sorting;

import java.util.Scanner;

public class Selectionsort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] arr =new int[n];
        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        for(int i =0;i<n-1;i++){
            int min = Integer.MAX_VALUE;
            int mindx = -1;

            for(int j =i;j<n;j++){
                if (arr[j]<min) {
                    min = arr[i];
                    mindx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[mindx];
            arr[mindx] = temp;
        }
        for(int ele : arr){
            System.out.print(ele + " ");
        }
        sc.close();
    }
}
