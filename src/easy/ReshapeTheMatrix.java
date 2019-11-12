package easy;

/*
    You're given a matrix represented by a two-dimensional array, and two positive integers r and c
    representing the row number and column number of the wanted reshaped matrix, respectively.

    The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.

    If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix;
    Otherwise, output the original matrix.
 */
public class ReshapeTheMatrix {

    public static void main(String... args) {

        int[][] nums = {{1, 2, 3, 4}};
        ReshapeTheMatrix reshapeTheMatrix = new ReshapeTheMatrix();
        System.out.println(reshapeTheMatrix.matrixReshape(nums, 2, 2));
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {

        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) return nums;
        int[][] t = new int[r][c];
        int[] f = new int[m*n];
        int k = 0;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                f[k++] = nums[i][j];

        for (int i = r-1; i >= 0; i--)
            for (int j = c-1; j >= 0; j--)
                t[i][j] = f[--k];

        return t;
    }

}
