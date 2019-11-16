package medium;

/*
    Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

    Your algorithm's runtime complexity must be in the order of O(log n).

    If the target is not found in the array, return [-1, -1].
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String... args) {

        int[] nums = {5, 7, 7, 8, 8, 10};
        FindFirstAndLastPositionOfElementInSortedArray findFirstAndLastPositionOfElementInSortedArray = new FindFirstAndLastPositionOfElementInSortedArray();
        System.out.println(findFirstAndLastPositionOfElementInSortedArray.searchRange(nums, 6));
    }

    private int[] find(int left, int right, int target, int n, int[] nums) {

        if (left > right) return new int[]{-1, -1};
        int mid = (left + right) >> 1;

        if (nums[mid] == target) {

            left = right = mid;
            while (left >= 0 && nums[left] == target) left--;
            while (right < n && nums[right] == target) right++;
            return new int[]{left+1, right-1};
        }

        return nums[mid] > target ? find(left, mid-1, target, n, nums) : find(mid+1, right, target, n, nums);
    }

    public int[] searchRange(int[] nums, int target) {
        return find(0, nums.length-1, target, nums.length, nums);
    }

}
