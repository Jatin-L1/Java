package Assignments.Arrays;

import java.util.Scanner;

public class diffrenceevenodd {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the size of array: " );
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Please enter the values of array: " );
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int odd_sum = 0;
        int even_sum = 0;
        for(int i = 0;i<n;i++){
            if(i%2==0){
                even_sum +=arr[i];
            }
            else odd_sum +=arr[i];
        }
        int difference = even_sum - odd_sum ;
        System.out.print(difference);
        sc.close();
}
}
