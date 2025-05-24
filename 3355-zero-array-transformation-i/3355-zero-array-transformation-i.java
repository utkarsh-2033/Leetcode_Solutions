class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;
        int diff[]=new int[n+1];
        //applying diff array techniq to count max operation 
        //that can be performed at any idx i in nums
        for(int q[]:queries){
            int l=q[0];
            int r=q[1];
            diff[l]+=1;
            diff[r+1]-=1;
        }
        //finding ps 
        for(int i=1;i<n+1;i++){
            diff[i]+=diff[i-1];
        }
        //checking if total op that can be performed at any idx i less than the nums[i]- return false
        //each opertion - can decrement value by 1
        for(int i=0;i<n;i++){
            if(nums[i]>diff[i]) return false;
        }
        return true;
    }
}