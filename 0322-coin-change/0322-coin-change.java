class Solution {
    private int f(int idx,int amt,int coins[],int dp[][]){
        if(idx==0){
            if(amt % coins[0]==0) return amt/coins[0]; //amount is divisible by the coin, returning how many coins 
            return (int)1e9;
        }
        if(dp[idx][amt]!=-1) return dp[idx][amt];
        int notpick=f(idx-1,amt,coins,dp);
        int pick=(int)1e9;
        if(coins[idx]<=amt) pick=1+f(idx,amt-coins[idx],coins,dp);
        return dp[idx][amt]=Math.min(pick,notpick);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        for(int row[]:dp) Arrays.fill(row,-1);
        int ans= f(n-1,amount,coins,dp);
        if(ans>=(int)1e9) return -1;
        return ans;
    }
}