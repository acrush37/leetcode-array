package medium;

/*
    Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
    prove that at least one duplicate number must exist.

    Assume that there is only one duplicate number, find the duplicate one.
 */
public class FindTheDuplicateNumber {

    public static void main(String... args) {

        int[] nums = {1, 3, 4, 2, 2};
        FindTheDuplicateNumber findTheDuplicateNumber = new FindTheDuplicateNumber();
        System.out.println(findTheDuplicateNumber.findDuplicate(nums));
    }

    public int findDuplicate(int[] nums) {

        boolean[] t = new boolean[nums.length];

        for (int x : nums)
            if (t[x]) return x;
            else t[x] = true;

        return 0;
    }

}
