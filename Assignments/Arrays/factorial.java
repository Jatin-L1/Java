package Assignments.Arrays;

import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int x = scn.nextInt();
        int[] arr = new int[x];
        int product = 1;
         for(int i=0;i<x;i++){
            for(int j =1;j<x;j++) {
                product *= j;
                arr[i] = product;
            }
         }
        System.out.println(product);
        for(int ele:arr){
            System.out.print(ele+" ");
        }
        scn.close();
    }
}
