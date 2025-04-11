// package Arrays.TwodArrays;

// import java.util.Scanner;

// public class ninetydegree {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.print("Enter number of rows");
//         int n = sc.nextInt();
//         System.out.print("Enter number of columns");
//         int m = sc.nextInt();

        
//         int[][] arr = new int[n][m];
//         int [][] ninety = new int[m][n]; // sc o(m*n)
//         for(int i =0;i<n;i++){
//             for(int j =0;j<n;j++){
//                 arr[i][j] = sc.nextInt();
//             }
//         }
//         for(int i =0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 ninety[i][j] = arr[j][i];
//                 // ninety[j][i] = arr[i][j];
//             }
//         }
//         for(int [] ele:ninety){
//             System.out.println();
//             for(int b:ele){
//                 System.err.print(b+" ");
//             }
//         }

//         System.out.println();

//         for(int i =0;i<m;i++){
//             for(int j=0;j<n/2;j++){
//                 int temp = ninety[i][j];
//                 ninety[i][j] = ninety[i][n-1-j];
//                 ninety[i][n-1-j] =  temp;
//             }
//         }
//         for(int [] ele:ninety){
//             System.out.println();
//             for(int b:ele){
//                 System.err.print(b+" ");
//             }
//         }
//     }
// }


package Arrays.TwodArrays;

import java.util.Scanner;

public class ninetydegree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows");
        int n = sc.nextInt();
        System.out.print("Enter number of columns");
        int m = sc.nextInt();

        
        int[][] arr = new int[n][m];
        // int [][] ninety = new int[m][n]; // sc o(m*n)
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        for(int i =0;i<n;i++){
            for(int j=i;j<m;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;

            }
        }
        System.out.println();

        for(int i =0;i<m;i++){
            for(int j=0;j<n/2;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[i][n-1-j];
                arr[i][n-1-j] =  temp;
            }
        }
        for(int [] ele:arr){
            System.out.println();
            for(int b:ele){
                System.err.print(b+" ");
            }
        }
    }
}

