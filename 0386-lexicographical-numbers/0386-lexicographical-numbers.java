class Solution {
    private void solve(int num,ArrayList<Integer> ans,int n){
        if(num>n) return;
        ans.add(num);
        for(int i=0;i<10;i++){
            solve(num*10+i,ans,n);
        }
    }
    public List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=1;i<=Math.min(n,9);i++){
            solve(i,ans,n);
        }
        return ans;
    }
}