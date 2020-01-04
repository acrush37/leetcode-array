package hard;

/*
    Given an integer array, return the k-th smallest distance among all the pairs.
    The distance of a pair (A, B) is defined as the absolute difference between A and B.
 */
public class FindKthSmallestPairDistance {

    public static void main(String... args) {

        int[] nums = {1, 3, 1};
        FindKthSmallestPairDistance findKthSmallestPairDistance = new FindKthSmallestPairDistance();
        System.out.println(findKthSmallestPairDistance.smallestDistancePair(nums, 1));
    }

    public int smallestDistancePair(int[] nums, int k) {

        int n = nums.length;
        int[] f = new int[1000000];

        for (int i = 0; i < n-1; i++)
            for (int j = i+1; j < n; j++)
                f[Math.abs(nums[i] - nums[j])]++;

        for (int i = 0; i < 1000000; i++) if ((k -= f[i]) <= 0) return i;
        return 0;
    }

}
