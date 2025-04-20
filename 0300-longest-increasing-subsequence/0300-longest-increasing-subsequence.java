class Solution {
    private int f(int idx,int prev_idx,int []nums,int dp[][]){
        if(idx==nums.length) return 0;
        if(dp[idx][prev_idx+1]!=-1) return dp[idx][prev_idx+1];
        int nottake=0+f(idx+1,prev_idx,nums,dp);
        int take=0;
        if(prev_idx==-1 || nums[idx]>nums[prev_idx])
        take=1+f(idx+1,idx,nums,dp);
        return dp[idx][prev_idx+1]=Math.max(take,nottake);
    } 
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][n+1]; // +1 to adjust -1 idx
        for(int row[]:dp) Arrays.fill(row,-1);
        return f(0,-1,nums,dp);
    }
}