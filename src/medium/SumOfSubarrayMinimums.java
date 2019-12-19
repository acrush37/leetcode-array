package medium;

/*
    Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.

    Since the answer may be large, return the answer modulo 10^9 + 7.
 */
public class SumOfSubarrayMinimums {

    public static void main(String... args) {

        int[] A = {3, 1, 2, 4, 2};
        SumOfSubarrayMinimums sumOfSubarrayMinimums = new SumOfSubarrayMinimums();
        System.out.println(sumOfSubarrayMinimums.sumSubarrayMins(A));
    }

    public int sumSubarrayMins(int[] A) {

        int n = A.length, min = A[0];
        int[] f = new int[n];
        int result = f[0] = A[0];

        for (int i = 1; i < n; i++) {

            if (A[i] >= A[i-1]) f[i] = A[i] + f[i-1];
            else if (A[i] <= min) f[i] = A[i] * (i+1);
            else {

                int j = i-1;
                while (A[j] > A[i]) j--;
                f[i] = f[j] + A[i] * (i-j);
            }

            result = (result + f[i]) % 1000000007;
            min = Math.min(min, A[i]);
        }

        return result;
    }

}
