class Solution {
    private boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,
    boolean visited[],boolean path[],int col[],int mx[],String s){
        visited[node]=true;
        path[node]=true;
        col[s.charAt(node)-'a']++;
        for(int adjele:adj.get(node)){
            if(!visited[adjele]){ 
                if(dfs(adjele,adj,visited,path,col,mx,s)) return true;;
            }
            else if(path[adjele]) return true;
        }
        for(int i:col) mx[0]=Math.max(mx[0],i);
        path[node]=false;
        visited[node]=false;
        col[s.charAt(node)-'a']--;
        return false;
    }
    public int largestPathValue(String colors, int[][] edges) {
        int n=colors.length();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        boolean visited[]=new boolean[n];
        boolean path[]=new boolean[n];
        int col[]=new int[26];
        int mx[]={0};
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v); //directed edge
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                if(dfs(i,adj,visited,path,col,mx,colors)) return -1;
            }
        }
        return mx[0];
    }
}