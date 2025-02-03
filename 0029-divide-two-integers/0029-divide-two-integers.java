class Solution {
    public int divide(int dividend, int divisor) {
        boolean sign=true;
        if((dividend>0 && divisor<0) || (dividend<0 && divisor >0)) sign=false;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long ldividend=Math.abs(dividend);
        long ldivisor=Math.abs(divisor);
        long ans=0;
        while(ldividend>=ldivisor){
            int cnt=0;
            while(ldividend>=(ldivisor<<(cnt+1))){
                cnt++;
            }
            ans+=(1<<cnt);
            ldividend-=ldivisor*(1<<cnt);
        }
        if(ans==(1<<31) && sign) return Integer.MAX_VALUE;
        if(ans<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (sign)?(int)ans:-(int)ans;
    }
}