package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    Given an array of integers arr, replace each element with its rank.

    The rank represents how large the element is. The rank has the following rules:

    Rank is an integer starting from 1.
    The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
    Rank should be as small as possible.
 */
public class RankTransformOfArray {

    public static void main(String... args) {

        int[] arr = {37, 12, 28, 9, 100, 56, 80, 5, 12};
        RankTransformOfArray rankTransformOfArray = new RankTransformOfArray();
        System.out.println(rankTransformOfArray.arrayRankTransform(arr));
    }

    public int[] arrayRankTransform(int[] arr) {

        int n = arr.length;
        if (n == 0) return arr;
        int[] result = Arrays.copyOf(arr, n);
        Map<Integer, Integer> t = new HashMap<>();
        Arrays.sort(arr);
        int k = 0;

        for (int x : arr)
            if (!t.containsKey(x))
                t.put(x, ++k);

        for (int i = 0; i < n; i++) result[i] = t.get(result[i]);
        return result;
    }

}
