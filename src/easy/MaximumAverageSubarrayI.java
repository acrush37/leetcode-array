package easy;

/*
    Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value.

    And you need to output the maximum average value.
 */
public class MaximumAverageSubarrayI {

    public static void main(String... args) {

        int[] nums = {1, 12, -5, -6, 50, 3};
        MaximumAverageSubarrayI maximumAverageSubarrayI = new MaximumAverageSubarrayI();
        System.out.println(maximumAverageSubarrayI.findMaxAverage(nums, 4));
    }

    public double findMaxAverage(int[] nums, int k) {

        int n = nums.length;
        if (n == 1) return nums[0];
        int max = Integer.MIN_VALUE;
        int[] f = new int[n+1];
        for (int i = 1; i <= n; i++) f[i] = f[i-1] + nums[i-1];
        for (int i = k; i <= n; i++) max = Math.max(max, f[i] - f[i-k]);
        return max * 1.0 / k;
    }

}
