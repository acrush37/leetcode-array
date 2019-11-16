package medium;

import java.util.HashSet;
import java.util.Set;

/*
    Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.

    Return the sum of the three integers. You may assume that each input would have exactly one solution.
 */
public class ThreeSumClosest {

    public static void main(String... args) {

        int[] nums = {-1, 2, 1, -4};
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        System.out.println(threeSumClosest.threeSumClosest(nums, 1));
    }

    public int threeSumClosest(int[] nums, int target) {

        Set<Integer> set = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n-2; i++)
            for (int j = i+1; j < n-1; j++)
                for (int k = j+1; k < n; k++)
                    set.add(nums[i] + nums[j] + nums[k]);

        for (int i = 0; ; i++) {
            if (set.contains(target+i)) return target+i;
            if (set.contains(target-i)) return target-i;
        }
    }

}
