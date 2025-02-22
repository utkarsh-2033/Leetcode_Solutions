class Solution {
    //djisktra algo
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1) return -1;
        int m=grid.length;
        int dist[][]=new int[m][m];
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        dist[0][0]=0;
        //queue works bcox distance increases by 1 , so ele is popped in increasing order only
        Queue<int[]> q=new LinkedList<>(); //{steps,r,c}
        q.offer(new int[]{0,0,0});
        while(!q.isEmpty()){
            int[] t=q.poll();
            int steps=t[0];
            int r=t[1];
            int c=t[2];
            if(steps>dist[r][c]) continue;
            if(r==m-1 && c==m-1) return steps+1;
            //travelling in all 8 possible dircns
            for(int i=-1;i<2;i++){
                for(int j=-1;j<2;j++){
                    int nr=r+i;
                    int nc=c+j;
                    if(nr>=0 && nc>=0 && nr<m && nc<m && grid[nr][nc]==0){
                        if((steps+1)<dist[nr][nc]){
                            dist[nr][nc]=steps+1;
                            q.offer(new int[]{steps+1,nr,nc});
                        }
                    }
                }
            }
        }
        return -1;
    }
}