class Solution {
    //dfs in adjacency matrix
    public void dfs(int[][] adj,int node,boolean visited[]){
        visited[node]=true;
        //going across the row of node to find its neighbours in adjacency matrix
        for(int i=0;i<adj.length;i++){
            if(adj[node][i]==1){
                if(!visited[i]) dfs(adj,i,visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) { //adjacency matrix
        boolean visited[]=new boolean[isConnected.length];
        int cnt=0;
        for(int i=0;i<isConnected.length;i++){
            if(!visited[i]){
                dfs(isConnected,i,visited);
                cnt++;
            }
        }
        return cnt;
    }
}