package easy;

/*
    Given a matrix A, return the transpose of A.

    The transpose of a matrix is the matrix flipped over it's main diagonal,
    switching the row and column indices of the matrix.
 */
public class TransposeMatrix {

    public static void main(String... args) {

        int[][] A = {{1, 2, 3}, {4, 5, 6}};
        TransposeMatrix transposeMatrix = new TransposeMatrix();
        System.out.println(transposeMatrix.transpose(A));
    }

    public int[][] transpose(int[][] A) {

        int m = A.length;
        int n = A[0].length;
        int[][] f = new int[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                f[i][j] = A[j][i];

        return f;
    }

}
