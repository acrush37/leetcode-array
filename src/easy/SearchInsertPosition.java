package easy;

/*
    Given a sorted array and a target value, return the index if the target is found.

    If not, return the index where it would be if it were inserted in order.

    You may assume no duplicates in the array.
 */
public class SearchInsertPosition {

    public static void main(String... args) {

        int[] nums = {1, 3, 5, 6};
        SearchInsertPosition searchInsertPosition  = new SearchInsertPosition();
        System.out.println(searchInsertPosition.searchInsert(nums, 1));
    }

    public int searchInsert(int[] nums, int target) {

        int index = 0;
        int n = nums.length;
        while (index < n && nums[index] < target) index++;
        return index;
    }

}
