class Solution {
    int f(int i,int j,String word1,String word2,int dp[][]){
        //s1 gets exhausted
        if(i<0) return j+1; //j+1 new insertions required in s1
        //s2 gets exhausted
        if(j<0) return i+1; //i+1 new deltions required from s1
        if(dp[i][j]!=-1) return dp[i][j];
        // characters match - move to next idx in both - no operation required
        if(word1.charAt(i)==word2.charAt(j)){
            return dp[i][j]=f(i-1,j-1,word1,word2,dp) ;
        }
        //characters dont match - opration required - 3 opertions possible
        return dp[i][j]=1+Math.min(f(i-1,j,word1,word2,dp),  // delete
                      Math.min(f(i-1,j-1,word1,word2,dp), //replace
                                     f(i,j-1,word1,word2,dp) //insert
                      ));
    }
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int dp[][]=new int[n][m];
        for(int row[]:dp) Arrays.fill(row,-1);
        return f(n-1,m-1,word1,word2,dp);
    }
}