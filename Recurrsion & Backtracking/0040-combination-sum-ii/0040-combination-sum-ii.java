class Solution {
    public void createComb(int arr[], int idx, int target, List<List<Integer>> ans, List<Integer> current) {
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1])
                continue; // avoiding duplicates from the current posn onwards
            if (arr[idx] > target)
                break;
            current.add(arr[i]);
            createComb(arr, i + 1, target - arr[i], ans, current);
            current.remove(current.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates); 
        createComb(candidates, 0, target, ans, current);
        return ans;
    }
}