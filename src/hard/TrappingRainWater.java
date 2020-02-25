package hard;

/*
    Given n non-negative integers representing an elevation map where the width
    of each bar is 1, compute how much water it is able to trap after raining.
 */
public class TrappingRainWater {

    public static void main(String... args) {

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println(trappingRainWater.trap(height));
    }

    public int trap(int[] height) {

        int r = height.length - 1;
        if (r <= 1) return 0;
        int result = 0, l = 0, left = height[0], right = height[r];

        while (l <= r) {

            left = Math.max(left, height[l]);
            right = Math.max(right, height[r]);
            result += left < right ? left - height[l++] : right - height[r--];
        }

        return result;
    }

}
