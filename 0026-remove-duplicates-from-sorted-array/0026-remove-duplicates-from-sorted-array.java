class Solution {
    public int removeDuplicates(int[] nums) {
        int i=1;//to track where the next number should be after avoiding duplcates
       for(int j=1;j<nums.length;j++){
        if(nums[j]==nums[j-1]) continue; // avoiding duplicates like in 3sum
        nums[i++]=nums[j];
       }
       return i;
    }
}