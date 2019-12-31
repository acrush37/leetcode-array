package hard;

/*
    There are two sorted arrays nums1 and nums2 of size m and n respectively.

    Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

    You may assume nums1 and nums2 cannot be both empty.
 */
public class MedianOfTwoSortedArrays {

    public static void main(String... args) {

        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length, n = nums2.length, k = m+n, p = k >> 1;
        int[] f = new int[k];

        for (int i = m+n-1; i >= 0; i--)
            if (m == 0) f[i] = nums2[--n];
            else if (n == 0) f[i] = nums1[--m];
            else if (nums1[m-1] > nums2[n-1]) f[i] = nums1[--m];
            else f[i] = nums2[--n];

        return (k & 1) == 1 ? f[p] : (f[p] + f[p-1]) / 2.0;
    }

}
