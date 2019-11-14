package medium;

/*
    In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.

    (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

    We may rotate the i-th domino, so that A[i] and B[i] swap values.

    Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.

    If it cannot be done, return -1.
 */
public class MinimumDominoRotationsForEqualRow {

    public static void main(String... args) {

        int[] A = {1,2,1,1,1,2,2,2};
        int[] B = {2,1,2,2,2,2,2,2};
        MinimumDominoRotationsForEqualRow minimumDominoRotationsForEqualRow = new MinimumDominoRotationsForEqualRow();
        System.out.println(minimumDominoRotationsForEqualRow.minDominoRotations(A, B));
    }

    public int minDominoRotations(int[] A, int[] B) {

        int s1 = 0;
        int s2 = 1;
        int s3 = 0;
        int s4 = 1;
        int n = A.length;
        int result = n;

        for (int i = 1; i < n; i++) {

            if (s1 != -1 && A[i] != A[0]) s1 = B[i] == A[0] ? 1 + s1 : -1;
            if (s2 != -1 && B[i] != A[0]) s2 = A[i] == A[0] ? 1 + s2 : -1;
            if (s3 != -1 && B[i] != B[0]) s3 = A[i] == B[0] ? 1 + s3 : -1;
            if (s4 != -1 && A[i] != B[0]) s4 = B[i] == B[0] ? 1 + s4 : -1;
        }

        if (s1 != -1) result = s1;
        if (s2 != -1) result = Math.min(result, s2);
        if (s3 != -1) result = Math.min(result, s3);
        if (s4 != -1) result = Math.min(result, s4);
        return result == n ? -1 : result;
    }

}
