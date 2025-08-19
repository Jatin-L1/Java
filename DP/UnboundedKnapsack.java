package DP;

public class UnboundedKnapsack {
    public static int profit(int i  , int[] wt , int[] val , int c,  int[][]dp){
        if(i==wt.length) return 0;
        if(dp[i][c]!=-1) return dp[i][c];
        int skip = profit(i+1 , wt , val , c , dp);
        if(wt[i]> c) return dp[i][c] = skip;
        int take = val[i] + profit(i, wt, val, c-wt[i],dp);
        return dp[i][c] = Math.max(take , skip); // iska matlab hota hian return hum Math.max(take , skip); yeh kar rahe hain but phele dp main stotre kar rhae hain
    }

    public static void main(String[] args) {
        int[] val = {5,3,7,16};
        int[] wt = {1,2,8,10};
        int C = 8;
        int n = val.length;
        int[][] dp = new int[n][C+1];
        for(int i =0 ; i<n;i++){
            for(int j=0 ; j<dp[0].length;j++)dp[i][j] = -1;
        }
        
        System.out.println(profit(0,wt,val,C , dp));


        // for(int i = 0 ; i<n ; i++){
        //     for(int c  = 0 ; c<dp[0].length ; c++){
        //         int skip = (i>0) ? dp[i-1][c] : 0;
        //         if(wt[i]> c) dp[i][c] = skip;
        //         else{
        //             int take = val[i];
        //             take+= (i>0) ?  dp[i-1][c-wt[i]] : 0;
        //             dp[i][c] = Math.max(take , skip);
        //         }
        //     }
        // }
        // System.out.println(dp[n-1][C]);

    }
    public long coinCount(int i , int[] coins , int amount){
        if(i==coins.length){
            if(amount==0) return 0;
            else return Integer.MAX_VALUE; // not a valid combination
        }
        long skip = coinCount(i+1, coins, amount);
        if(amount-coins[i]<0) return skip;
        long pick = 1 + coinCount(i, coins, amount - coins[i]);
        return Math.min(skip, pick);
    }

    public int coinChange(int[] arr, int amount) {
        int n = arr.length; 
        int[][] dp = new int[n+1][amount+1];
        for(int i =0 ; i<n;i++){
            for(int j=0 ; j<dp[0].length;j++)dp[i][j] = -1;
        }
        int ans = (int)(coinCount(0 , arr, amount));

        return ans==Integer.MAX_VALUE ? -1 : ans;
    }

}
