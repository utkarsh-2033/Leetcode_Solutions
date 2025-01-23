class Solution {
    public static long mod=1000000007;
    public long power(long x, long n){
        if(n==0) return 1;
        long ans=power(x,n/2);
        if(n%2==0) return (ans*ans)%mod;
        else return (ans*ans*x)%mod;
    }
    public int countGoodNumbers(long n) {
        long oddplaces=n/2;
        long evenplaces=(n+1)/2;                  //(n+1)/2
        long oddcount=power(4,oddplaces);
        long evencount=power(5,evenplaces);
        return (int)((oddcount*evencount)%mod);
    }
}