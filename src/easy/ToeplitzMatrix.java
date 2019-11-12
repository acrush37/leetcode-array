package easy;

/*
    A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.

    Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 */
public class ToeplitzMatrix {

    public static void main(String... args) {

        int[][] matrix = {{1, 2, 3, 4},
                          {5, 1, 2, 3},
                          {9, 5, 1, 2}};
        ToeplitzMatrix toeplitzMatrix = new ToeplitzMatrix();
        System.out.println(toeplitzMatrix.isToeplitzMatrix(matrix));
    }

    public boolean isToeplitzMatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m-1; i++)
            for (int j = 1; j < Math.min(n, m-i); j++)
                if (matrix[i][0] != matrix[i+j][j])
                    return false;

        for (int i = 0; i < n-1; i++)
            for (int j = 1; j < Math.min(m, n-i) ; j++)
                if (matrix[0][i] != matrix[j][i+j])
                    return false;

        return true;
    }

}
