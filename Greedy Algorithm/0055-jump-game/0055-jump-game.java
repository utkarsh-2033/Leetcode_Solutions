class Solution {
    public boolean canJump(int[] nums) {
        int maxReach=0;//to track max posn that can be reached from each index;
        for(int i=0;i<nums.length;i++){
            if(i>maxReach) return false;
            maxReach=Math.max(maxReach,i+nums[i]);
        }
        return true;
    }
}