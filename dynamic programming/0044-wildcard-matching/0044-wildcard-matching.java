class Solution {
    // p has wildcard characters - ? , *
    private int f(int i,int j,String s,String p,int dp[][]){
        if(i==0 && j==0) return 1;  //both gets exhausted at same time
        if(i>0 && j==0) return 0;  //p gets exhausted and s reamining
        //s gets exhausted and p reamining
        if(i==0 && j>0){ 
        //true if all remaining characters of p is * - since it can match with empty and more chars
            for(int k=j;k>0;k--) if(p.charAt(k-1)!='*') return 0;
            return 1;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?') //character matched
            return dp[i][j]= f(i-1,j-1,s,p,dp);

        //case 1(Match 0 characters)- considering * matched with empty string 
        //case 2(Match 1 or more characters)- considering * can match with 1 or more than charcaters
        if(p.charAt(j-1)=='*') return dp[i][j]=(f(i,j-1,s,p,dp)==1 || f(i-1,j,s,p,dp)==1)? 1:0; 

        //else 
        return dp[i][j]=0;
    }
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        int dp[][]=new int[n+1][m+1];
        for(int row[]:dp) Arrays.fill(row,-1);
        return (f(n,m,s,p,dp)==0)? false:true;
    }
}