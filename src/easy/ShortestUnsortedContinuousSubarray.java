package easy;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static java.util.Map.Entry;

/*
    Given an integer array, you need to find one continuous subarray that if you only sort this
    subarray in ascending order, then the whole array will be sorted in ascending order, too.

    You need to find the shortest such subarray and output its length.
 */
public class ShortestUnsortedContinuousSubarray {

    public static void main(String... args) {

        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        ShortestUnsortedContinuousSubarray shortestUnsortedContinuousSubarray = new ShortestUnsortedContinuousSubarray();
        System.out.println(shortestUnsortedContinuousSubarray.findUnsortedSubarray(nums));
    }

    public int findUnsortedSubarray(int[] nums) {

        int k = 0;
        int n = nums.length;
        int[] f = new int[n];
        Map<Integer, Integer> map = new TreeMap<>();

        for (int x : nums) {

            Integer y = map.get(x);
            if (y == null) y = 0;
            map.put(x, 1 + y);
        }

        Set<Entry<Integer, Integer>> set = map.entrySet();

        for (Entry<Integer, Integer> entry : set)
            for (int i = 0; i < entry.getValue(); i++)
                f[k++] = entry.getKey();

        int i = 0;
        while (i < n && f[i] == nums[i]) i++;
        if (i == n) return 0;
        int j = n-1;
        while (f[j] == nums[j]) j--;
        return j - i +1;
    }

}
