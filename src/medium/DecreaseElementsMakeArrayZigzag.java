package medium;

import java.util.Arrays;

/*
    Given an array nums of integers, a move consists of choosing any element and decreasing it by 1.

    An array A is a zigzag array if either:
    Every even-indexed element is greater than adjacent elements, ie. A[0] > A[1] < A[2] > A[3] < A[4] > ...
    OR, every odd-indexed element is greater than adjacent elements, ie. A[0] < A[1] > A[2] < A[3] > A[4] < ...

    Return the minimum number of moves to transform the given array nums into a zigzag array.
 */
public class DecreaseElementsMakeArrayZigzag {

    public static void main(String... args) {

        int[] nums = {9, 6, 1, 6, 2};
        DecreaseElementsMakeArrayZigzag decreaseElementsMakeArrayZigzag = new DecreaseElementsMakeArrayZigzag();
        System.out.println(decreaseElementsMakeArrayZigzag.movesToMakeZigzag(nums));
    }

    public int movesToMakeZigzag(int[] nums) {

        int x = 0, y = 0, n = nums.length;
        int[] a = Arrays.copyOf(nums, n);
        

        return Math.min(x, y);
    }

}
