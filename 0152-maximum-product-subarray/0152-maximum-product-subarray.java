class Solution {
    public int maxProduct(int[] nums) {
        // kadane's algo-extended
        int maxProduct=nums[0];
        int minProduct=nums[0]; // tracking this coz-> (-)*(-)=(+)
        int ans=nums[0];
        for(int i=1;i<nums.length;i++){
            int t=Math.max(nums[i],Math.max(minProduct*nums[i],maxProduct*nums[i]));
            minProduct=Math.min(nums[i],Math.min(minProduct*nums[i],maxProduct*nums[i]));
            maxProduct=t;

            ans=Math.max(Math.max(maxProduct,minProduct),ans);
        }
        return ans;
    }
}