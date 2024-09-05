package Assignments.MultidimensionalArray;

import java.util.Scanner;

public class spiralprint {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        int[][] spiral = new int[n][n];
        int count =1;
        for(int i = 0;i<n;i++){
            for(int j =0;j<n;j++){
                arr[i][j] = count;
                count++;

            }
        }
        int minr = 0 , maxr = n-1 , minc = 0, maxc = n-1;
        count = 1;
        while(minr<=maxr || minc<=maxc){
            for(int i = minc ; i<=maxc;i++){
                spiral[minr][i] = count++;
            }
            minr++;
            System.out.println();
            if(minr>maxr || minc>maxc) break;
            for(int i = minr;i<=maxr;i++){
                spiral[i][maxc] = count++;
            }
            maxc--;
            System.out.println();
            if(minr>maxr || minc>maxc) break;
            for(int i = maxc ; i>=minc;i--){
                spiral[maxr][i] = count++;
            }
            maxr--;
            System.out.println();
            if(minr>maxr || minc>maxc) break;
            for(int i = maxr ; i>=minr;i--){
                spiral[i][minc] = count++;
            }
            minc++;
        }
        for(int [] ele : spiral){
            System.out.println();
            for(int br : ele){
                System.out.print(br);
            }
        }
        sc.close();

    }
}
