class Solution {
    public boolean dist(String s, String t) {
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i))
                c++;
        }
        return c == 1;
    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n=words.length;
        int dp[]=new int[n];
        int parent[]=new int[n];
        Arrays.fill(dp,1);  // length of lis starting at each idx in starting is 1
        for(int i=0;i<n;i++) parent[i]=i;
        int max=1;
        int last=0;
        for(int i=1;i<n;i++){
            for(int j=i-1;j>=0;j--){
                if(words[i].length()==words[j].length() 
                && groups[j]!=groups[i] && dist(words[i],words[j])){
                    if (dp[i] < dp[j] + 1) {  // Only update if it increases
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                    }
                }
            }
            if (dp[i] > max) {
            max = dp[i];
            last = i;
            }
        }
        ArrayList<String> ans=new ArrayList<>();
        while(parent[last]!=last){
            ans.add(words[last]);
            last=parent[last];
        }
        ans.add(words[last]);
        Collections.reverse(ans);
        return ans;
    }
}