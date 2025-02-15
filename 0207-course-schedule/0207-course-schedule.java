class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) { //numcourses=V //prerequisites=edges arr
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        Queue<Integer> q =new LinkedList<>();
        ArrayList<Integer> topo=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int indeg[]=new int[numCourses];
        //creating graph -adjacency matrix
        for(int it[]:prerequisites){
            int v=it[0];
            int u=it[1];
            adj.get(u).add(v); // directed
            indeg[v]++; //creating indegree array
        }
        //inserting vertices with 0 indeg
        for(int i=0;i<numCourses;i++){
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
        return topo.size()==numCourses;
    }
}