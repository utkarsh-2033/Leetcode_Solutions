class Solution {
    public void dfs(int node,List<List<Integer>> ans,
    ArrayList<Integer> curr,int [][]graph){
        curr.add(node);
        if(node==graph.length-1){
            ans.add(new ArrayList<>(curr));
            curr.remove(curr.size()-1);
            return;
        }
        for(int i:graph[node]){
            dfs(i,ans,curr,graph);
        }
        curr.remove(curr.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans=new ArrayList<>();
        dfs(0,ans,new ArrayList<>(),graph);
        return ans;
    }
}