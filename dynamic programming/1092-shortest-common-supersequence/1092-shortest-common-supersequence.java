class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        //constructing dp array
        int dp[][]=new int[n+1][m+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<=m;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)) 
                dp[i][j]=1+dp[i-1][j-1];
                else 
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        // traversing dp bottom corner to top corner 
        //and constituting along the supersequence
        int i=n,j=m; 
        String s="";
        while(i>0 && j>0){
            //character matches and moving diagonally up-left
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                s+=str1.charAt(i-1);
                i--; j--;
            }
            //character doesnot match
            else if(dp[i-1][j]>dp[i][j-1]){ // moving up
                s+=str1.charAt(i-1);
                i--;
            }
            else{ //moving left
                s+=str2.charAt(j-1);
                j--;
            }
        }
        // j reached 0 - str2 gets exhausted
        while(i>0){ s+=str1.charAt(i-1); i--;}
        // i reached 0 - str1 gets exhausted
        while(j>0){ s+=str2.charAt(j-1); j--;}
        String ans=new StringBuilder(s).reverse().toString();
        return ans;
    }
}