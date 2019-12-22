package easy;

/*
    Given an array nums of integers, return how many of them contain an even number of digits.
 */
public class FindNumbersWithEvenNumberOfDigits {

    public static void main(String... args) {

        int[] nums = {12, 345, 2, 6, 7896};
        FindNumbersWithEvenNumberOfDigits findNumbersWithEvenNumberOfDigits = new FindNumbersWithEvenNumberOfDigits();
        System.out.println(findNumbersWithEvenNumberOfDigits.findNumbers(nums));
    }

    public int findNumbers(int[] nums) {

        int result = 0;
        for (int x : nums) result += (x + "").length() & 1 ^ 1;
        return result;
    }

}
