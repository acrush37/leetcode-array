package easy;

/*
    Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
    find the one that is missing from the array.
 */
public class MissingNumber {

    public static void main(String... args) {

        int[] nums = {3,0,1};
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber(nums));
    }

    public int missingNumber(int[] nums) {

        int n = nums.length;
        int s = (1 + n) * n >> 1;
        for (int x : nums) s -= x;
        return s;
    }

}
