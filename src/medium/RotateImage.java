package medium;

/*
    You are given an n x n 2D matrix representing an image.

    Rotate the image by 90 degrees (clockwise).
 */
public class RotateImage {

    public void rotate(int[][] matrix) {

        int n = matrix.length;

        for (int i = 0; i < n >> 1; i++)
            for (int j = i; j < n-i-1; j++) {

                int t = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = t;
            }
    }

}
