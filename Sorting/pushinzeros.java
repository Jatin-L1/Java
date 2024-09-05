package Sorting;

import java.util.Scanner;

public class pushinzeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int [] arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        for(int x = 0;x<n-1;x++){
            for(int i =0;i<n-1-x;i++){
                if(arr[i] ==0){
                    int temp =arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
        for(int ele : arr){
            System.out.print(ele+" ");
        }
        sc.close();
    }
}
