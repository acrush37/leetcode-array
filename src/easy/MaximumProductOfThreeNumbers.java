package easy;

import java.util.Arrays;

/*
    Given an integer array, find three numbers whose product is maximum and output the maximum product.
 */
public class MaximumProductOfThreeNumbers {

    public static void main(String... args) {

        int[] nums = {-1, -2, -3, 4};
        MaximumProductOfThreeNumbers maximumProductOfThreeNumbers = new MaximumProductOfThreeNumbers();
        System.out.println(maximumProductOfThreeNumbers.maximumProduct(nums));
    }

    public int maximumProduct(int[] nums) {

        int n = nums.length;
        if (n == 3) return nums[0] * nums[1] * nums[2];
        int negative = 0;
        Arrays.sort(nums);
        for (int x : nums) if (x < 0) negative++;
        if (negative <= 1) return nums[n-1] * nums[n-2] * nums[n-3];
        return Math.max(nums[0] * nums[1] * nums[n-1], nums[n-1] * nums[n-2] * nums[n-3]);
    }

}
