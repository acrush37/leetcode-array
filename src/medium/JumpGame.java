package medium;

/*
    Given an array of non-negative integers, you are initially positioned at the first index of the array.

    Each element in the array represents your maximum jump length at that position.

    Determine if you are able to reach the last index.
 */
public class JumpGame {

    public static void main(String... args) {

        int[] nums = {3, 2, 1, 0, 4};
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(nums));
    }

    public boolean canJump(int[] nums) {

        int max = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++)
            if (i <= max && (max = Math.max(max, i + nums[i])) >= n-1)
                    return true;

        return false;
    }

}
