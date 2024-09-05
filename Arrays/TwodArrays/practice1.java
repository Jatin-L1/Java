package Arrays.TwodArrays;

import java.util.Scanner;

public class practice1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[4][2];
        System.out.println("Enter the value in 2d array");
        for(int i=0;i<4;i++){
            for(int j=0;j<2;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        for(int [] ele:arr){
            for(int b:ele){
                System.err.print(b+" ");
            }
        }
    }
}
