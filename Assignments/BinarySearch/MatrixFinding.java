package Assignments.BinarySearch;

import java.util.Scanner;

public class MatrixFinding {
    public static boolean Exists(int[][] arr,int k){

        int n = arr.length;
        int m = arr[0].length;

        for(int i =0;i<n;i++){
            int lo =0,hi=m-1;
            
            while(lo<=hi){
                
                int mid = lo +(hi-lo)/2;
                int midelement = arr[mid/m][mid%m];
                if(midelement==k){
                    return true;
                }
                else if (midelement<k) {
                    lo = mid+1;
                    
                }
                else{
                    hi = mid+1;
                }
            }
        }
        return false;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int n = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int m = sc.nextInt();
        int[][] arr = new int[n][m];

        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.print("Enter the number you wanna search: ");
        int k = sc.nextInt();
        System.out.print(Exists(arr,k));



        sc.close();
    }
}
