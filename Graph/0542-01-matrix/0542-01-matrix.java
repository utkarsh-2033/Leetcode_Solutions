class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int visited[][]=new int[m][n];
        Queue<int[]> q=new LinkedList<>(); //{r,c,steps}
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){ 
                    q.offer(new int[]{i,j,0});
                    visited[i][j]=1;
                }
            }
        }
        int delrow[]={-1,0,1,0};
        int delcol[]={0,-1,0,1};
        while(!q.isEmpty()){
            int[] k=q.poll();
            int r=k[0];
            int c=k[1];
            int steps=k[2];
            mat[r][c]=steps;
            for(int i=0;i<4;i++){
                int nr=r+delrow[i];
                int nc=c+delcol[i];
                if(nr>=0 && nc>=0 && nr<m && nc<n && visited[nr][nc]==0){
                    q.offer(new int[]{nr,nc,steps+1});
                    visited[nr][nc]=1;
                }
            }
        }
        return mat;
    }
}