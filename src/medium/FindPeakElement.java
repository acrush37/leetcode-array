package medium;

/*
    A peak element is an element that is greater than its neighbors.

    Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

    The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 */
public class FindPeakElement {

    public static void main(String... args){

        int[] nums = {1, 2, 3, 1};
        FindPeakElement findPeakElement = new FindPeakElement();
        System.out.println(findPeakElement.findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {

        int n = nums.length;

        for (int i = 1; i < n; i++)
            if (nums[i-1] > nums[i])
                return i-1;

        return n-1;
    }

}
