package TwodArrays;

import java.util.Scanner;

public class Multiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        
        for(int i = 0; i < testCases; i++){
            int R1 = sc.nextInt(); // no of rows in A
            int C1 = sc.nextInt(); // no of cols in A
            int[][] A = new int[R1][C1]; // initliazing the matrix A

            // input le liye 
            for(int j = 0; j < R1; j++){
                for(int k = 0; k < C1; k++){  
                    A[j][k] = sc.nextInt();
                }
            }

            int R2 = sc.nextInt(); // no of rows in B
            int C2 = sc.nextInt(); // no of cols in B
            int[][] B = new int[R2][C2]; // initliazing the matrix B
            
            // input le liye 
            for(int j = 0; j < R2; j++){
                for(int k = 0; k < C2; k++){
                    B[j][k] = sc.nextInt();
                }
            }

            if (C1 != R2) {
                System.out.println("Error hain bhai code main");
            } else {
                int[][] c = new int[R1][C2]; 
                
                for(int x = 0; x < R1; x++){
                    for(int j = 0; j < C2; j++){
                        for(int k = 0; k < C1; k++){
                            c[x][j] += A[x][k] * B[k][j]; //FORMULA HAIN
                        }
                        System.out.print(c[x][j] + " "); 
                    }
                    System.out.println();
                }
            }
        }
    }
}
