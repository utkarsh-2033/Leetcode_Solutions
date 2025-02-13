class Solution {
    public int sum(int mid,int[] nums){
        int sum=0;{
            for(int num:nums) sum+=Math.ceil(((double)num/mid));
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high=Integer.MIN_VALUE;
        for(int i:nums){
            high=Math.max(i,high);
        }
        int ans=-1;
        while(low<=high){
            int mid=((low+high)/2);
            if(sum(mid,nums)<=threshold){
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
}