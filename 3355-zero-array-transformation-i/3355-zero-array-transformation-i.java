class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] allowed = new int[n + 1];  // one extra for easier prefix handling
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            allowed[l] += 1;
            if (r + 1 < n) {
                allowed[r + 1] -= 1;
            }
        }
        for (int i = 1; i < n; i++) {
            allowed[i] += allowed[i - 1];
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > allowed[i]) return false;
        }
        return true;
    }
}