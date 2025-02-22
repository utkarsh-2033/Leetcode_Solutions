class Solution {
    int mod= 1000000007;
    public int countPaths(int n, int[][] roads) {
        //creating graph 
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int edge[]:roads){
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];
            adj.get(u).add(new int[]{v,wt});
            adj.get(v).add(new int[]{u,wt});
        }
        //distance array
        long dist[]=new long[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        //ways array
        int ways[]=new int[n];
        ways[0]=1;
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));//{dist,node}
        pq.offer(new long[]{0,0});
        while(!pq.isEmpty()){
            long p[]=pq.poll();
            int node=(int)p[1];
            long d=p[0];
            if(d>dist[node]) continue;
            for(int adjNode[]:adj.get(node)){
                int neighbour=adjNode[0];
                int wt=adjNode[1];
                if(dist[node]+(long)wt<dist[neighbour]){
                    dist[neighbour]=dist[node]+wt;
                    ways[neighbour]=ways[node]; // reset ways
                    pq.offer(new long[]{dist[node]+wt,neighbour});
                }else if(dist[node]+(long)wt==dist[neighbour]){
                    ways[neighbour]=(ways[node]+ways[neighbour])%mod;
                }
            }
        }
        return ways[n-1];
    }
}