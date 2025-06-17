class Solution {
    int M =(int)1e9+7;
    // Binary exponentiation:
    public long pow(long a, long b) {
        long result=1;
        a %=M;
        while(b>0){
            if((b&1)==1)
                result=(result*a)%M;
            a=(a*a)%M;
            b>>=1;
        }
        return result;
    }
    // nCr % MOD
    public long nCr(int n, int r, long[] fact, long[] invFact) {
        return fact[n]*invFact[n-r] % M * invFact[r] % M;
    }

    public int countGoodArrays(int n, int m, int k) {
        long[] fact = new long[n + 1];
        long[] invFact = new long[n + 1];

        fact[0]=1;
        for(int i=1; i<=n;i++){
            fact[i]=(fact[i-1]*i) % M;
        }
        //Fermat's Theorem
        for(int i=0;i<=n;i++){
            invFact[i] =pow(fact[i],M-2);
        }
        long ans=nCr(n-1,k,fact,invFact);  // Choose k positions
        ans =ans*m % M;                   // First element: m options
        ans =ans*pow(m-1,n-k-1) % M; // Rest elements
        return (int) ans;
    }
}