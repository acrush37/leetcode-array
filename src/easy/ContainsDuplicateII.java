package easy;

/*
    Given an array of integers and an integer k, find out whether there are two distinct indices i and
    j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 */
public class ContainsDuplicateII {

    public static void main(String... args) {

        int[] nums = {99, 99};
        ContainsDuplicateII containsDuplicateII = new ContainsDuplicateII();
        System.out.println(containsDuplicateII.containsNearbyDuplicate(nums, 2));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        int n = nums.length;
        if (n < 2) return false;

        for (int i = 1; i < n; i++)
            for (int j = Math.max(0, i-k); j < i; j++)
                if (nums[i] == nums[j])
                    return true;

        return false;
    }

}
