class Solution {
    private int f(int idx,int amt,int coins[],int dp[][]){
        if(idx==0){
            if(amt%coins[0]==0) return 1;
            return 0;
        }
        if(dp[idx][amt]!=-1) return dp[idx][amt];
        int nottake=f(idx-1,amt,coins,dp);
        int take=0;
        if(coins[idx]<=amt) take=f(idx,amt-coins[idx],coins,dp);
        return dp[idx][amt]=nottake + take;
    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        for(int row[]:dp) Arrays.fill(row,-1);
        return f(n-1,amount,coins,dp);
    }
}