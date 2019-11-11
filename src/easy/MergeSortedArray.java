package easy;

import java.util.Arrays;

/*
    Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 */
public class MergeSortedArray {

    public static void main(String... args) {

        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(nums1, 3, nums2, 3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] f = Arrays.copyOf(nums1, m);
        int i = 0;
        int j = 0;

        for (int k = 0; k < m+n; k++) {

            if (i == m) nums1[k] = nums2[j++];
            else if (j == n) nums1[k] = f[i++];
            else nums1[k] = f[i] < nums2[j] ? f[i++] : nums2[j++];
        }
    }

}
