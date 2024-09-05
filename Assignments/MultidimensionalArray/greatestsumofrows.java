package Assignments.MultidimensionalArray;

import java.util.Scanner;

public class greatestsumofrows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        System.out.print("Enter m: ");
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                arr[i][j] =sc.nextInt();
            }
        }



        int Maxsum = Integer.MIN_VALUE;
        int sum =0;
        int row = 0;
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                sum += arr[i][j];
                
            }
            if(sum>Maxsum) {
                Maxsum = sum;
                row =i;
            }

        }
        System.out.print(row);
         
        sc.close();
    }
}
