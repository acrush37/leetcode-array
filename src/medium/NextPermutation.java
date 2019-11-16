package medium;

import java.util.Arrays;

/*
    Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

    If such arrangement is not possible, it must rearrange it as the lowest possible order
    (ie, sorted in ascending order).
 */
public class NextPermutation {

    public static void main(String... args) {

        int[] nums = {3, 2, 1};
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums);
    }

    public void nextPermutation(int[] nums) {

        int n = nums.length;
        if (n < 2) return;
        int i = n-1;
        while (i > 0 && nums[i] <= nums[i-1]) i--;

        if (i == 0) Arrays.sort(nums);
        else {

            int p = i;
            int min = nums[i];

            for (int j = i+1; j < n; j++)
                if (nums[j] > nums[i-1] && nums[j] < min) {
                    p = j;
                    min = nums[j];
                }

            min = nums[p];
            nums[p] = nums[i-1];
            nums[i-1] = min;
            Arrays.sort(nums, i, n);
        }
    }

}
