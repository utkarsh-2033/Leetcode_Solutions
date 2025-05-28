class Solution {
    private int nodesWithinDist(int src,ArrayList<ArrayList<Integer>> adj,
    int n,int k){
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{src,0});
        dist[src]=0;
        while(!q.isEmpty()){
            int curr[]=q.poll();
            int u=curr[0];
            int d=curr[1];
            if(d>dist[u]) continue;
            for(int v:adj.get(u)){
                if(dist[u]+1<dist[v]){
                    dist[v]=dist[u]+1;
                    q.offer(new int[]{v,dist[v]});
                }
            }
        }
        int cnt=0;
        for(int i:dist){
            if(i<=k) cnt++;
        }
        return cnt;
    }
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n=edges1.length+1;
        int m=edges2.length+1;
        ArrayList<ArrayList<Integer>> tree1=new ArrayList<>();
        for(int i=0;i<n;i++) tree1.add(new ArrayList<>());
        ArrayList<ArrayList<Integer>> tree2=new ArrayList<>();
        for(int i=0;i<m;i++) tree2.add(new ArrayList<>());
        for(int i[]:edges1){
            tree1.get(i[0]).add(i[1]);
            tree1.get(i[1]).add(i[0]);
        }
        for(int i[]:edges2){
            tree2.get(i[0]).add(i[1]);
            tree2.get(i[1]).add(i[0]);
        }
        int reachtree2[]=new int[m];
        for(int i=0;i<m;i++){
            reachtree2[i]=nodesWithinDist(i,tree2,m,k-1);
        }
        int reachtree1[]=new int[n];
        for(int i=0;i<n;i++){
            reachtree1[i]=nodesWithinDist(i,tree1,n,k);
        }
        int ans[]=new int[n];
        //first counting target nodes from 2 - 
        //making connecting with node that maximizes target nodes
        int best2 = 0;
        // Since the best count2[j] is independent of i, precompute its max:
        for (int j = 0; j < m; j++) {
            best2 = Math.max(best2, reachtree2[j]);
        }
        for (int i = 0; i < n; i++) {
            // reach all in T1 within k + best possible from T2
            ans[i] = reachtree1[i] + best2;
        }
        return ans;
    }
}