package easy;

import java.util.HashSet;
import java.util.Set;

/*
    Given an array of integers, find if the array contains any duplicates.

    Your function should return true if any value appears at least twice in the array,
    and it should return false if every element is distinct.
 */
public class ContainsDuplicate {

    public static void main(String... args) {

        int[] nums = {1, 2, 3};
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        System.out.println(containsDuplicate.containsDuplicate(nums));
    }

    public boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int x : nums)
            if (set.contains(x)) return true;
            else set.add(x);

        return false;
    }

}
