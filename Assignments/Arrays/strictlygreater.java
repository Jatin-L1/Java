package Assignments.Arrays;

import java.util.Scanner;

public class strictlygreater {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the size of array: " );
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Please enter the values of array: " );
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Please enter the number you want to see: ");
        int x = sc.nextInt();

        int count = 0;

        for(int i = 0;i<n;i++){
            if(arr[i]>x){
                count++;
            }
        }
        System.out.print(count);
        sc.close();
}
}
