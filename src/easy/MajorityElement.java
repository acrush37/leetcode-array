package easy;

import java.util.HashMap;
import java.util.Map;

/*
    Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

    You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {

    public static void main(String... args) {

        int[] nums = {3};
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {

        int n = nums.length;
        if (n == 1) return nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        n = 1 + (n >> 1);

        for (int x : nums) {

            Integer y = map.get(x);

            if (y == null) map.put(x, 1);
            else {

                if (y + 1 == n) return x;
                map.put(x, 1 + y);
            }
        }

        return 0;
    }

}
