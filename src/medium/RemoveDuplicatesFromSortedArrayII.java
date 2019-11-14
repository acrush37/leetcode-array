package medium;

/*
    Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 */
public class RemoveDuplicatesFromSortedArrayII {

    public static void main(String... args) {

        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        RemoveDuplicatesFromSortedArrayII removeDuplicatesFromSortedArrayII = new RemoveDuplicatesFromSortedArrayII();
        System.out.println(removeDuplicatesFromSortedArrayII.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {

        int n = nums.length;
        if (n == 0) return 0;
        int k = 1;
        int s = 1;

        for (int i = 1; i < n; i++)
            if (nums[i] != nums[i-1]) {

                s = 1;
                nums[k++] = nums[i];
            } else {

                s++;
                if (s <= 2) nums[k++] = nums[i];
            }

        return k;
    }

}
