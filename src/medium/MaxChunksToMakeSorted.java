package medium;

import java.util.*;

/*
    Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the
    array into some number of "chunks" (partitions), and individually sort each chunk.

    After concatenating them, the result equals the sorted array.

    What is the most number of chunks we could have made?
 */
public class MaxChunksToMakeSorted {

    public static void main(String... args) {

        int[] arr = {1, 4, 0, 2, 3, 5};
        MaxChunksToMakeSorted maxChunksToMakeSorted = new MaxChunksToMakeSorted();
        System.out.println(maxChunksToMakeSorted.maxChunksToSorted(arr));
    }

    public int maxChunksToSorted(int[] arr) {

        int result = 0;
        int n = arr.length;
        boolean[] t = new boolean[10];

        Set<int[]> s = new TreeSet<>((x, y) -> {
            int a = x[1]-x[0];
            int b = y[1]-y[0];
            if (a > b) return -1;
            if (a < b) return 1;
            return x[1] > y[1] ? 1 : -1;
        });

        for (int i = 0; i < n; i++)
            s.add(arr[i] > i ? new int[]{i, arr[i]} :new int[]{arr[i], i});

        for (int[] a : s) {
            if (!t[a[0]] && !t[a[1]]) result++;
            for (int i = a[0]; i <= a[1]; i++) t[i] = true;
        }

        return result;
    }

}
