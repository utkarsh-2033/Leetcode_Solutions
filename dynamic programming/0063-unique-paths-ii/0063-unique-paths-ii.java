class Solution {
    // int paths(int i,int j,int grid[][],int dp[][]){
    //     if(i<0 || j<0) return 0;
    //     if(grid[i][j]==1) return 0;
    //     if(i==0 && j==0) return 1;
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     int up=paths(i-1,j,grid,dp);
    //     int left=paths(i,j-1,grid,dp);
    //     return dp[i][j]=up+left;
    // }

    // tabulation + space optimized
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        // int dp[][]=new int[m][n];
        int prev[]=new int[n];
        for(int i=0;i<m;i++){
            int curr[]=new int[n];
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1) {curr[j]=0; continue;}
                if(i==0 && j==0) {curr[j]= 1; continue;}
                
                    int up=0;
                    int left=0;
                    if(i>0)  up=prev[j];
                    if(j>0)  left=curr[j-1];
                    curr[j]=up+left;
                
            }
            prev=curr;
        }
        return prev[n-1];
    }
}