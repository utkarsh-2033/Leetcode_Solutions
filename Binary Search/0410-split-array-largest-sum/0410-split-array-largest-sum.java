class Solution {
    public int noOfSubarrays(int arr[],int maxsum){
        int subarrays=0,sum=0;
        for(int i:arr){
            sum+=i;
            if(sum>maxsum){
                subarrays++;
                sum=i;
            }
        }
        if(sum<=maxsum) subarrays++;
        return subarrays;
    }
    public int splitArray(int[] nums, int k) {
        //min of max-BS
        //range- max to totalsum
        int low=0,high=0;
        for(int i:nums){
            low=Math.max(low,i);
            high+=i;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            int subarrays=noOfSubarrays(nums,mid);
            if(subarrays<=k) high=mid-1;
            else low=mid+1; 
        }
        return low;
    }
}