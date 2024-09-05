package Assignments.Arrays;

import java.util.Scanner;

public class secondlargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of elements in the array : ");
        int n = sc.nextInt();

        int [] arr = new int [n];
        int max = Integer.MIN_VALUE;
        int second_max = -1;
        System.out.print("Enter the elements: ");
        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
            if(arr[i]>=max){
                max = arr[i];
            }
            if(arr[i]>=second_max && arr[i]<max){
                second_max = arr[i];
            }
        }
        // System.out.println(max);

        for(int i=0;i<n;i++){
        
            if(arr[i]>=second_max && arr[i]<max){
                second_max = arr[i];
            }
        }
        System.out.println(second_max);
        

        sc.close();
        
    }
}
