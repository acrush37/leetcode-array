package medium;

/*
    Given an array A of non-negative integers, return the maximum sum of elements
    in two non-overlapping (contiguous) subarrays, which have lengths L and M.

    (For clarification, the L-length subarray could occur before or after the M-length subarray.)
 */
public class MaximumSumOfTwoNonOverlappingSubarrays {

    public static void main(String... args) {

        int[] A = {73,19,19,55,88,6,34,21,75,5,93,30,4,12,18,98,45,15,8,9,28,56,5,69,55,95,93,46,2,29,41,28,74,9,10,14,81,52,23,57,76,59,18,66,25,87,46,32,96,1};
        MaximumSumOfTwoNonOverlappingSubarrays maximumSumOfTwoNonOverlappingSubarrays = new MaximumSumOfTwoNonOverlappingSubarrays();
        System.out.println(maximumSumOfTwoNonOverlappingSubarrays.maxSumTwoNoOverlap(A, 26, 5));
    }

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {

        int max = 0;
        int n = A.length;
        int[] s = new int[n+2];
        int[] f1 = new int[n+2];
        int[] f2 = new int[n+2];
        int[] t1 = new int[n+2];
        int[] t2 = new int[n+2];
        for (int i = 1; i <= n; i++) s[i] += s[i-1] + A[i-1];
        for (int i = L; i <= n-M; i++) f1[i] = Math.max(f1[i-1], s[i] - s[i-L]);
        for (int i = M; i <= n-L; i++) f2[i] = Math.max(f2[i-1], s[i] - s[i-M]);
        for (int i = n-M; i >= L; i--) t1[i] = Math.max(t1[i+1], s[i+M] - s[i]);
        for (int i = n-L; i >= M; i--) t2[i] = Math.max(t2[i+1], s[i+L] - s[i]);
        for (int i = L; i <= n-M; i++) max = Math.max(max, f1[i] + t1[i]);
        for (int i = M; i <= n-L; i++) max = Math.max(max, f2[i] + t2[i]);
        return max;
    }

}
