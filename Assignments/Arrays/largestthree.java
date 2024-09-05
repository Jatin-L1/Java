package Assignments.Arrays;

import java.util.Scanner;

public class largestthree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of elements in the array : ");
        int n = sc.nextInt();

        int [] arr = new int [n];
        int max = Integer.MIN_VALUE;
        int second_max =  Integer.MIN_VALUE;
        int third_max =  Integer.MIN_VALUE;
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
        for(int i=0;i<n;i++){
        
            if(arr[i]>=second_max && arr[i]<max){
                second_max = arr[i];
            }
        }
        for(int i=0;i<n;i++){
        
            if(arr[i]>=third_max && arr[i]<max && arr[i]<second_max){
                third_max = arr[i];
            }
        }
        System.out.println(max);
        System.out.println(second_max);
        System.out.println(third_max);
        

        sc.close();
        
    
}
}
