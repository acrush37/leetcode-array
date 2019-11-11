package easy;

/*
    In a given integer array nums, there is always exactly one largest element.

    Find whether the largest element in the array is at least twice as much as every other number in the array.

    If it is, return the index of the largest element, otherwise return -1.
 */
public class LargestNumberAtLeastTwiceOfOthers {

    public static void main(String... args) {

        int[] nums = {3, 6, 1, 0};
        LargestNumberAtLeastTwiceOfOthers largestNumberAtLeastTwiceOfOthers = new LargestNumberAtLeastTwiceOfOthers();
        System.out.println(largestNumberAtLeastTwiceOfOthers.dominantIndex(nums));
    }

    public int dominantIndex(int[] nums) {

        int n = nums.length;
        int index = 0;
        int max = nums[0];

        for (int i = 1; i < n; i++)
            if (nums[i] > max) {

                index = i;
                max = nums[i];
            }

        for (int i = 0; i < n; i++)
            if (i != index && max < nums[i] << 1)
                return -1;

        return index;
    }

}
