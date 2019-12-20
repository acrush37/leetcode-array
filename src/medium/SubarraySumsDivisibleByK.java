package medium;

/*
    Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.
 */
public class SubarraySumsDivisibleByK {

    public static void main(String... args) {

        int[] A = {4, 5, 0, -2, -3, 1};
        SubarraySumsDivisibleByK subarraySumsDivisibleByK = new SubarraySumsDivisibleByK();
        System.out.println(subarraySumsDivisibleByK.subarraysDivByK(A, 5));
    }

    public int subarraysDivByK(int[] A, int K) {

        int result = 0;
        int[] a = new int[K], b = new int[K];

        for (int x : A) {

            if (x % K == 0) {
                result += ++b[0];
                continue;
            }

            x = K - (K + x % K) % K;
            for (int i = 0; i < K; i++) a[i] = b[(i+x) % K];
            for (int i = 0; i < K; i++) b[i] = a[i];
            result += b[0];
            b[K-x]++;
        }

        return result;
    }

}
