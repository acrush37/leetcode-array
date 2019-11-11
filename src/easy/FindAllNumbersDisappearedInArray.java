package easy;

import java.util.ArrayList;
import java.util.List;

/*
    Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

    Find all the elements of [1, n] inclusive that do not appear in this array.

    Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 */
public class FindAllNumbersDisappearedInArray {

    public static void main(String... args) {

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        FindAllNumbersDisappearedInArray findAllNumbersDisappearedInArray = new FindAllNumbersDisappearedInArray();
        System.out.println(findAllNumbersDisappearedInArray.findDisappearedNumbers(nums));
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {

        int n = nums.length;
        boolean[] t = new boolean[n+1];
        List<Integer> result = new ArrayList<>();
        for (int x : nums) t[x] = true;
        for (int i = 1; i <= n; i++) if (!t[i]) result.add(i);
        return result;
    }

}
