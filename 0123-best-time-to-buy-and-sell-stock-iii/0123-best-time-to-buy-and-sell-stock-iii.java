class Solution {
    //tabulation
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n + 1][2][3];
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap < 3; cap++) {
                    if (buy == 1) {
                        dp[idx][buy][cap] = Math.max(-prices[idx] + dp[idx+1][0][cap], dp[idx+1][1][cap]);
                    } else {
                        dp[idx][buy][cap] = Math.max(prices[idx] + dp[idx+1][1][cap-1], dp[idx+1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}