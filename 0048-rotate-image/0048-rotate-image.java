class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int t=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=t;
            }
        }
        int l=0,r=n-1;
        while(l<r){
            for(int i=0;i<n;i++){
                int t=matrix[i][l];
                matrix[i][l]=matrix[i][r];
                matrix[i][r]=t;
            }
            l++;r--;
        }
    }
}