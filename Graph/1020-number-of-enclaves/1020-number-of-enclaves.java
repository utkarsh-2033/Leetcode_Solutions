class Solution {
    public void dfs(int[][] grid,int row,int col,int delrow[],int delcol[]){
        grid[row][col]=0; //marking lands as 0 which can be visited(no external visited arr)
        //neighbours- 4 dircns
        for(int i=0;i<4;i++){
            int nr=row+delrow[i];
            int nc=col+delcol[i];
            if(nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc]==1){
                dfs(grid,nr,nc,delrow,delcol);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int[] delrow={-1,0,1,0};
        int[] delcol={0,-1,0,1};
        int m=grid.length;
        int n=grid[0].length;
        //for 1st and last row
        for(int i=0;i<n;i++){
            if(grid[0][i]==1) dfs(grid,0,i,delrow,delcol);
            if(grid[m-1][i]==1) dfs(grid,n-1,i,delrow,delcol);
        }
        //1st col and last col
        for(int i=0;i<m;i++){
            if(grid[i][0]==1) dfs(grid,i,0,delrow,delcol);
            if(grid[i][n-1]==1) dfs(grid,i,m-1,delrow,delcol);
        }
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) cnt++;
            }
        }
        return cnt;
    }
}