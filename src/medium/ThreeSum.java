package medium;

import java.util.*;

/*
    Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?

    Find all unique triplets in the array which gives the sum of zero.
 */
public class ThreeSum {

    public static void main(String... args) {

        int[] nums = {0, 0, 0, 0};
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);
        Set<Integer> t = new HashSet<>();
        Set<String> set = new HashSet<>();
        Map<Integer, Set<Integer[]>> m = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 1; i < n-1; i++)
            for (int j = i+1; j < n; j++) {

                String s = nums[i] + "," + nums[j];
                if (set.contains(s)) continue;
                set.add(s);
                int key = -nums[i]-nums[j];
                set.add(nums[j] + "," + nums[i]);
                set.add(nums[j] + "," + key);
                set.add(key + "," + nums[j]);
                set.add(key + "," + nums[i]);
                set.add(nums[i] + "," + key);
                Set<Integer[]> value = m.get(key);
                if (value == null) value = new HashSet<>();
                value.add(new Integer[]{nums[i], nums[j]});
                m.put(key, value);
            }

        for (int i = 0; i < n; i++)
            if (!t.contains(nums[i])) {

                t.add(nums[i]);
                Set<Integer[]> s = m.get(nums[i]);

                if (s != null)
                    for (Integer[] f : s)
                        result.add(Arrays.asList(nums[i], f[0], f[1]));
            }

        return result;
    }

}
