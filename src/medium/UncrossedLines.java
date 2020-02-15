package medium;

/*
    We write the integers of A and B (in the order they are given) on two separate horizontal lines.
    Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that: A[i] == B[j];
    The line we draw does not intersect any other connecting (non-horizontal) line.

    Note that a connecting lines cannot intersect even at the endpoints:
    each number can only belong to one connecting line.

    Return the maximum number of connecting lines we can draw in this way.
 */
public class UncrossedLines {

    public static void main(String... args) {

        int[] A = {2, 5, 1, 2, 5};
        int[] B = {10, 5, 2, 1, 5, 2};
        UncrossedLines uncrossedLines = new UncrossedLines();
        System.out.println(uncrossedLines.maxUncrossedLines(A, B));
    }

    public int maxUncrossedLines(int[] A, int[] B) {

        int m = A.length, n = B.length;
        int[][] f = new int[m+1][n+1];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                f[i+1][j+1] = A[i] == B[j] ? f[i][j] + 1 : Math.max(f[i+1][j], f[i][j+1]);

        return f[m][n];
    }

}
