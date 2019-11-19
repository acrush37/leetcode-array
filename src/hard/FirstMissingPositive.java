package hard;

/*
    Given an unsorted integer array, find the smallest missing positive integer.

    Your algorithm should run in O(n) time and uses constant extra space.
 */
public class FirstMissingPositive {

    public static void main(String... args) {

        int[] nums = {3, 4, -1, 1};
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        System.out.println(firstMissingPositive.firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++)
            if (nums[i] > n || nums[i] < 0)
                nums[i] = 0;

        for (int i = 0; i < n; i++) {
            int p = nums[i] % (n + 1);
            if (p != 0 && nums[p-1] <= n) nums[p-1] += n+1;
        }

        for (int i = 0; i < n; i++) if (nums[i] <= n) return i+1;
        return n+1;
    }

}
