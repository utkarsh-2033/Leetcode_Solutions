class Solution {
    int recurr(int idx,int[] arr,int []dp){
        if(idx==0) return arr[0];
        if(dp[idx]!=-1) return dp[idx];
        int pick=arr[idx] ;
        if (idx>1) pick+=recurr(idx-2,arr,dp);
        int notPick=recurr(idx-1,arr,dp);
        return dp[idx]= Math.max(pick , notPick);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int [n];
        Arrays.fill(dp,-1);
        return recurr(n-1,nums,dp);
    }
}