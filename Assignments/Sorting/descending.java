package Assignments.Sorting;

import java.util.Scanner;

public class descending {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the value in array: ");
        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        for(int i =0;i<n-1;i++){
            for(int x=0;x<n-1-i;x++){
                if(arr[x]<arr[x+1]){
                    int temp = arr[x];
                    arr[x] = arr[x+1];
                    arr[x+1] = temp;
                }
            }
        }
        for(int ele:arr){
            System.out.print(ele+" ");
        }





        sc.close();
    }
}
