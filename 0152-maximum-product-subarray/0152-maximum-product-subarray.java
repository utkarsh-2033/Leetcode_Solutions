class Solution {
    public int maxProduct(int[] nums) {
        int pre=1,suff=1;
        int max=nums[0];
        for(int i=0;i<nums.length;i++){
            if(pre==0) pre=1;
            if(suff==0) suff=1;
            pre*=nums[i];
            suff*=nums[nums.length-1-i];
            max=Math.max(max,Math.max(pre,suff));
        }
        return max;
    }
}