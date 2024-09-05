package Arrays.TwodArrays;

import java.util.Scanner;

public class practise3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int n = sc.nextInt();
        System.out.print("Enteer the number of columns: ");
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        int[][] brr = new int[n][m];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                arr[i][j] = sc.nextInt();
                brr[i][j] = arr[i][j];

            }
        }
        // good approach but more optimized version can be done
        // for(int i =0;i<n;i++){
        //     for(int j =0;j<m;j++){
        //         if(brr[i][j]==0){
        //             for(int b =0;b<m;b++){
        //                 arr[i][b]=0;
        //             }
        //         }
        //     }
        // }
        // for(int j =0;j<m;j++){
        //     for(int i =0;i<n;i++){
        //         if(brr[i][j]==0){
        //             for(int b =0;b<n;b++){
        //                 arr[b][j]=0;
        //             }
        //         }
        //     }
        // }
        // for(int[] ele : arr){
        //     System.out.println();
        //     for(int b : ele){
        //         System.out.print(b);
        //     }
        // }
        boolean[] row = new boolean[n];
        boolean[] column = new boolean[m];

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
               if(arr[i][j]==0){
                row[i] = true;
                column[j] = true;
               }
            }
        }
        for(int i =0;i<n;i++){
            if(row[i]==true){
                for(int j =0;j<m;j++){
                    arr[i][j]=0;
                }
            }
        }
        for(int j =0;j<m;j++){
            if (column[j]==true) {
                for(int i =0;i<n;i++){
                    arr[i][j] = 0;
                }
            }
        }
          for(int[] ele : arr){
            System.out.println();
            for(int b : ele){
                System.out.print(b);
            }
        }
        
        
        
        
        
        sc.close();
    }
}
