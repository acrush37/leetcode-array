package easy;

/*
    An array is monotonic if it is either monotone increasing or monotone decreasing.

    An array A is monotone increasing if for all i <= j, A[i] <= A[j].
    An array A is monotone decreasing if for all i <= j, A[i] >= A[j].

    Return true if and only if the given array A is monotonic.
 */
public class MonotonicArray {

    public static void main(String... args) {

        int[] A = {1, 2, 2, 3, 3, 3, 2};
        MonotonicArray monotonicArray = new MonotonicArray();
        System.out.println(monotonicArray.isMonotonic(A));
    }

    public boolean isMonotonic(int[] A) {

        int n = A.length;
        if (n <= 2) return true;
        boolean flag1 = false, flag2 = false;

        for (int i = 1; i < n; i++) {

            if (A[i] < A[i-1]) flag1 = true;
            if (A[i] > A[i-1]) flag2 = true;
            if (flag1 && flag2) return false;
        }

        return true;
    }
}
