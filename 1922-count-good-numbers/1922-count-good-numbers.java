class Solution {
    // evrything in long(10^18-to avoid Integer Overflow(int-10^9) 
    //since question constraint n<=10^15
    public static long mod=1000000007;
    public long power(long x, long n){
        if(n==0) return 1;
        long ans=power(x,n/2);
        if(n%2==0) return (ans*ans)%mod;
        else return (ans*ans*x)%mod;
    }
    //0 based indexing
    public int countGoodNumbers(long n) {
        long oddplaces=n/2;
        long evenplaces=(n+1)/2;             //(n+1)/2

       // for odd-4 options(2,3,5,7) => 4^no of places
        long oddcount = power(4, oddplaces);
        // for even-5 options(0,2,4,6,8) => 5^no of places
        long evencount=power(5,evenplaces);
        return (int)((oddcount*evencount)%mod);
    }
}
