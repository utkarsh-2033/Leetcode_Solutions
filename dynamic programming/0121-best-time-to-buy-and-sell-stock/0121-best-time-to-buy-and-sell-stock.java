class Solution {
    ///dp- keeping track of mininimum till that idx
    public int maxProfit(int[] prices) {
        int minprice=prices[0];
        int profit=Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
            minprice=Math.min(minprice,prices[i]);
            profit=Math.max(profit,prices[i]-minprice);
        }
        return profit;
    }
}