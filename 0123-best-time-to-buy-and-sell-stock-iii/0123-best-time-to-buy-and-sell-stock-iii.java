class Solution {
    //taking 3rd parameter - like knapsack - capacity - two ensure max 2 traansaction 
    // 1 transaction = buy + sell so cap-- only when sell
    //addition base case - when transactions(cap) exhaust - return
    private int f(int idx,int buy,int cap,int prices[],int dp[][][]){
        if(idx==prices.length) return 0;
        if(cap==0) return 0;
        if(dp[idx][buy][cap]!=-1) return dp[idx][buy][cap];
        if(buy==1){
            return dp[idx][buy][cap]= Math.max(-prices[idx]+ f(idx+1,0,cap,prices,dp),f(idx+1,1,cap,prices,dp));
        }
        else{
            return dp[idx][buy][cap]= Math.max(prices[idx]+ f(idx+1,1,cap-1,prices,dp),f(idx+1,0,cap,prices,dp));
        }
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][][]=new int[n][2][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                for(int k=0;k<3;k++) dp[i][j][k]=-1;
            }
        }
        return f(0,1,2,prices,dp);
    }
}