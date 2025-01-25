class Solution {
    public void generateSubsets(int arr[], int idx, List<List<Integer>> ans, List<Integer> current) {
        if(idx==arr.length){
            ans.add(new ArrayList<>(current));
            return ;
        }
        current.add(arr[idx]);
        generateSubsets(arr,idx+1,ans,current);
        current.remove(current.size()-1);
        generateSubsets(arr,idx+1,ans,current);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        //List<List<Integer>>- reference type
        //generateSubsets  modifies ans in place
        generateSubsets(nums, 0, ans, current);
        return ans;
    }
}