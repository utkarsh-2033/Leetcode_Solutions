class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        for(int i =0;i<numRows;i++){
            ArrayList<Integer> t=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i) t.add(1);
                else t.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
            }
            ans.add(t);
        }
        return ans;
    }
}