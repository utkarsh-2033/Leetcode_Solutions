class Solution {
    // grid - fixed to varible
    // starting from fixed point
    // int pathsum(int i, int j, List<List<Integer>> triangle, int n, int dp[][]) {
    //     if (j < 0 || j > i)
    //         return (int) 1e8; //out of boundary condns
    //     if (i == n - 1) { // base case - destination - last row
    //         return triangle.get(n - 1).get(j);
    //     }
    //     if (dp[i][j] != -1)
    //         return dp[i][j];
    //     int min = Integer.MAX_VALUE;
    //     //moving down and diagonally-down -> adding cell value and then exploeing further paths
    //     int down = triangle.get(i).get(j) + pathsum(i + 1, j, triangle, n, dp);
    //     int dia = triangle.get(i).get(j) + pathsum(i + 1, j + 1, triangle, n, dp);
    //     min = Math.min(down, dia);
    //     return dp[i][j] = min;
    // }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        //tabulation - bottom -up -> moving from bottom row to top row
        for (int i = n-1; i >=0; i--) {
            for (int j =i; j >=0; j--) {
                if (i == n - 1)
                    dp[i][j] = triangle.get(i).get(j); //base case
                else {
                    //moving down and diagonally-down -> adding cell value and then exploeing further paths
                    int down = triangle.get(i).get(j) + dp[i+1][j];
                    int dia = triangle.get(i).get(j) + dp[i+1][j+1];
                    dp[i][j] = Math.min(down, dia);
                }
            }
        }
        return dp[0][0];
    }
}