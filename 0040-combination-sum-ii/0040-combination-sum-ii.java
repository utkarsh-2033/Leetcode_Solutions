class Solution {
    public void recurr(int i,int sum,int[] candidates, int target
    ,List<Integer> current ,List<List<Integer>> ans){
        if(sum==target) {
            ans.add(new ArrayList<>(current));
            return;
            }
        if(sum>target) return;
        if(i==candidates.length) return;
        current.add(candidates[i]);
        recurr(i+1,sum+candidates[i],candidates,target,current,ans);
        current.remove(current.size()-1);
        while(i<candidates.length-1 && candidates[i]==candidates[i+1]) i++;
        recurr(i+1,sum,candidates,target,current,ans);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        Arrays.sort(candidates);
        recurr(0,0,candidates,target,current,ans);
        return ans;
    }
}