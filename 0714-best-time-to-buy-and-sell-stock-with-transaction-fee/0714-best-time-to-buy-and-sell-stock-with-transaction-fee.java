class Solution {
    //same as buy ans sell stock 2 + fee
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp[][] = new int[n+2][2]; 
        int profit=0;
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    dp[idx][buy] = Math.max(-prices[idx] + dp[idx + 1][0],
                            dp[idx + 1][1]);
                } 
                if(buy == 0) {
                    //when selling - fee charged - 1 transection cmplt
                    dp[idx][buy] = Math.max(prices[idx] - fee + dp[idx + 1][1],
                            dp[idx + 1][0]);
                }
            }
        }
        return dp[0][1];
    }
}