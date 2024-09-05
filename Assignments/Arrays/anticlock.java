package Assignments.Arrays;

import java.util.Scanner;

public class anticlock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n : " );
        int n = sc.nextInt();
        System.out.print("Enter m : " );
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        int [][] transpose = new int[m][n];

        System.out.println("Please enter the values of array: " );
        for(int i = 0; i < n; i++){
            for(int j =0;j<m;j++){
                arr[i][j] = sc.nextInt();

            }
        }
        System.out.println();
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                int temp = arr[i][j];
                arr[i][j] = transpose[j][i];
                transpose[j][i] = temp;
            }

        }
        // for(int j =0;j<m;j++){
        //     int a =0 , b = m-1;
        //     while(a<b){
        //         int temp = transpose[a][j];
        //         transpose[a][j] = transpose[b][j];
        //         transpose[b][j] = temp;
        //         a++;
        //         b--;
        //     }

        // }    
        for(int j =0;j<m;j++){
            int a =0 , b=m-1;
            for(int i =0 ;i<n/2;i++){
                int temp = transpose[a][j];
                transpose[a][j] = transpose[b][j];
                transpose[b][j] = temp;
                a++;
                b--;
            }
        }
        System.out.println();
        for(int[] ele : transpose){
            System.out.println();
            for(int b : ele){
                System.out.print(b+" ");
            }
        }
        sc.close();
    }   
}