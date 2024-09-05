package Assignments.BinarySearch;

import java.util.Scanner;

public class rowmaxonesinmatrix {
    public static int row(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int max = 0;
        int rows =0;
        for(int i =0;i<n;i++){
            int lo =0,hi=m-1;
            while (lo<=hi) {
                int mid = lo + (hi-lo)/2;
                if(arr[i][mid]==0){
                    lo = mid+1;
                }
                if(arr[i][mid] == 1) {
                    if (mid == 0 || arr[i][mid-1] == 0) { 
                        int ones = m - mid;
                        if(ones > max) {
                            max = ones;
                            rows = i;
                        }
                        break;
                    } else if (arr[i][mid-1] == 1) {
                        hi = mid - 1;
                    }
                }
                
            }
        }
        return rows;

        
    }
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int n = sc.nextInt();
        System.out.print("Enter the number of coloumns: ");
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        System.out.print("Enter the elments in the array: ");
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.print(row(arr));
        sc.close();
    }
}
