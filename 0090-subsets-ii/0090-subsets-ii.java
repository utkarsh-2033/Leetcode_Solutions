class Solution {
    public void createSubsets(int arr[], int idx, List<List<Integer>> ans,
            List<Integer> current) {
        ans.add(new ArrayList<>(current));
        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1])
                continue;
            current.add(arr[i]);
            createSubsets(arr, i + 1, ans, current);
            current.remove(current.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        createSubsets(nums, 0, ans, current);
        return ans;
    }
}