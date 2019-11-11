package easy;

import java.util.ArrayList;
import java.util.List;

/*
    Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

    Find all the elements that appear twice in this array.

    Could you do it without extra space and in O(n) runtime?
 */
public class FindAllDuplicatesInArray {

    public static void main(String... args) {

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        FindAllDuplicatesInArray findAllDuplicatesInArray = new FindAllDuplicatesInArray();
        System.out.println(findAllDuplicatesInArray.findDuplicates(nums));
    }

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> list = new ArrayList<>();
        boolean[] t = new boolean[nums.length+1];

        for (int x : nums)
            if (t[x]) list.add(x);
            else t[x] = true;

        return list;
    }

}
