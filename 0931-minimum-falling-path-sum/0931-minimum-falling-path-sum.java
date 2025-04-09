class Solution {
    // int pathsum(int i, int j, int[][] matrix,int m, int n, int dp[][]) {
    //     if (j < 0 || j >= n)
    //         return (int) 1e8; //out of boundary condns
    //     if (i == m - 1) { // base case - destination - last row
    //         return matrix[i][j];
    //     }
    //     if (dp[i][j] != -1)
    //         return dp[i][j];
    //     int min = Integer.MAX_VALUE;
        
    //     int down = matrix[i][j] + pathsum(i + 1, j, matrix, m,n, dp);
    //     int diaryt = matrix[i][j] + pathsum(i + 1, j + 1, matrix, m,n, dp);
    //     int dialeft = matrix[i][j] + pathsum(i + 1, j - 1, matrix,m, n, dp);
    //     min = Math.min(down, Math.min(diaryt,dialeft));
    //     return dp[i][j] = min;
    // }
    public int tabulation(int l,int k,int [][]matrix,int m, int n){
        int dp[][] = new int[m][n];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if (i == m - 1) { // base case - destination - last row
                    dp[i][j]= matrix[i][j];
                }
                else{
                    // int min = Integer.MAX_VALUE;
        
                    int down = matrix[i][j] + dp[i + 1][j];
                    
                    int diaryt = matrix[i][j];
                    if(j+1<m) diaryt+= dp[i + 1][j+1];
                    else diaryt+=(int)1e8;
                    int dialeft = matrix[i][j] ;
                    if(j-1>=0) dialeft+=dp[i + 1][j-1];
                    else dialeft+=(int)1e8;
                    dp[i][j] = Math.min(down, Math.min(diaryt,dialeft));
                }
            }
        }
            return dp[l][k];
    }
    public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        // int dp[][] = new int[m][n];
        // for(int row[]:dp) Arrays.fill(row,-1);
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            ans=Math.min(ans,tabulation(0,i,matrix,m,n));
        }
        return ans;
    }
}