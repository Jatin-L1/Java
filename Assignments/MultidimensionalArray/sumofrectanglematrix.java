package Assignments.MultidimensionalArray;

import java.util.Scanner;

public class sumofrectanglematrix {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the size of rows: ");
        int n = scn.nextInt();

        System.out.print("Enter the size of columns: ");
        int m = scn.nextInt();
        
        int[][] arr = new int[n][m];
        System.out.println("Enter the elements of the matrix:");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = scn.nextInt();
            }
        }

        System.out.print("Enter the coordinate 1 (a b): ");
        int a = scn.nextInt();
        int b = scn.nextInt();

        System.out.print("Enter the coordinate 2 (x y): ");
        int x = scn.nextInt();
        int y = scn.nextInt();

        int startRow = Math.min(a, x);
        int endRow = Math.max(a, x);
        int startCol = Math.min(b, y);
        int endCol = Math.max(b, y);

        int sum = 0;
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                sum += arr[i][j];
            }
        }

        System.out.print("Sum of elements in the rectangle: " + sum);
        scn.close();
    }
}
