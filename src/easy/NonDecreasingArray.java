package easy;

/*
    Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.

    We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
 */
public class NonDecreasingArray {

    public static void main(String... args) {

        int[] nums = {-1, 4, 2, 3};
        NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();
        System.out.println(nonDecreasingArray.checkPossibility(nums));
    }

    public boolean checkPossibility(int[] nums) {

        int s = 0;
        int n = nums.length;

        for (int i = 1; i < n; i++)
            if (nums[i] < nums[i-1]) {

                if (++s == 2) return false;
                if (i != 1 && nums[i-2] > nums[i]) nums[i] = nums[i-1];
            }

        return true;
    }

}
