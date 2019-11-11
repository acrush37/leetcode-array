package easy;

/*
    Given an array of integers nums, write a method that returns the "pivot" index of this array.

    We define the pivot index as the index where the sum of the numbers to the left of the
    index is equal to the sum of the numbers to the right of the index.

    If no such index exists, we should return -1.
    If there are multiple pivot indexes, you should return the left-most pivot index.
 */
public class FindPivotIndex {

    public static void main(String... args) {

        int[] nums = {1, 7, 3, 6, 5, 6};
        FindPivotIndex findPivotIndex = new FindPivotIndex();
        System.out.println(findPivotIndex.pivotIndex(nums));
    }

    public int pivotIndex(int[] nums) {

        int n = nums.length;
        if (n == 0) return -1;
        int k = -1;
        int[] f = new int[n+1];
        for (int i = 1; i <= n; i++) f[i] += f[i-1] + nums[i-1];

        for (int i = 1; i <= n; i++)
            if (f[n] - nums[i-1] == (f[i] - nums[i-1]) << 1)
                return i-1;

        return k;
    }

}
