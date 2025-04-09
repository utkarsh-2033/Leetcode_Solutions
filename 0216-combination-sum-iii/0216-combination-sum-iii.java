class Solution {
    public void recurr(int idx,int k ,int target,List<List<Integer>> ans,
    List<Integer> current ){
            if(k<0 || target<0) return;
        if(k==0 && target==0){
        ans.add(new ArrayList<>(current)); return;
        }
        for(int i = idx;i<=9;i++){
            current.add(i);
            recurr(i+1,k-1,target-i,ans,current);
            current.remove(current.size()-1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> current =new ArrayList<>();
        recurr(1,k,n,ans,current);
        return ans;
    }
}