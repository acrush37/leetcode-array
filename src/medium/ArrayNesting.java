package medium;

/*
    A zero-indexed array A of length N contains all integers from 0 to N-1.
    Find and return the longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.

    Suppose the first element in S starts with the selection of element A[i] of index = i,
    the next element in S should be A[A[i]], and then A[A[A[i]]]…

    By that analogy, we stop adding right before a duplicate element occurs in S.
 */
public class ArrayNesting {

    public static void main(String... args) {

        int[] nums = {5, 4, 0, 3, 1, 6, 2};
        ArrayNesting arrayNesting = new ArrayNesting();
        System.out.println(arrayNesting.arrayNesting(nums));
    }

    public int arrayNesting(int[] nums) {

        int n = nums.length;
        boolean[] t = new boolean[n];
        int result = 0;

        for (int x : nums)
            if (!t[x]) {

                int s = 0;

                while (!t[x]) {

                    s++;
                    t[x] = true;
                    x = nums[x];
                }

                result = Math.max(result, s);
            }

        return result;
    }

}
