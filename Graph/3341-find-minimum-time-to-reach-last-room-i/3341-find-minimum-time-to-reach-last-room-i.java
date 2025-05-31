class tuple{
    int r;
    int c;
    int t;
    tuple(int r,int c,int t){
        this.r=r;this.c=c;this.t=t;
    }
}
class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n=moveTime.length;
        int m=moveTime[0].length;
        int dist[][]=new int[moveTime.length][moveTime[0].length];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) dist[i][j]=Integer.MAX_VALUE;
        }
        int delc[]={1,0,0,-1};
        int delr[]={0,1,-1,0};
        PriorityQueue<tuple> pq=new PriorityQueue<>((a,b)->a.t-b.t);
        pq.offer(new tuple(0,0,0));
        dist[0][0]=0;
        while(!pq.isEmpty()){
            tuple curr=pq.poll();
            int r=curr.r;
            int c=curr.c;
            int t=curr.t;
            for(int i=0;i<4;i++){
                if(r+delr[i]>=0 && c+delc[i]>=0 && r+delr[i]<n && c+delc[i]<m ){
                    int wt=(moveTime[r+delr[i]][c+delc[i]]-t)>=0?moveTime[r+delr[i]][c+delc[i]]-t:0;
                    if(dist[r+delr[i]][c+delc[i]]>dist[r][c]+wt+1){
                        dist[r+delr[i]][c+delc[i]]=dist[r][c]+wt+1;
                        pq.offer(new tuple(r+delr[i],c+delc[i],dist[r+delr[i]][c+delc[i]]));
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }
}