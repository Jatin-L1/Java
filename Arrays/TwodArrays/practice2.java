package Arrays.TwodArrays;

import java.util.Scanner;

public class practice2 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[4][2];
        System.out.println("Enter the value in 2d array");
        for(int i=0;i<4;i++){
            for(int j=0;j<2;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int m = arr.length;
        int n =arr[0].length;
        int max = Integer.MAX_VALUE;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if (arr[i][j]<max) {
                    max=arr[i][j];
                }
            }
        }
        System.out.println(max);
    }
}
