package Arrays.TwodArrays;

import java.util.Scanner;

public class ultaSprint {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows");
        int n = sc.nextInt();
        System.out.print("Enter number of columns");
        int m = sc.nextInt();

        
        int[][] arr = new int[n][m];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        // for(int j =0;j<m;j++){
        //     System.out.print(arr[0][j]);
        // }
        
        
            for(int i =0;i<n;i++){
                if(i%2==0){
                    for(int j = 0;j<m;j++){
                        System.out.print(arr[i][j]);
    
                    }
                    System.out.println();
                }
                else{
                    for(int j =m-1;j>=0;j--){
                        System.out.print(arr[i][j]);
                    }
                System.out.println();
                }

            }
            sc.close();
}
}
