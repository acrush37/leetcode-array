package easy;

/*
    Given a non-empty array of integers, return the third maximum number in this array.
    If it does not exist, return the maximum number. The time complexity must be in O(n).
 */
public class ThirdMaximumNumber {

    public static void main(String... args) {

        int[] nums = {3, 2, 1};
        ThirdMaximumNumber thirdMaximumNumber = new ThirdMaximumNumber();
        System.out.println(thirdMaximumNumber.thirdMax(nums));
    }

    public int thirdMax(int[] nums) {

        int n = nums.length;
        int first = nums[0];
        for (int i = 1; i < n; i++) first = Math.max(first, nums[i]);
        int second = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++)
            if (nums[i] != first)
                second = Math.max(second, nums[i]);

        if (second == Integer.MIN_VALUE) return first;
        int i = 0;
        while (i < n && nums[i] >= second) i++;
        if (i == n) return first;
        int third = nums[i];

        for (int j = i+1; j < n; j++)
            if (nums[j] < second)
                third = Math.max(third, nums[j]);

        return third;
    }

}
