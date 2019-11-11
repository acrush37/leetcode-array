package easy;

import java.util.Arrays;

/*
    Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

    Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.

    Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
 */
public class RelativeSortArray {

    public static void main(String... args) {

        int[] arr1 = {2, 9, 6, 4, 3, 1};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        RelativeSortArray relativeSortArray = new RelativeSortArray();
        System.out.println(relativeSortArray.relativeSortArray(arr1, arr2));
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        boolean[] t = new boolean[1001];
        for (int x : arr2) t[x] = true;
        int[] f = new int[1001];
        int n = arr1.length;
        int[] a = new int[n];
        int i = 0;
        int j = 0;

        for (int x : arr1)
            if (t[x]) {
                i++;
                f[x]++;
            }

        for (int x : arr2) for (int k = 0; k < f[x]; k++) a[j++] = x;
        for (int x : arr1) if (!t[x]) a[j++] = x;
        Arrays.sort(a, i, n);
        return a;
    }

}
