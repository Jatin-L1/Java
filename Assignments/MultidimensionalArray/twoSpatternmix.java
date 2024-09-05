package Assignments.MultidimensionalArray;

import java.util.Scanner;

public class twoSpatternmix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n (odd only): ");
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                // if(arr[i][j]==arr[n/2][j] || arr[i][j]==arr[i][n/2]){ 
                if (i==n/2 || j==n/2) {
                    
                    System.out.print(arr[i][j]);
                }
                else{
                   System.out.print(" "); 
                }
            }
            System.out.println();
        }

        sc.close();
    }
}
