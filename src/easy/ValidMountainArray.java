package easy;

/*
    Given an array A of integers, return true if and only if it is a valid mountain array.

    Recall that A is a mountain array if and only if:

    A.length >= 3

    There exists some i with 0 < i < A.length - 1 such that:
        A[0] < A[1] < ... A[i-1] < A[i]
        A[i] > A[i+1] > ... > A[A.length - 1]
 */
public class ValidMountainArray {

    public static void main(String... args) {

        int[] A = {0, 2, 3, 1};
        ValidMountainArray validMountainArray = new ValidMountainArray();
        System.out.println(validMountainArray.validMountainArray(A));
    }

    public boolean validMountainArray(int[] A) {

        int n = A.length;
        if (n < 3 || A[0] >= A[1]) return false;
        int i = 1;
        while (i < n && A[i-1] < A[i]) i++;
        if (i == n) return false;
        for (int j = i; j < n; j++) if (A[j-1] <= A[j]) return false;
        return true;
    }

}
