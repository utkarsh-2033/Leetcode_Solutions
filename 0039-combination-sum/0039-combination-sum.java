class Solution {
    public void createComb(int arr[],int idx,int target,int s,
    List<List<Integer>> ans,List<Integer> current){
        if(s==target){
            ans.add(new ArrayList<>(current));
            return;
        }
        if(idx==arr.length ||  s>target){
            return;
        }
        current.add(arr[idx]);
        createComb(arr,idx,target,s+arr[idx],ans,current);
        current.remove(current.size()-1);
        createComb(arr,idx+1,target,s,ans,current);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        createComb(candidates,0,target,0,ans,current);
        return ans;
    }
}