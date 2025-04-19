class Solution {
    public int minInsertions(String s) {
        int n=s.length();
        int prev[]=new int[n+1];
        for(int i=1;i<n+1;i++){
            int curr[]=new int[n+1];
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==s.charAt(n+1-j-1)) 
                curr[j]=1+prev[j-1];
                else 
                curr[j]=Math.max(prev[j],curr[j-1]);
            }
            prev=curr;
        }
        int lcsLen=prev[n];
        return (n-lcsLen);
    }
}