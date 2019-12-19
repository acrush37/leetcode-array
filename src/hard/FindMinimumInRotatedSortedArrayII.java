package hard;

/*
    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

    (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

    Find the minimum element. The array may contain duplicates.
 */
public class FindMinimumInRotatedSortedArrayII {

    public static void main(String... args) {

        int[] nums = {2, 2, 2, 0, 1};
        FindMinimumInRotatedSortedArrayII findMinimumInRotatedSortedArrayII = new FindMinimumInRotatedSortedArrayII();
        System.out.println(findMinimumInRotatedSortedArrayII.findMin(nums));
    }

    public int findMin(int[] nums) {

        int result = nums[0];
        for (int x : nums) result = Math.min(result, x);
        return result;
    }

}
