package medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
    Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

    Note: The algorithm should run in linear time and in O(1) space.
 */
public class MajorityElementII {

    public static void main(String... args) {

        int[] nums = {6, 5, 5};
        MajorityElementII majorityElementII = new MajorityElementII();
        System.out.println(majorityElementII.majorityElement(nums));
    }

    public List<Integer> majorityElement(int[] nums) {

        int vote1 = 0;
        int vote2 = 0;
        int candidate1 = 0;
        int candidate2 = 0;

        for (int n: nums)
            if (candidate1 == n) vote1++;
            else if (candidate2 == n) vote2++;
            else if (vote1 == 0) {
                vote1++;
                candidate1 = n;
            } else if (vote2 == 0) {
                vote2++;
                candidate2 = n;
            } else {
                vote1--;
                vote2--;
            }

        vote1 = vote2 = 0;

        for (int n: nums)
            if (candidate1 == n) vote1++;
            else if (candidate2 == n) vote2++;

        int n = nums.length/3;

        if (vote1 <= n) {
            return vote2 <= n ? Collections.EMPTY_LIST : Arrays.asList(candidate2);
        }

        return vote2 <= n ? Arrays.asList(candidate1) : Arrays.asList(candidate1, candidate2);
    }

}
