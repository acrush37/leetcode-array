package medium;

/*
    Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {

        int m = matrix.length;
        if (m == 0) return;
        int n = matrix[0].length;
        int[][] f = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                f[i][j] = matrix[i][j];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (f[i][j] == 0) {
                    for (int k = 0; k < n; k++) matrix[i][k] = 0;
                    for (int k = 0; k < m; k++) matrix[k][j] = 0;
                }
    }

}
