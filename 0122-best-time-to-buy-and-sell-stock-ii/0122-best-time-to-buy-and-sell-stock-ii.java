class Solution {
    //parameter - buy - to indicate what we did last - sell or buy
    //f(idx,buy)-max profit from idx 0 to idx when last transaction was buy(1) or sell(0)

    private int f(int idx,int buy,int prices[]){ 
        if(idx==prices.length) return 0;
        if(buy==1){
            //buying : -prices ,coz we are investing / giving out money 
            //exploring two possible options buy or not buy
            return Math.max(-prices[idx] +  f(idx+1,0,prices) ,  //  buy
                                f(idx+1,1,prices));              //not buy
        }
        else{
            //exploring two possible options sell or not sell
            return  Math.max(prices[idx] + f(idx+1,1,prices),   //sell
                                  f(idx+1,0,prices));           //not sell
        }

    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        return f(0,1,prices);
    }
}