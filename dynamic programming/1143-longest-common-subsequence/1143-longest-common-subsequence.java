class Solution {
    // int f(int idx1,int idx2,String s,String p,int dp[][]){
    //     if(idx1==0 || idx2==0) return 0;
    //     if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
    //     if(s.charAt(idx1-1)==p.charAt(idx2-1))  //characters match
    //     return dp[idx1][idx2]=1+f(idx1-1,idx2-1,s,p,dp);
    //     return dp[idx1][idx2]=Math.max(f(idx1-1,idx2,s,p,dp),f(idx1,idx2-1,s,p,dp));  // character doesnot match
    // }
    public int longestCommonSubsequence(String s, String p) {
        int n1=s.length();
        int n2=p.length();
        int dp[][]=new int[n1+1][n2+1];
        // for(int row[]:dp) Arrays.fill(row,-1);
        for(int i=0;i<=n2;i++) dp[0][i]=0;
        for(int i=1;i<=n1;i++) dp[i][0]=0;
        for(int idx1=1;idx1<=n1;idx1++){
            for(int idx2=1;idx2<=n2;idx2++){
                if(s.charAt(idx1-1)==p.charAt(idx2-1))  //characters match
                dp[idx1][idx2]=1+dp[idx1-1][idx2-1];
                else
                dp[idx1][idx2]=Math.max(dp[idx1-1][idx2],dp[idx1][idx2-1]);
            }
        }
        return dp[n1][n2];
    }
}