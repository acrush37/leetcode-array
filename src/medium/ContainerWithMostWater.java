package medium;

/*
    Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
    n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
    Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */
public class ContainerWithMostWater {

    public static void main(String... args) {

        int[] height = {2, 3, 4, 5, 18, 17, 6};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(height));
    }

    public int maxArea(int[] height) {

        int result = Math.min(height[1], height[0]);
        int n = height.length;
        int last = 0;

        for (int i = 2; i < n; i++)
            if (height[i] < height[i-1]) {

                int x = (i - last) * Math.min(height[last], height[i]);

                if (height[i-1] > x) last = i-1;
                else if (height[i-1] == x && height[i-1] > height[last]) last = i-1;

                result = Math.max(result, Math.max(x, Math.min(height[i-1], height[i])));
            } else for (int j = 0; j < i; j++) {

                int max = 0;
                int x = (i - j) * Math.min(height[j], height[i]);

                if (x > max) {
                    last = j;
                    max = x;
                }

                result = Math.max(result, max);
            }

        return result;
    }

}
