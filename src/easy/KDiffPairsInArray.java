package easy;

import java.util.HashMap;
import java.util.Map;

/*
    Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array.
    Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
 */
public class KDiffPairsInArray {

    public static void main(String... args) {

        int[] nums = {1, 2, 3, 4, 5, 3, 2};
        KDiffPairsInArray kDiffPairsInArray = new KDiffPairsInArray();
        System.out.println(kDiffPairsInArray.findPairs(nums, 2));
    }

    public int findPairs(int[] nums, int k) {

        if (k < 0) return 0;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int x : nums) {

            Integer y = map.get(x);
            y = y == null ? 1 : 1 + y;
            map.put(x, y);

            if (k != 0) {

                if (y == 1) {

                    y = map.get(x + k);
                    if (y != null) result++;
                    y = map.get(x - k);
                    if (y != null) result++;
                }
            } else if (y == 2) result++;
        }

        return result;
    }

}
