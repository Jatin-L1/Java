package Assignments.Arrays;

import java.util.Scanner;

public class changing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the size of array: " );
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Please enter the values of array: " );
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 0;i<n;i++){
            if(i%2==0){
                arr[i] +=10;
            }
            else {
                arr[i] *=2;
            }
        }
        for(int ele : arr){
            System.out.print(ele+" ");
        }
        sc.close();
}
}
