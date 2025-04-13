public class Solution {
    public boolean partition(int[] nums, int idx, int target,Boolean dp[][]) {
        if (target == 0) return true;  // base case-  subset found
        if (idx < 0 || target < 0) return false;
        if (dp[idx][target] != null) return dp[idx][target];

        boolean include = partition(nums, idx - 1, target - nums[idx], dp);
        boolean exclude = partition(nums, idx - 1, target, dp);

        return dp[idx][target] = include || exclude;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int n = nums.length;
        Boolean[][] dp = new Boolean[n][target + 1];
        return partition(nums, n - 1, target, dp);
    }
}
