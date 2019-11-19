package medium;

/*
    Given an array A of integers, a ramp is a tuple (i, j) for which i < j and A[i] <= A[j].

    The width of such a ramp is j - i.

    Find the maximum width of a ramp in A.  If one doesn't exist, return 0.
 */
public class MaximumWidthRamp {

    public static void main(String... args) {

        int[] A = {1, 1};
        MaximumWidthRamp maximumWidthRamp = new MaximumWidthRamp();
        System.out.println(maximumWidthRamp.maxWidthRamp(A));
    }

    public int maxWidthRamp(int[] A) {

        int m = 0;
        int result = 0;
        int n = A.length;
        int[] f = new int[50001];
        int[] g = new int[50001];
        int[] p = new int[50001];
        boolean[] t = new boolean[50001];
        for (int i = 0; i < n; i++) g[A[i]] = i+1;

        for (int i = 0; i <= 50000; i++)
            if (g[i] != 0) {
                p[i] = m;
                f[m++] = i;
            }

        for (int i = 0; i < n-1; i++) {

            if (n - i - 1 <= result) return result;

            if (!t[A[i]]) {
                t[A[i]] = true;
                for (int j = p[A[i]]; j < m; j++) result = Math.max(result, g[f[j]] - i - 1);
            }
        }

        return result;
    }

}
