package medium;

import java.util.*;

import static java.util.Map.Entry;

/*
    Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?

    Find all unique triplets in the array which gives the sum of zero.
 */
public class ThreeSum {

    public static void main(String... args) {

        int[] nums = {-6,7,-6,-1,1,-3,-6,7,5,-4,-3,5};
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {

        int s = 0;
        boolean zero = false;
        int n = nums.length;
        int[] f = new int[n];
        Map<Integer, Integer> m = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int x : nums) {

            Integer y = m.get(x);
            m.put(x, y == null ? 1 : 1 + y);
        }

        if (m.containsKey(0)) {

            zero = true;
            if (m.get(0) >= 3) result.add(Arrays.asList(0, 0, 0));
        }

        Set<Entry<Integer, Integer>> entries = m.entrySet();

        for (Entry<Integer, Integer> entry : entries) {

            int key = entry.getKey();

            if (key != 0) {

                f[s++] = key;
                if (key > 0 && zero && m.containsKey(-key)) result.add(Arrays.asList(0, key, -key));

                if (entry.getValue() >= 2) {
                    int x = -(key << 1);
                    if (m.containsKey(x)) result.add(Arrays.asList(key, key, x));
                }
            }
        }

        Arrays.sort(f, 0, s);
        m = new HashMap<>();
        for (int i = 0; i < s; i++) m.put(f[i], i);
        boolean[][] t = new boolean[s][s];

        for (int i = 0; i < s-2; i++)
            for (int j = i+1; j < s-1; j++)
                if (!t[i][j]) {

                    int k = -f[i] - f[j];
                    Integer x = m.get(k);
                    if (x == null || x == i || x == j) continue;
                    t[i][x] = t[x][i] = t[x][j] = t[j][x] = true;
                    result.add(Arrays.asList(f[i], f[j], k));
                }

        return result;
    }

}
