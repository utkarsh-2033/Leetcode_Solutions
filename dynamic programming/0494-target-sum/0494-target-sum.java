class Solution {
        int f(int idx,int target,int arr[],int dp[][]){
        if(idx==0){
            if(arr[0]==0 && target==0) return 2 ; //pick or not pick : in both case target 0 is achieved
            if(target==0 || arr[0]==target) return 1;
            return 0;
        }
        if(dp[idx][target]!=-1) return dp[idx][target];
        int notpick=f(idx-1,target,arr,dp);
        int pick=0;
        if(arr[idx]<=target) pick=f(idx-1,target-arr[idx],arr,dp);
        return dp[idx][target]=pick+notpick;
    }
    public int findTargetSumWays(int[] nums, int target) {
         int n=nums.length;
        int totalsum=0;
        for(int i:nums) totalsum+=i;
        if((totalsum+target)%2!=0) return 0;
        if (totalsum < Math.abs(target)) return 0;
        if ((totalsum + target) % 2 != 0 || (totalsum + target) < 0) return 0;
        int s=(totalsum+target)/2;
        int dp[][]=new int[n][s+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<s+1;j++) dp[i][j]=-1;
        }
        return f(n-1,s,nums,dp);
    }
}