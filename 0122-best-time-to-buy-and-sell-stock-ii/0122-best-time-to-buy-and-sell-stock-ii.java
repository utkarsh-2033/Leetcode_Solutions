class Solution {
    //space-optimized - using single 2 size 1d array
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ahead[] = new int[2]; 
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                   ahead[buy] = Math.max(-prices[idx] + ahead[0],
                            ahead[1]);
                } 
                if(buy == 0) {
                    ahead[buy] = Math.max(prices[idx] + ahead[1],
                            ahead[0]);
                }
            }
        }
        return ahead[1];
    }
}