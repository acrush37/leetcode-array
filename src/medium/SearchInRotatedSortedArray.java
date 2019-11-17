package medium;

/*
    Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

    (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

    You are given a target value to search. If found in the array return its index, otherwise return -1
 */
public class SearchInRotatedSortedArray {

    public static void main(String... args) {

        int[] nums = {9, 1, 2, 3, 4, 5, 6, 7, 8};
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        System.out.println(searchInRotatedSortedArray.search(nums, 1));
    }

    private int find(int left, int right, int target, int[] nums) {

        if (left > right) return -1;
        int mid = (left + right) >> 1;
        if (nums[mid] == target) return mid;

        if(nums[mid] < nums[left]) return target < nums[mid] || target >= nums[left]
                ? find(left, mid - 1 , target, nums) : find(mid + 1, right , target, nums);

        if (target < nums[mid] && target >= nums[left]) return find(left, mid - 1 , target, nums);
        return find(mid + 1, right , target, nums);
    }

    public int search(int[] nums, int target) {
        return find(0, nums.length-1, target, nums);
    }

}
