class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int[][] ans = new int[n/3][3];
        int idx = 0;
        for (int i = 0; i <= n - 3; i += 3) {
            if (nums[i + 2] - nums[i] > k) {
                return new int[0][0];
            }
            ans[idx++] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
        }
        return ans;
    }
}