class Solution {
    // private boolean f(int idx,int target,int arr[],int dp[][]){
    //     if(target==0) return true;
    //     if(idx==0) return arr[0]==target;
    //     if(dp[idx][target]!=-1) return (dp[idx][target]==0)? false : true;
    //     boolean nottake=f(idx-1,target,arr,dp);
    //     boolean take=false;
    //     if(arr[idx]<=target) take=f(idx-1,target-arr[idx],arr,dp);
    //     dp[idx][target]=(take||nottake)?1:0;
    //     return take||nottake;
    // }
    static Boolean isSubsetSum(int arr[], int sum) {
        int n=arr.length;
        boolean prev[]=new boolean[sum+1];
        prev[0]=true; //first col
        if(arr[0]<=sum) prev[arr[0]]=true;   //1st row 
        for(int idx=1;idx<n;idx++){
            boolean curr[]=new boolean[sum+1];
            curr[0]=true;
            for(int target=1;target<=sum;target++){
                boolean nottake=prev[target];
                boolean take=false;
                if(arr[idx]<=target) take=prev[target-arr[idx]];
                curr[target]=take||nottake;
            }
            prev=curr;
        }
        return prev[sum];
    }

    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i:nums) sum+=i;
        if(sum%2!=0) return false; // if sum is odd , can not be divided into 2 eqaul sum
        
        return isSubsetSum(nums,sum/2);
    }
}