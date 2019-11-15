package medium;

import java.util.Arrays;

/*
    Given an array consists of non-negative integers, your task is to count the number of triplets
    chosen from the array that can make triangles if we take them as side lengths of a triangle.
 */
public class ValidTriangleNumber {

    public static void main(String... args) {

        int[] nums = {3, 11, 15, 23, 67, 82, 82, 92};
        ValidTriangleNumber validTriangleNumber = new ValidTriangleNumber();
        System.out.println(validTriangleNumber.triangleNumber(nums));
    }

    public int triangleNumber(int[] nums) {

        int n = nums.length;
        if (n == 0) return 0;
        Arrays.sort(nums);
        int p = 0;
        while (p < n  && nums[p] == 0) p++;
        if (n - p < 3) return 0;
        nums = Arrays.copyOfRange(nums, p, n);
        n = nums.length;
        int result = 0;
        int[] f = new int[2001];
        p = nums[n-3] + nums[n-2];
        for (int i = n-1; i >= 0; i--) f[nums[i]] = i-1;
        for (int i = 1+nums[n-1]; i <= p; i++) f[i] = n-1;

        for (int i = 1; i < n; i++)
            if (nums[i] != nums[i-1])
                for (int j = 1+nums[i-1]; j < nums[i]; j++)
                    f[j] = i-1;

        for (int i = 0; i < n-2; i++)
            for (int j = i+1; j < n-1; j++)
                result += f[nums[i] + nums[j]] - j;

        return result;
    }

}
