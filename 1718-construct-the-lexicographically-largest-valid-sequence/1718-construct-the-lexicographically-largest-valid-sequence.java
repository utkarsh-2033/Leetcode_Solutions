class Solution {
    public boolean helper(int idx,int n,boolean used[],int ans[]){
        if(idx==ans.length) return true;
        if(ans[idx]!=0) return helper(idx+1,n,used,ans);
        for(int i=n;i>0;i--){
            if(used[i]) continue;
            if(i==1){
                ans[idx]=i;
                used[i]=true;
                if(helper(idx+1,n,used,ans)) return true;
                used[i]=false;
                ans[idx]=0;
            }else{
                if(idx+i>=ans.length || ans[idx+i]!=0) continue;
                ans[idx]=i;
                ans[idx+i]=i;
                used[i]=true;
                if(helper(idx+1,n,used,ans)) return true;
                used[i]=false;
                ans[idx]=0;
                ans[idx+i]=0;
            }
        }
        return false;
    }
    public int[] constructDistancedSequence(int n) {
        boolean used[]=new boolean[n+1];
        int ans[]=new int[2*n-1]; // 1-once , rest twice
        helper(0,n,used,ans);
        return ans;
    }
}