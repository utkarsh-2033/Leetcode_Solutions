class Solution {
    public boolean search(int[] nums, int target) {
        int high,low,mid,n;
        n=nums.length;high=n-1;low=0;
        while(low<=high){
            mid=(low+high)/2;
            if(target==nums[mid]) return true;
            if(nums[mid]==nums[low] && nums[high]==nums[low]){
                low++; high--; continue;
            }
            if(nums[low]<=nums[mid]){
                if(target>=nums[low] && target<=nums[mid]) high=mid-1;
                else low=mid+1;
            }
            else {
                if(target>=nums[mid] && target<=nums[high]) low=mid+1;
                else high=mid-1;
            }
        }
        return false;
    }
}