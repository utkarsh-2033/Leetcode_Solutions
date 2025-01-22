class Solution {
    // calculating sum - dividing each num by divisor and adding
    public int sum(int nums[],int divisor){
        int s=0;
        for(int i:nums){
            s+=Math.ceil((double)i/(double)divisor);
        }
        return s;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        //BS on answes
        //range 1 to max
        int low=1,high=0;
        for(int i:nums) high=Math.max(high,i);
        while(low<=high){
            int mid=low+(high-low)/2;
            if(sum(nums,mid)<=threshold) high=mid-1; // for minimum divisor
            else low=mid+1;
        }
        return low;
    }
}