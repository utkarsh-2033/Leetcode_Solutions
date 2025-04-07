class Solution {
    int recurr(int idx,int []arr,int dp[]){
        if(idx==0) return arr[0];
        if(dp[idx]!=-1) return dp[idx];
        int pick=arr[idx];
        if(idx>1) pick+=recurr(idx-2,arr,dp);
        int notpick=recurr(idx-1,arr,dp);
        return dp[idx]=Math.max(pick,notpick);
    }
    //   1 2 3 1
    //  |____| -> startinclude
    //     |____| -> startexclude
    //Applying robber house 1 concept on above 2 arrays 
    //and then max of both is the required answer
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int startinclude[]=new int[n-1];
        int startexclude[]=new int[n-1];
        int j=0;
        int k=0;
        for(int i=0;i<n;i++){
            if(i!=n-1) startinclude[j++]=nums[i];
            if(i!=0) startexclude[k++]=nums[i];
        }
        int dp1[]=new int[n-1];
        Arrays.fill(dp1,-1);
        int dp2[]=new int[n-1];
        Arrays.fill(dp2,-1);
        int ans1=recurr(n-2,startinclude,dp1);
        int ans2=recurr(n-2,startexclude,dp2);
        return Math.max(ans1,ans2);
    }
}