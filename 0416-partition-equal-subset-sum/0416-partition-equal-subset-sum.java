class Solution {
    private boolean f(int idx,int target,int arr[],int dp[][]){
        if(target==0) return true;
        if(idx==0) return arr[0]==target;
        if(dp[idx][target]!=-1) return (dp[idx][target]==0)? false : true;
        boolean nottake=f(idx-1,target,arr,dp);
        boolean take=false;
        if(arr[idx]<=target) take=f(idx-1,target-arr[idx],arr,dp);
        dp[idx][target]=(take||nottake)?1:0;
        return take||nottake;
    }

    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i:nums) sum+=i;
        if(sum%2!=0) return false; // if sum is odd , can not be divided into 2 eqaul sum
        int dp[][]=new int[n][sum+1];
        for(int row[]:dp) Arrays.fill(row,-1);
        return f(n-1,sum/2,nums,dp);
    }
}