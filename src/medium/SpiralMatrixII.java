package medium;

/*
    Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 */
public class SpiralMatrixII {

    public static void main(String... args) {

        SpiralMatrixII spiralMatrixII = new SpiralMatrixII();
        System.out.println(spiralMatrixII.generateMatrix(3));
    }

    public int[][] generateMatrix(int n) {

        int[] a = {0, 1, 0, -1};
        int[] b = {1, 0, -1, 0};
        int k = 0, x = 0, y = 0;
        int[][] result = new int[n][n];

        for (int i = 1; i <= n*n; i++) {

            result[x][y] = i;
            int u = x + a[k];
            int v = y + b[k];

            if (u < 0 || v < 0 || u >= n || v >= n || result[u][v] != 0) {
                k = (k+1) % 4;
                u = x + a[k];
                v = y + b[k];
            }

            x = u;
            y = v;
        }

        return result;
    }

}
