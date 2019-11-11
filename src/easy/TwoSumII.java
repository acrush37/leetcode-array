package easy;

/*
    Given an array of integers that is already sorted in ascending order,
    find two numbers such that they add up to a specific target number.

    The function twoSum should return indices of the two numbers such that they add up to the target,
    where index1 must be less than index2.
 */
public class TwoSumII {

    public static void main(String... args) {

        int[] numbers = {2, 7, 11, 15};
        TwoSumII twoSumII = new TwoSumII();
        System.out.println(twoSumII.twoSum(numbers, 9));
    }

    public int[] twoSum(int[] numbers, int target) {

        int n = numbers.length;

        for (int i = 0; i < n-1; i++)
            for (int j = i + 1; j < n; j++) {

                int x = numbers[i] + numbers[j];
                if (x == target) return new int[]{i+1, j+1};
                if (x > target) break;
            }

        return null;
    }

}
