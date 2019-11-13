package easy;

/*
    Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

    Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 */
public class DegreeOfnArray {

    public static void main(String... args) {

        int[] nums = {1, 2, 2, 3, 1, 4, 2};
        DegreeOfnArray degreeOfnArray = new DegreeOfnArray();
        System.out.println(degreeOfnArray.findShortestSubArray(nums));
    }

    public int findShortestSubArray(int[] nums) {

        int n = nums.length;
        int[] f = new int[50000];
        int[] left = new int[50000];
        int[] right = new int[50000];

        for (int i = 0; i < n; i++)
            if (f[nums[i]]++ == 0) left[nums[i]] = i;
            else right[nums[i]] = i;

        int min = 1;
        int result = n;

        for (int i = 0; i < 50000; i++)
            if (f[i] > min) {
                min = f[i];
                result = right[i] - left[i];
            } else if (f[i] == min) {
                result = Math.min(result, right[i] - left[i]);
            }

        return result <= 0 ? 1 : 1 + result;
    }

}
