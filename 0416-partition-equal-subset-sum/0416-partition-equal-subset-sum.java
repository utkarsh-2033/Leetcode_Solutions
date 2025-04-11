public class Solution {
    public boolean partition(int[] nums, int idx, int target) {
        if (target == 0) return true;  // base case-  subset found
        if (idx < 0 || target < 0) return false;

        // Include or exclude the current number
        return partition(nums, idx - 1, target - nums[idx]) ||
               partition(nums, idx - 1, target);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        return partition(nums, nums.length - 1, target);
    }
}
