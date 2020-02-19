package medium;

import java.util.ArrayList;
import java.util.List;

/*
    Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 */
public class SpiralMatrix {

    public static void main(String... args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        System.out.println(spiralMatrix.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) return result;
        int n = matrix[0].length;
        boolean[][] t = new boolean[m][n];
        int[] a = {0, 1, 0, -1}, b = {1, 0, -1, 0};
        int x = 0, y = 0, z = 0;

        for (int i = 0; i < m*n; i++) {

            t[x][y] = true;
            result.add(matrix[x][y]);
            int u = x + a[z], v = y + b[z];

            if (u >= 0 && u < m && v >= 0 && v < n && !t[u][v]) {
                x = u;
                y = v;
            } else {
                z = (z + 1) % 4;
                x += a[z];
                y += b[z];
            }
        }

        return result;
    }

}
