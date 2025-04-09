class Solution {
    public void createSubsets(int arr[], int idx, List<List<Integer>> ans,
            List<Integer> current) {
        if(idx==arr.length){
        ans.add(new ArrayList<>(current));
        return;
        }
        
        current.add(arr[idx]);
        createSubsets(arr, idx + 1, ans, current);
        current.remove(current.size() - 1);
        while(idx<arr.length-1 && arr[idx]==arr[idx+1]) idx++;
        createSubsets(arr, idx + 1, ans, current);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        createSubsets(nums, 0, ans, current);
        return ans;
    }
}