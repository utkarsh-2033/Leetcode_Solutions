class Solution {
    public void createComb(int st,int k, int target, List<List<Integer>> ans, List<Integer> current) {
        if (k==0 && target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int i = st; i < 10 && k>0; i++) {
            if (i > target)
                break;
            current.add(i);
            createComb( i + 1,k-1, target - i, ans, current);
            current.remove(current.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        createComb(1,k, n, ans, current);
        return ans;
    }
}