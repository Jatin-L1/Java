package Assignments.MultidimensionalArray;

import java.util.Scanner;

public class storingteninfivebyfivetwoDmatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[5][5];

        for(int i =0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j] = 10;
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
