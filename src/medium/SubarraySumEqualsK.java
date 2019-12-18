package medium;

/*
    Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 */
public class SubarraySumEqualsK {

    public static void main(String... args) {

        int[] nums = {1, 1, 1};
        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        System.out.println(subarraySumEqualsK.subarraySum(nums, 2));
    }

    public int subarraySum(int[] nums, int k) {

        int n = nums.length, result = 0;
        int[] a = new int[n], b = new int[n];
        n = 0;

        for (int x : nums) {

            if (x == k) result++;

            if (n == 0) {

                a[0] = x;
                b[n++] = 1;
                continue;
            }

            int p = -1;

            for (int i = 0; i < n; i++) {
                if (a[i] == 0) p = i;
                if ((a[i] += x) == k) result += b[i];
            }

            if (p >= 0) b[p]++;
            else {
                a[n] = x;
                b[n++] = 1;
            }
        }

        return result;
    }

}
