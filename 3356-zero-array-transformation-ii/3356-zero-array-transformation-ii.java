class Solution {
    private boolean isPossible(int k, int[] nums, int[][] queries){
        int n=nums.length;
        int diff[]=new int[n+1]; //storing toal val that can be decremented at any idx i in nums
        for(int i=0;i<=k;i++){
            int q[]=queries[i];
            int l=q[0];
            int r=q[1];
            int val=q[2];
            diff[l]+=val;
            diff[r+1]-=val;
        }
        for(int i=1;i<n+1;i++){
            diff[i]+=diff[i-1];
        }
        for(int i=0;i<n;i++){
            if(nums[i]>diff[i]) return false;
        }
        return true;
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        boolean all0=true;
        for(int i:nums){
            if(i!=0) all0=false;
        }
        if(all0) return 0;
        //BS on answers - range - 0 to queries.length-1
        int low=0;
        int high=queries.length-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(mid,nums,queries)){ high=mid-1; ans=mid+1;}
            else low=mid+1;
        }
        return ans;
    }
}