class Solution {
    //same as Buy and Sell Stock III - just instead of 2 transactions , here k transactions
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int dp[][] = new int[2][k+1];
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap < k+1; cap++) {
                    if (buy == 1) {
                        dp[buy][cap] = Math.max(-prices[idx] + dp[0][cap], dp[1][cap]);
                    } else {
                        dp[buy][cap] = Math.max(prices[idx] + dp[1][cap-1], dp[0][cap]);
                    }
                }
            }
        }
        return dp[1][k]; 
    }
}