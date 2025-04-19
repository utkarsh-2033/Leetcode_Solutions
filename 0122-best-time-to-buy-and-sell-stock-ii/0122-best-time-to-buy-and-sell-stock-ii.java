class Solution {
    //space-optimized - using 2 variable
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // int ahead[] = new int[2]; 
        int curr=0,ahead=0;
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                   ahead = Math.max(-prices[idx] + curr,
                            ahead);
                } 
                if(buy == 0) {
                    curr = Math.max(prices[idx] + ahead,
                            curr);
                }
            }
        }
        return ahead;
    }
}