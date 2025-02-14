class Solution {
    public boolean dfs(int[][] graph, int node,int[] visited,int color){
        visited[node]=color;
        //traversing neighbours
        for(int adj:graph[node]){
            if(visited[adj]==-1){ 
                if(!dfs(graph,adj,visited, (color==0)?1:0)) return false;
            }
            else if(visited[adj]==color) return false;
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) { //given adj list in 2d array form
        int m=graph.length;
        int visited[]=new int[m];
        for(int i=0;i<m;i++) visited[i]=-1; //marking -1 at each posn initially
        //for connected components
        for(int i=0;i<m;i++){
            if(visited[i]==-1){
                if(!dfs(graph, i , visited ,0)) return false;
            }
        }
        return true;
    }
}