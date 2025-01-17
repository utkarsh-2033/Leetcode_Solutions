class Solution {
    public int findMin(int[] nums) {
        int high,low,n,mid;
        int ans=Integer.MAX_VALUE;
        n=nums.length;low=0;high=n-1;
        while(low<=high){
            mid=(low+high)/2;
            //no rotation , whole array is sorted
            //lefmost in array will be the minimum
            if(nums[low]<=nums[high]){
                ans=Math.min(ans,nums[low]);
                break;
            }
            //if left part is sorted
            if(nums[mid]>=nums[low]) {
                ans=Math.min(ans,nums[low]);
                low=mid+1;
            }
            else{
                ans=Math.min(nums[mid],ans);
                high=mid-1;
            }
        }
        return ans;
    }
}