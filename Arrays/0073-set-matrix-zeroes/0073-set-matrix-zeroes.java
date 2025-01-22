class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int col = 1; // handling col1 separtely
        // pass1:setting row 1 and col 1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    if (j == 0) {   //for col1 - marker set in separate variable
                        col = 0;
                    } else
                        matrix[0][j] = 0; //For all other columns (j > 0), the markers for columns are set in matrix[0][j]
                    matrix[i][0] = 0;  // for rows, the markers are set in matrix[i][0].
                }
            }
        }
        // pass 2: setting rows and cols to 0 on the basis of row1 and col1
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // row1-first then col1-since col1 is handled separately
        if (matrix[0][0] == 0) {
            int j = 0;
            while (j < m) {
                matrix[0][j++] = 0;
            }
        }
        // col1
        if (col == 0) {
            int j = 0;
            while (j < n) {
                matrix[j++][0] = 0;
            }
        }

    }
}