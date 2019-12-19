package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.util.Map.Entry;

/*
    Your are given an array of positive integers nums.

    Count and print the number of (contiguous) subarrays where the
    product of all the elements in the subarray is less than k.
 */
public class SubarrayProductLessThanK {

    public static void main(String... args) {

        int[] nums = {1, 1, 1};
        SubarrayProductLessThanK subarrayProductLessThanK = new SubarrayProductLessThanK();
        System.out.println(subarrayProductLessThanK.numSubarrayProductLessThanK(nums, 2));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int result = 0;
        Map<Integer, Integer> a = new HashMap<>();

        for (int x : nums) {

            if (x >= k) {
                a.clear();
                continue;
            }

            Set<Entry<Integer, Integer>> t = a.entrySet();
            Map<Integer, Integer> b = new HashMap<>();

            for (Entry<Integer, Integer> f : t) {

                int y = f.getKey();
                if ((y *= x) >= k) continue;
                b.put(y, f.getValue());
                result += f.getValue();
            }

            result++;
            Integer p = (a = b).get(x);
            a.put(x, p == null ? 1 : 1 + p);
        }

        return result;
    }

}
