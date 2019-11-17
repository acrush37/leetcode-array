package medium;

/*
    Given an array A, partition it into two (contiguous) subarrays left and right so that:

    Every element in left is less than or equal to every element in right.
    left and right are non-empty.
    left has the smallest possible size.
    Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.
 */
public class PartitionArrayIntoDisjointIntervals {

    public static void main(String... args) {

        int[] A = {5, 4, 3, 2, 5};
        PartitionArrayIntoDisjointIntervals partitionArrayIntoDisjointIntervals = new PartitionArrayIntoDisjointIntervals();
        System.out.println(partitionArrayIntoDisjointIntervals.partitionDisjoint(A));
    }

    public int partitionDisjoint(int[] A) {

        int n = A.length;
        int[] f = new int[n];
        f[n-1] = A[n-1];
        for (int i = n-2; i >= 1; i--) f[i] = Math.min(f[i+1], A[i]);
        int max = 0;

        for (int i = 1; i < n; i++)
            if ((max = Math.max(max, A[i-1])) <= f[i])
                return i;

        return 0;
    }

}
