class Solution {
    public int removeDuplicates(int[] nums) {
        int j=2;
        for(int i=2;i<nums.length;i++){
            if(nums[j-2]==nums[i]) continue;
            nums[j++]=nums[i];
        }
        return j;
    }
}