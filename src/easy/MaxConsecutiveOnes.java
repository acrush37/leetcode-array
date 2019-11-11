package easy;

/*
    Given a binary array, find the maximum number of consecutive 1s in this array.
 */
public class MaxConsecutiveOnes {

    public static void main(String... args) {

        int[] nums = {1, 1, 0, 1, 1, 1};
        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
        System.out.println(maxConsecutiveOnes.findMaxConsecutiveOnes(nums));
    }

    public int findMaxConsecutiveOnes(int[] nums) {

        int n = nums.length;
        if (n == 0) return 0;
        int max = 0;
        int[] f = new int[n+1];

        for (int i = 1; i <= n; i++)
            if (nums[i-1] == 1)
                max = Math.max(max, f[i] = 1 + f[i-1]);

        return max;
    }

}
