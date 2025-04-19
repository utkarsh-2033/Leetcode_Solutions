class Solution {
    private int f(int i,int j,String s ,String t,int dp[][]){
        if(j==0) return 1; // t gets exhausted => 1 subseq matched found
        if(i==0) return 0; // s gets exhausted => no subseq matched found in this path
        if(dp[i][j]!=-1) return dp[i][j];
        // characters matched
        if(s.charAt(i-1)==t.charAt(j-1))  
        // move to to next idx on both to check next chracaters matching 
        //or remain on same t idx and next idx in s to check for other possibilities of same character present in s 
        return dp[i][j]=f(i-1,j-1,s,t,dp) + f(i-1,j,s,t,dp);
        //else - character didnt match - move to next chracter in s to match
        return dp[i][j]=f(i-1,j,s,t,dp);
    }
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        int dp[][]=new int[n+1][m+1];
        for(int row[]:dp) Arrays.fill(row,-1);
        return f(n,m,s,t,dp);
    }
}