class Solution {
    public void transpose(int a[][], int n) {
        for (int i=0; i<n;i++) {
            for (int j=i+1;j<n;j++) {
                int t=a[i][j];
                a[i][j]=a[j][i];
                a[j][i]=t;
            }
        }
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        transpose(matrix,n);
        for (int i =0; i<n;i++) {
            for (int j=0; j<n/2; j++) { 
                int t =matrix[i][j];
                matrix[i][j] =matrix[i][n-1-j];
                matrix[i][n-1-j] =t;
            }
        }
    }
}