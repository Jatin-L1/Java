import java.util.*;

public class UpperCaseLowerCase {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i =0;i<n/2;i++){
            for(int j =0;j<n;j++){
                if(j==0 || j==n/2 || i==0 && j>n/2){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for(int i =0;i<n;i++){
            System.out.print("*");
        }
        System.out.println();
        for(int i =n/2+1;i<n;i++){
            for(int j =0;j<n;j++){
                if(j==n-1 ||j==n/2 ||i==n-1 && j<=n/2){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
    public int paths(int[][] dp , int i , int j){
        if(i>0 && j>0 && dp[i][j]==1) return 0;
        if(i==0 && j==0) return dp[0][0];
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int up = paths(dp , i-1, j);
        int down = paths(dp , i , j-1);
        return dp[i][j] = up + down;

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m =  obstacleGrid.length;
        int n =  obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i =0;i<m;i++){
            for(int j = 0 ;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return paths(dp,m-1,n-1);
        
    }

}
