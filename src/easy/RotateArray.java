package easy;

import java.util.Arrays;

/*
    Given an array, rotate the array to the right by k steps, where k is non-negative.
 */
public class RotateArray {

    public static void main(String... args) {

        int[] nums = {1, 2, 3, 4, 5, 6 ,7};
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(nums, 3);
    }

    public void rotate(int[] nums, int k) {

        int n = nums.length;
        if (k > n) k -= n;
        int[] f = Arrays.copyOf(nums, n);
        for (int i = 0; i < k; i++) nums[i] = f[n-k+i];
        for (int i = k; i < n; i++) nums[i] = f[i-k];
    }

}
