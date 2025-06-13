class Solution {
    int n;

    private boolean isValid(int[] nums, int mid, int p) {
        int i = 0;
        int pairs=0;
        while(i<n - 1){
            if(nums[i+1]-nums[i] <= mid){
                pairs++;
                i += 2;
            } else i++;
        }
        return pairs>=p;
    }

    public int minimizeMax(int[] nums, int p) {
        n = nums.length;
        Arrays.sort(nums);
        int low = 0;
        int high = nums[n-1];
        while(low<=high){
            int mid=low+(high-low)/2;
            if (isValid(nums,mid,p))  high=mid-1;
            else low=mid+1;
        }
        return low;
    }
}