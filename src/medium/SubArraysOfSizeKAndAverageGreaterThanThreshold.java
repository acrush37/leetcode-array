package medium;

/*
    Given an array of integers arr and two integers k and threshold.

    Return the number of sub-arrays of size k and average greater than or equal to threshold.
 */
public class SubArraysOfSizeKAndAverageGreaterThanThreshold {

    public static void main(String... args) {

        int[] arr = {11, 13, 17, 23, 29, 31, 7, 5, 2, 3};
        SubArraysOfSizeKAndAverageGreaterThanThreshold subArraysOfSizeKAndAverageGreaterThanThreshold = new SubArraysOfSizeKAndAverageGreaterThanThreshold();
        System.out.println(subArraysOfSizeKAndAverageGreaterThanThreshold.numOfSubarrays(arr, 3, 5));
    }

    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int result = 0, n = arr.length, s = 0, t = k * threshold;
        for (int i = 0; i < k; i++) s += arr[i];
        if (s >= t) result++;

        for (int i = k; i < n; i++) {
            s = s + arr[i] - arr[i-k];
            if (s >= t) result++;
        }

        return result;
    }

}
