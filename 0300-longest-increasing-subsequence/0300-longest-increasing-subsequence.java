class Solution {
    // tabulation + space optimized
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n+1]; // +1 to adjust -1 idx
        // for(int row[]:dp) Arrays.fill(row,-1);
        for(int idx=n-1;idx>=0;idx--){
            for(int prev_idx=idx-1;prev_idx>=-1;prev_idx--){
                int nottake=0+dp[prev_idx+1];
                int take=0;
                if(prev_idx==-1 || nums[idx]>nums[prev_idx])
                take=1+dp[idx+1];
                dp[prev_idx+1]=Math.max(take,nottake);
            }
        }
        return dp[0];
    }
}