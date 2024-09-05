package Assignments.Arrays;

import java.util.Scanner;

public class product {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Number of elements in the array : ");
        int n = sc.nextInt();

        int [] arr = new int [n];
        int product = 1;
        System.out.print("Enter the elements: ");
        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
            product *= arr[i]; 
        }
        System.out.println(product);

        sc.close();
        
    }
    
}