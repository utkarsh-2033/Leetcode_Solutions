class Solution {
    int f(int idx1,int idx2,String s,String p,int dp[][]){
        if(idx1<0 || idx2<0) return 0;
        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
        if(s.charAt(idx1)==p.charAt(idx2))  //characters match
        return dp[idx1][idx2]=1+f(idx1-1,idx2-1,s,p,dp);
        return dp[idx1][idx2]=Math.max(f(idx1-1,idx2,s,p,dp),f(idx1,idx2-1,s,p,dp));  // character doesnot match
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n1=text1.length();
        int n2=text2.length();
        int dp[][]=new int[n1][n2];
        for(int row[]:dp) Arrays.fill(row,-1);
        return f(n1-1,n2-1,text1,text2,dp);
    }
}