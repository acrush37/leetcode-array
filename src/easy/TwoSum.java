package easy;

import java.util.Arrays;

/*
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class TwoSum {

    public static void main(String... args) {

        int[] nums = {2, 7, 11, 15};
        TwoSum twoSum = new TwoSum();
        System.out.println(twoSum.twoSum(nums, 9));
    }

    public int[] twoSum(int[] nums, int target) {

        int n = nums.length;

        for (int i = 0; i < n-1; i++)
            for (int j = i+1; j < n; j++)
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};

        return null;
    }

}
