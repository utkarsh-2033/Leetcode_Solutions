class Solution {
    public int minDistance(String word1, String word2) {
        int n1=word1.length();
        int n2=word2.length();
        int prev[]=new int[n2+1];
        for(int idx1=1;idx1<=n1;idx1++){
        int curr[]=new int[n2+1];
            for(int idx2=1;idx2<=n2;idx2++){
                if(word1.charAt(idx1-1)==word2.charAt(idx2-1))  //characters match
                curr[idx2]=1+prev[idx2-1];
                else
                curr[idx2]=Math.max(prev[idx2],curr[idx2-1]);
            }
            prev=curr;
        }
        int lcs=prev[n2];
        return(n1+n2 - 2*lcs);
    }
}