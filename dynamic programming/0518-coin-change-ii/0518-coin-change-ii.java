class Solution {
    // private int f(int idx,int amt,int coins[],int dp[][]){
    //     if(idx==0){
    //         if(amt%coins[0]==0) return 1;
    //         return 0;
    //     }
    //     if(dp[idx][amt]!=-1) return dp[idx][amt];
    //     int nottake=f(idx-1,amt,coins,dp);
    //     int take=0;
    //     if(coins[idx]<=amt) take=f(idx,amt-coins[idx],coins,dp);
    //     return dp[idx][amt]=nottake + take;
    // }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        // for(int row[]:dp) Arrays.fill(row,-1);
        for(int i=0;i<amount+1;i++){
            if(i%coins[0]==0) dp[0][i]=1;
        }
        for(int idx=1;idx<n;idx++){
            for(int amt=0;amt<amount+1;amt++){
                int nottake=dp[idx-1][amt];
                int take=0;
                if(coins[idx]<=amt) take=dp[idx][amt-coins[idx]];
                dp[idx][amt]=nottake + take;
            }
        }
        return dp[n-1][amount];
    }
}