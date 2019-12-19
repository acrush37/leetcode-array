package medium;

/*
    We are given an array A of positive integers, and two positive integers L and R (L <= R).

    Return the number of (contiguous, non-empty) subarrays such that the value
    of the maximum array element in that subarray is at least L and at most R.
 */
public class NumberOfSubarraysWithBoundedMaximum {

    public static void main(String... args) {

        int[] A = {409,96,729,843,328,855,860,587,238,141,475,857,82,10,279,683,194,549,81,201,711,705,617,615,941,589,12,781,260,42,745,976,201,973,609,402,629,322,78,805,746,515,401,119,224,178,711,960,266,130,310,731,969,717,43,656,729,447,997,563,41,235,366,584,293,305,104,378,632,766,245,149,498,147,865,133,227,680,655,603,529,885,875,737,173,317,995,705,283,984,649,513,702,313,499,676,516,106,446,491};
        NumberOfSubarraysWithBoundedMaximum numberOfSubarraysWithBoundedMaximum = new NumberOfSubarraysWithBoundedMaximum();
        System.out.println(numberOfSubarraysWithBoundedMaximum.numSubarrayBoundedMax(A, 542, 772));
    }

    public int numSubarrayBoundedMax(int[] A, int L, int R) {

        int result = 0;
        int n = A.length;
        int[] f = new int[n];
        if (A[0] >= L && A[0] <= R) result = f[0] = 1;

        for (int i = 1; i < n; i++)
            if (A[i] <= R) {

                if (A[i] < L) f[i] = f[i-1];
                else if (A[i-1] > R) f[i] = 1;
                else if (A[i-1] >= L) f[i] = 1 + f[i-1];
                else {

                    int j = i-1;
                    while (j >= 0 && A[j] < L) j--;

                    if (j == -1) f[i] = i+1;
                    else f[i] = f[j] + i - j;
                }

                result += f[i];
            }

        return result;
    }

}
