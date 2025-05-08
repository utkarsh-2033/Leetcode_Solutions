class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n=moveTime.length;
        int m=moveTime[0].length;
        int dr[]={0,1,0,-1};
        int dc[]={1,0,-1,0};
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int dist[][]=new int[n][m];
        for(int row[]:dist) Arrays.fill(row,Integer.MAX_VALUE);
        dist[0][0]=0;
        pq.offer(new int[]{0,0,0,0}); //{time,row,col}
        while(!pq.isEmpty()){
            int curr[]=pq.poll();
            int r=curr[1];
            int c=curr[2];
            int t=curr[0];
            int cc=curr[3];
            if(cc==0) cc=1;
            else cc=2;
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(t>dist[r][c]) continue;
                if(nr>=0 && nc>=0 && nr<n && nc<m){
                    int wt=(moveTime[nr][nc]-t)>=0?moveTime[nr][nc]-t:0;
                    if(dist[nr][nc]>dist[r][c]+wt+cc){
                        dist[nr][nc]=dist[r][c]+wt+cc;
                        int k=(cc==1)?1:0;
                        pq.offer(new int[]{dist[nr][nc],nr,nc,k});
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }
}