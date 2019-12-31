package hard;

import java.util.Arrays;

/*
    Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

    Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence {

    public static void main(String... args) {

        int[] nums = {100, 4, 200, 1, 3, 2};
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        System.out.println(longestConsecutiveSequence.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {

        nums = Arrays.stream(nums).distinct().toArray();
        int n = nums.length;
        if (n <= 1) return n;
        long max = 0, exp = 1;
        int radix = 10, result = 1, count = 1;
        long[] a = new long[n], t = new long[n];
        for (int i = 0; i < n; i++) max = Math.max(max, a[i] = nums[i] + 2147483648l);

        while (max >= exp) {

            int[] f = new int[radix];
            for (int i = 0; i < n; i++) f[(int) (a[i] / exp % 10)]++;
            for (int i = 1; i < radix; i++) f[i] += f[i - 1];
            for (int i = n-1; i >= 0; i--) t[--f[(int) (a[i] / exp % 10)]] = a[i];
            for (int i = 0; i < n; i++) a[i] = t[i];
            exp *= 10;
        }

        for (int i = 1; i < n; i++)
            if (a[i] != a[i-1] + 1) count = 1;
            else result = Math.max(result, ++count);

        return result;
    }

}
