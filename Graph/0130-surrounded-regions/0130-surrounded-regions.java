class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int visited[][]=new int[m][n];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0|| i==m-1 || j==0 || j==n-1) && board[i][j]=='O')
                q.offer(new int[]{i,j});
            }
        }
        int delr[]={1,0,-1,0};
        int delc[]={0,-1,0,1};
        while(!q.isEmpty()){
            int curr[]=q.poll();
            visited[curr[0]][curr[1]]=1;
            for(int i=0;i<4;i++){
                int r=delr[i]+curr[0];
                int c=delc[i]+curr[1];
                if(r>=0 && r<m && c>=0 && c<n && board[r][c]=='O' && visited[r][c]==0){
                    q.offer(new int[]{r,c});
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==0 && board[i][j]=='O')
                board[i][j]='X';
            }
        }
    }
}