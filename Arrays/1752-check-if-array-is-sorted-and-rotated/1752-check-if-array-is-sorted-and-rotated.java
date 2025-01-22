class Solution {
    public boolean check(int[] nums) {
        int count=0;
        int i;
        for( i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1])
               count++;
        }
        if(nums[i]>nums[0]) count++;
        if(count<=1) return true;
        else return false;
    }
}