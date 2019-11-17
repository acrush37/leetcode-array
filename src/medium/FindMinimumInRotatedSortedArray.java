package medium;

/*
    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

    (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

    Find the minimum element.

    You may assume no duplicate exists in the array.
 */
public class FindMinimumInRotatedSortedArray {

    public static void main(String... args) {

        int[] nums = {4};
        FindMinimumInRotatedSortedArray findMinimumInRotatedSortedArray = new FindMinimumInRotatedSortedArray();
        System.out.println(findMinimumInRotatedSortedArray.findMin(nums));
    }

    private int find(int left, int right, int[] nums) {

        if (left >= right - 1) return Math.min(nums[left], nums[right]);
        if (nums[left] < nums[right]) return nums[left];
        int mid = (left + right) >> 1;
        if (nums[mid] > nums[left]) return find(mid+1, right, nums);
        if (nums[mid] < nums[mid-1]) return nums[mid];
        return find(left, mid-1, nums);
    }

    public int findMin(int[] nums) {
        return find(0, nums.length-1, nums);
    }

}
