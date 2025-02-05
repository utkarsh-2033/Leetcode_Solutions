class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums); //nlogn
        for(int i=1;i<nums.length;i=i+3){ //n/3
            if(nums[i-1]!=nums[i]) return nums[i-1];
        }
        return nums[nums.length-1];
    }

}