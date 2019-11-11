package easy;

/*
    Given an array nums, write a function to move all 0's to the end
    of it while maintaining the relative order of the non-zero elements.
 */
public class MoveZeroes {

    public static void main(String... args) {

        int[] nums = {0, 1, 0, 3, 12};
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);
    }

    public void moveZeroes(int[] nums) {

        int k = 0;
        for (int x : nums) if (x != 0) nums[k++] = x;
        while (k < nums.length) nums[k++] = 0;
    }

}
