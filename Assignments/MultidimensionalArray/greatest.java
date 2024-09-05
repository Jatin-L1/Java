package Assignments.MultidimensionalArray;

import java.util.Scanner;

public class greatest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int n = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(arr[i][j]>max) max = arr[i][j];
            }
        }
        System.out.print(max);

        sc.close();
    }
}
