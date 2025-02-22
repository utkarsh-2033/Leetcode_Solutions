class Solution {
    public void dfs(int row,int col, char[][] board, 
    int[][] visited ,int[] delrow,int[] delcol,int m , int n){
        visited[row][col]=1;
        for(int i=0;i<4;i++){
            int nr=row+delrow[i];
            int nc=col+delcol[i];
            if(nr>=0 && nr<m && nc>=0 && nc<n && board[nr][nc]=='O'
             && visited[nr][nc]==0) dfs(nr,nc,board,visited,delrow,delcol,m,n);
        }

    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int visited[][]=new int[m][n];
        int delrow[]={-1,0,1,0};
        int delcol[]={0,-1,0,1};
    //boundary trversing of board
    
    for(int i=0;i<n;i++){
        if(board[0][i]=='O' && visited[0][i]==0) dfs(0,i,board,visited,delrow,delcol,m,n);
        if(board[m-1][i]=='O' && visited[m-1][i]==0) dfs(m-1,i,board,visited,delrow,delcol,m,n);
    }
    for(int i=0;i<m;i++){
        if(board[i][0]=='O' && visited[i][0]==0) dfs(i,0,board,visited,delrow,delcol,m,n);
        if(board[i][n-1]=='O' && visited[i][n-1]==0) dfs(i,n-1,board,visited,delrow,delcol,m,n);
    }
      for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            if(board[i][j] == 'O' && visited[i][j]==0) board[i][j]='X';
        }
      }

    }
}