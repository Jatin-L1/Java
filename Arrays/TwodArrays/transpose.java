package Arrays.TwodArrays;

import java.util.Scanner;

public class transpose {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[4][2];
        
        System.out.println("Enter number of rows: ");
        int n =sc.nextInt();
        System.out.println("Enter number of columns: ");
        int m =sc.nextInt();
        System.out.println("Enter the value in 2d array");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();
            }
        }


        for(int j=0;j<m;j++){
            for(int i=0;i<n;i++){
                System.out.println(arr[i][j]+" ");
            }
        }
        sc.close();
    }
}
