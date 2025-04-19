class Solution {
    //space-optimized - using 2 variable
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // int ahead[] = new int[2]; 
        int curr=0,ahead=0;
        for (int idx = n - 1; idx >= 0; idx--) {
                   ahead = Math.max(-prices[idx] + curr,
                            ahead);
                    curr = Math.max(prices[idx] + ahead,
                            curr);
        }
        return ahead;
    }
}