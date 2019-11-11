package easy;

/*
    Given an array nums and a value val, remove all instances of that value in-place and return the new length.

    Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

    The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElement {

    public static void main(String... args) {

        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        RemoveElement removeElement = new RemoveElement();
        System.out.println(removeElement.removeElement(nums, 2));
    }

    public int removeElement(int[] nums, int val) {

        int k = 0;
        for (int x : nums) if (x != val) nums[k++] = x;
        return  k;
    }

}
