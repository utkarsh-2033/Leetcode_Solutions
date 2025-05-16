class Solution {
    class tuple{
        int row,col,time;
        tuple(int row,int col,int time){
            this.row=row;this.col=col;this.time=time;
        }
    }
    //bfs because simultaneous rotting from all 2s across 4 dirc at a time
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<tuple> q=new LinkedList<>();
        //putting initial all rotten oranges to start traversal with
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2) q.offer(new tuple(i,j,0));
            }
        }
        //to traverse in the 4 dircns
        int[] delrow={-1,0,1,0};
        int[] delcol={0,-1,0,1};
        int time=0;
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            int t=q.peek().time;
            q.poll();
            time=Math.max(time,t);
            for(int i=0;i<4;i++){
                int nrow=row+delrow[i];
                int ncol=col+delcol[i];
                if(nrow>=0 && nrow<m && ncol>=0 && ncol<n && grid[nrow][ncol]==1){
                    grid[nrow][ncol]=2; //mark of visited (rotten)
                    q.offer(new tuple(nrow,ncol,t+1));
                }
            }
        }
        //checking if all fresh oranges are rotten or not
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) return -1;
            }
        }
        return time;
    }
}