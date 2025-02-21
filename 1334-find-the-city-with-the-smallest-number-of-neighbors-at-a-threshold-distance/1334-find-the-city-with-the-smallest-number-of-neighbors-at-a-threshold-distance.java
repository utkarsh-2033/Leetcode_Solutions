class Solution {
    private int dijsktra(ArrayList<ArrayList<int[]>> adj, int src,int n ,int t){
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]); //{dist,node}
        pq.offer(new int[]{0,src});
        while(!pq.isEmpty()){
            int p[]=pq.poll();
            int d=p[0];
            int u=p[1];
            if(d>dist[u]) continue;
            for(int adjele[]:adj.get(u)){
                int wt=adjele[1];
                int v=adjele[0];
                if(dist[u]+wt<dist[v]){
                    dist[v]=dist[u]+wt;
                    pq.offer(new int[]{dist[v],v});
                }
            }
        }
        int c=0;
        //Counting only cities where dist ≤ t and skiping source
            for (int i = 0; i < n; i++) {
            if (i != src && dist[i] <= t) {
                c++;
            }
        }
            return c;
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<ArrayList<int[]>> adj =new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int edge[]:edges){
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];
            adj.get(u).add(new int[]{v,wt});
            adj.get(v).add(new int[]{u,wt});
        }
        int minCitycount=Integer.MAX_VALUE;
        int ans=-1;
        for(int i=0;i<n;i++){
            int city=dijsktra(adj,i,n,distanceThreshold);
            if(minCitycount>=city){
                minCitycount=city;
                ans=i;
            }
        }
        return ans;
    }
}