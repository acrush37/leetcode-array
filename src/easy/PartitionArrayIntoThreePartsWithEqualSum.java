package easy;

/*
    Given an array A of integers, return true if and only if we can partition the array into three non-empty parts with equal sums.

    Formally, we can partition the array if we can find indexes i+1 < j with
    (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])
 */
public class PartitionArrayIntoThreePartsWithEqualSum {

    public static void main(String... args) {

        int[] A = {3, 3, 6, 5, -2, 2, 5, 1, -9, 4};
        PartitionArrayIntoThreePartsWithEqualSum partitionArrayIntoThreePartsWithEqualSum = new PartitionArrayIntoThreePartsWithEqualSum();
        System.out.println(partitionArrayIntoThreePartsWithEqualSum.canThreePartsEqualSum(A));
    }

    public boolean canThreePartsEqualSum(int[] A) {

        int n = A.length;
        int[] f = new int[n+1];
        for (int i = 1; i <= n; i++) f[i] = f[i-1] + A[i-1];
        if (f[n] % 3 != 0) return false;
        int s = f[n] / 3;
        int i, j;
        for (i = 1; i < n-1; i++) if (f[i] == s) break;
        for (j = n; j > 2; j--) if (f[n] - f[j-1] == s) break;
        return i < j && f[j-1] - f[i] == s;
    }

}
