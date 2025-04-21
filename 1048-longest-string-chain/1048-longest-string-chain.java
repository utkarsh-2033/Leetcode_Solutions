class Solution {
    boolean compare(int l,int m,String[] words){
        String s=words[l]; 
        String p=words[m]; 
        if(s.length()!=p.length()+1) return false;
        int i=0,j=0;
        while(i<s.length() ){
            if(j<p.length() && s.charAt(i)==p.charAt(j)){
                i++;j++;
            }else{
                i++;
            }
        }
        if(i==s.length() && j==p.length()) return true;
        return false;
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n=words.length;
        int dp[]=new int[n];
        Arrays.fill(dp,1); 
        int mx=1;
        for(int i=1;i<n;i++){
            for (int j = 0; j < i; j++){
                if(compare(i,j,words) && 1+dp[j]>dp[i]){
                    dp[i]=1+dp[j];
                }
            }
                    mx=Math.max(mx,dp[i]);
        }
        return mx;
    }
}