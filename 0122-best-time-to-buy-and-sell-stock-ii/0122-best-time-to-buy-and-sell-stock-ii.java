class Solution {
    //parameter - buy - to indicate what we did last - sell or buy
    //f(idx,buy)-max profit from idx 0 to idx when last transaction was buy(1) or sell(0)

    private int f(int idx,int buy,int prices[],int dp[][]){ 
        if(idx==prices.length) return 0;
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        if(buy==1){
            //buying : -prices ,coz we are investing / giving out money 
            //exploring two possible options buy or not buy
            return dp[idx][buy]= Math.max(-prices[idx] +  f(idx+1,0,prices,dp) ,  //  buy
                                f(idx+1,1,prices,dp));              //not buy
        }
        else{
            //exploring two possible options sell or not sell
            return dp[idx][buy]=  Math.max(prices[idx] + f(idx+1,1,prices,dp),   //sell
                                  f(idx+1,0,prices,dp));           //not sell
        }

    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][]=new int[n][3]; //no of states possible+1
        for(int row[]:dp) Arrays.fill(row,-1);
        return f(0,1,prices,dp);
    }
}