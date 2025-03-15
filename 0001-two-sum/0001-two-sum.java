class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        int ans[] = new int[2];
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i <n; i++) {
            int k=target-nums[i];
            if (hm.containsKey(k)) {
                ans[0] = i;
                ans[1] = hm.get(k);
                break;
            }
            else hm.put(nums[i],i);
        }
        return ans;
    }
}