class Solution {
    private void dfs(int node , boolean visited[], int dist[] , int edges[]){
        visited[node]=true;
        int v=edges[node];
        if(v!=-1 && !visited[v]){
            dist[v]=1+dist[node];
            dfs(v,visited,dist,edges);
        }
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n=edges.length;
        boolean visit1[]=new boolean[n];
        int dist1[]=new int[n];
        Arrays.fill(dist1,Integer.MAX_VALUE);
        dist1[node1]=0;
        boolean visit2[]=new boolean[n];
        int dist2[]=new int[n];
        Arrays.fill(dist2,Integer.MAX_VALUE);
        dist2[node2]=0;
        dfs(node1,visit1,dist1,edges);
        dfs(node2,visit2,dist2,edges);
        int ans=-1;
        int minDistTillNow = Integer.MAX_VALUE;

        for(int i=0;i<n;i++) {
            if(dist1[i]!=Integer.MAX_VALUE && dist2[i]!=Integer.MAX_VALUE) {
                int maxDist=Math.max(dist1[i],dist2[i]);
                if(maxDist < minDistTillNow){
                    minDistTillNow = maxDist;
                    ans = i;
                }
            }
        }
        return ans;
    }
}