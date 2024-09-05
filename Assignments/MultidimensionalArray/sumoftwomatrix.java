package Assignments.MultidimensionalArray;

import java.util.Scanner;

public class sumoftwomatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int n  = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        int[][] brr = new int[n][m];
        System.out.println("Enter the element of first array");
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the element of first array");
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                brr[i][j] = sc.nextInt();
            }
        }

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                arr[i][j] += brr[i][j];
            }
        }
        for(int[] ele : arr){
            System.out.println();
            for(int b:ele){
                System.out.print(b+" ");
            }
        }
        sc.close();

    }
}
