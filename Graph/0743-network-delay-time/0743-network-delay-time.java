class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //creating directed graph
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n+1;i++) adj.add(new ArrayList<>());
        for(int edge[]:times){
            int u=edge[0];
            int v=edge[1];
            int time=edge[2];
            adj.get(u).add(new int[]{v,time});   //{node,time}
        }
        //dijasktra
        int dist[]=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,k});
        while(!pq.isEmpty()){
            int p[]=pq.poll();
            int t=p[0];
            int u=p[1];
            if(t>dist[u]) continue;
            for(int adjele[]:adj.get(u)){
                int v=adjele[0];
                int wt=adjele[1];
                if(dist[u]+wt<dist[v]){
                    dist[v]=dist[u]+wt;
                    pq.offer(new int[]{dist[u]+wt,v});
                }
            }
        }
        //since propogation is simultaneous - level wise 
        //time to reach last level is the total time took
        int mx=-1;
        for(int i=1;i<dist.length;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            mx=Math.max(dist[i],mx);
        }
        return mx;
    }
}