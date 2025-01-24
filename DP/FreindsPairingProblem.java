package DP;
import java.util.Arrays;
import java.util.Scanner;

public class FreindsPairingProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(pair(n , dp));
        System.out.println(friend(n)); // tabulation way
            }
    private static int friend(int n) {
        int[]  dp = new int[n+1];
        if(n>0) dp[1] = 1;
        if(n>1) dp[2] = 2;
        for(int i =3;i<=n;i++){
            dp[i] = dp[i-1] + (i-1)*dp[i-2];
        }
        return dp[n];

    }
    private static int pair(int n , int[] dp){
        if (n<=2) return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=pair(n-1 , dp) + (n-1)*pair(n-2 , dp);
    }
    public int paths(int row , int col , int m , int n){
        if(row>=m||col>=n) return 0;
        if(row==m-1 && col==n-1) return 1;
        int rightWays = paths(row, col+1, m, n);
        int downWays = paths(row+1 , col , m ,n);
        return rightWays + downWays;
    }
    public int uniquePaths(int m, int n) {
        return paths(0,0,m,n);
    }
}
