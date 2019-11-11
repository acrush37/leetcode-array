package easy;

import java.util.Arrays;

/*
    Students are asked to stand in non-decreasing order of heights for an annual photo.

    Return the minimum number of students not standing in the right positions.
    (This is the number of students that must move in order for all students to be standing in non-decreasing order of height.)
 */
public class HeightChecker {

    public static void main(String... args) {

        int[] heights = {1, 1, 4, 2, 1, 3};
        HeightChecker heightChecker = new HeightChecker();
        System.out.println(heightChecker.heightChecker(heights));
    }

    public int heightChecker(int[] heights) {

        int sum = 0;
        int n = heights.length;
        int[] f = Arrays.copyOf(heights, n);
        Arrays.sort(f);

        for (int i = 0; i < n; i++)
            if (f[i] != heights[i])
                sum++;

        return sum;
    }

}
