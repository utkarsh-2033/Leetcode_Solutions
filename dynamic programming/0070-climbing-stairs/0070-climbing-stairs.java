class Solution {
    int recurr(int idx, int[] dp) {
        if (idx == 0)
            return 1; //base case
        if (dp[idx] != -1)
            return dp[idx];
        int fs = recurr(idx - 1, dp);
        int ss = 0;
        if (idx > 1)
            ss = recurr(idx - 2, dp);
        return dp[idx] = fs + ss;
    }

    public int climbStairs(int n) {
        //tabulation-bottom to top
        int dp[] = new int[n + 1];
        // for(int i=0;i<n+1;i++) dp[i]=-1;
        dp[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            int fs = dp[i-1];
            int ss = 0;
            if (i > 1)
                ss = dp[i-2];
            dp[i] = fs + ss;
        }
        return dp[n];
    }
}