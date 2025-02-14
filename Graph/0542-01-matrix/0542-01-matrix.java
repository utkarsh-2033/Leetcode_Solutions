class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int visited[][]=new int[m][n];
        Queue<int[]> q=new LinkedList<>(); //int[]= {row,col,distance}
        //inserting the initial Os 
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){ 
                    q.offer(new int[]{i,j,0});// distace of 0 from 0=0
                    visited[i][j]=1;
                    }
            }
        }
        int delrow[]={-1,0,1,0};
        int delcol[]={0,-1,0,1};
        while(!q.isEmpty()){
            int r=q.peek()[0];
            int c=q.peek()[1];
            int dist=q.peek()[2];
            q.poll();
            mat[r][c]=dist;      // marking the distance in the same input matrix
            //traversing the 4 dircns
            for(int i=0;i<4;i++){
                int nr=r+delrow[i];
                int nc=c+delcol[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n 
                && mat[nr][nc]==1 
                && visited[nr][nc]==0){
                    q.offer(new int[]{nr,nc,dist+1});
                    visited[nr][nc]=1;
                }
            }
        }
        return mat;
    }
}