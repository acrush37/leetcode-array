package hard;

/*
    Given n non-negative integers representing the histogram's bar height where the
    width of each bar is 1, find the area of largest rectangle in the histogram.
 */
public class LargestRectangleInHistogram {

    public static void main(String... args) {

        int[] heights = {1, 1};
        LargestRectangleInHistogram largestRectangleInHistogram = new LargestRectangleInHistogram();
        System.out.println(largestRectangleInHistogram.largestRectangleArea(heights));
    }

    public int largestRectangleArea(int[] heights) {

        long result = 0, n = heights.length;

        for (int i = 0; i < n; i++) {

            long min = heights[i];

            for (int j = i; j >= 0; j--) {

                min = Math.min(min, heights[j]);
                if (min * (i + 1) <= result) break;
                result = Math.max(result, min * (i - j + 1));
            }
        }

        return (int) result;
    }

}
