package easy;

/*
    Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
 */
public class LongestContinuousIncreasingSubsequence {

    public static void main(String... args) {

        int[] nums = {1, 3, 5, 4, 7};
        LongestContinuousIncreasingSubsequence longestContinuousIncreasingSubsequence = new LongestContinuousIncreasingSubsequence();
        System.out.println(longestContinuousIncreasingSubsequence.findLengthOfLCIS(nums));
    }

    public int findLengthOfLCIS(int[] nums) {

        int n = nums.length;
        if (n == 0) return 0;
        int[] f = new int[n];
        int max = f[0] = 1;

        for (int i = 1; i < n; i++) {

            f[i] = nums[i] > nums[i-1] ? 1 + f[i-1] : 1;
            max = Math.max(max, f[i]);
        }

        return max;
    }

}
