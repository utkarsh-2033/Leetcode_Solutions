class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V =graph.length;
        ArrayList<Integer> topo=new ArrayList<>(); //to store topo order 
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        int indeg[]=new int[V];
        //creating graph by reversing nodes
        for(int i=0;i<V;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(graph[i][j]).add(i); //reversed
                indeg[i]++;  //creating indegree array of vertices
            }
        }
        Queue<Integer> q=new LinkedList<>();
        //inserting initially vertices with indegree 0
        for(int i=0;i<V;i++){
            if(indeg[i]==0) q.offer(i); 
        }
        while(!q.isEmpty()){
            int node=q.poll();
            topo.add(node);
            for(int adjele:adj.get(node)){
                indeg[adjele]--;
                if(indeg[adjele]==0) q.offer(adjele);
            }
        }
         Collections.sort(topo);
         return topo;
    }
}