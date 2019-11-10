package easy;

import java.util.Arrays;

/*
    Given an array of 2n integers, your task is to group these integers into n pairs of integer, say
    (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 */
public class ArrayPartitionI {

    public static void main(String... args) {

        int[] nums = {1, 4, 3, 2};
        ArrayPartitionI arrayPartitionI = new ArrayPartitionI();
        System.out.println(arrayPartitionI.arrayPairSum(nums));
    }

    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            if ((i & 1) == 0)
                sum += nums[i];

        return sum;
    }

}
