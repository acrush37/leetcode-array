package medium;

/*
    Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.

    Here, a circular array means the end of the array connects to the beginning of the array.
    (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)

    Also, a subarray may only include each element of the fixed buffer A at most once.
    (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)
 */
public class MaximumSumCircularSubarray {

    public static void main(String... args) {

        int[] A = {5, -2, 3, -1, 1};
        MaximumSumCircularSubarray maximumSumCircularSubarray = new MaximumSumCircularSubarray();
        System.out.println(maximumSumCircularSubarray.maxSubarraySumCircular(A));
    }

    public int maxSubarraySumCircular(int[] A) {

        int result = A[0], n = A.length;
        if (n == 1) return A[0];
        int[] a = new int[n], b = new int[n], c = new int[n];
        int s = a[0] = c[0] = A[0];

        for (int i = 1; i < n; i++) {

            a[i] = Math.max(a[i-1], s += A[i]);
            c[i] = Math.max(A[i], c[i-1] + A[i]);
            result = Math.max(result, c[i]);
        }

        s = b[n-1] = A[n-1];

        for (int i = n-2; i >= 1; i--) {
            b[i] = Math.max(b[i+1], s += A[i]);
            result = Math.max(result, b[i] + a[i-1]);
        }

        return result;
    }

}
