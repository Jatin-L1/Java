package Assignments.Arrays;

import java.util.Scanner;

public class Unique {
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
            boolean isUnique = true;
            for(int j = 0;j<n;j++){
                if(i!=j && arr[i]==arr[j]) {
                    isUnique = false;
                    break;
                }
            }
            if(isUnique==true){
                System.out.println(arr[i]);
            }



        }
        sc.close();
}
}
