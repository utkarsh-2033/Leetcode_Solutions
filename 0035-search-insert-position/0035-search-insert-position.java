class Solution {
    public int searchInsert(int[] nums, int target) {
        //lower bound=insert position for an
        //            element so that the array remains sorted
        int low=0,high=nums.length-1;
        int ans=nums.length;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]>=target){
                ans=mid;
                high=mid-1;
            }else low=mid+1;
        }
        return ans;
    }
}