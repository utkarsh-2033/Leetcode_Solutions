class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        int dist[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[0][0]=0;
        int[] delrow={-1,0,1,0};
        int[] delcol={0,-1,0,1};
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]); //{diff, row, col}
        pq.offer(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int []t=pq.poll();
            int mxeff=t[0];
            int r=t[1];
            int c=t[2];
            if(r==m-1&& c==n-1) return mxeff;
            for(int i=0;i<4;i++){
                int nr=r+delrow[i];
                int nc=c+delcol[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    int d=Math.abs(heights[r][c]-heights[nr][nc]);
                    if(Math.max(d,mxeff)<dist[nr][nc]){
                        dist[nr][nc]=Math.max(d,mxeff);
                        pq.offer(new int[]{Math.max(d,mxeff),nr,nc});
                    }
                }
            }
        }
        return 0;
    }
}