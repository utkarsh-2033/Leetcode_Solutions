class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //creating graph(directed weighted)
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] edge: flights){
            int u=edge[0];
            int v=edge[1];
            int cost=edge[2];
            adj.get(u).add(new int[]{v,cost});
        }
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        Queue<int[]> q=new LinkedList<>(); //{stops,city,cost}
        q.offer(new int[]{0,src,0});
        while(!q.isEmpty()){
            int[] p=q.poll();
            int stops=p[0];
            int from=p[1];
            int cost=p[2];
            if(stops>k) continue;
            for(int adjele[]:adj.get(from)){
                int to=adjele[0];
                int wt=adjele[1];
                if(cost+wt<dist[to]){
                    dist[to]=cost+wt;
                    q.offer(new int[]{stops+1,to,cost+wt});
                }
            }
        }
        return (dist[dst]==Integer.MAX_VALUE)?-1:dist[dst];
    }
}