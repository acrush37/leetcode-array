package easy;

import java.util.ArrayList;
import java.util.List;

/*
    Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.

    In one shift operation:

    Element at grid[i][j] becomes at grid[i][j + 1].
    Element at grid[i][n - 1] becomes at grid[i + 1][0].
    Element at grid[n - 1][n - 1] becomes at grid[0][0].
    Return the 2D grid after applying shift operation k times.
 */
public class Shift2DGrid {

    public static void main(String... args) {

        int[][] grid = {{1}, {2}, {3}, {4}, {7}, {6}, {5}};
        Shift2DGrid shift2DGrid = new Shift2DGrid();
        System.out.println(shift2DGrid.shiftGrid(grid, 23));
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        List<List<Integer>> result = new ArrayList<>();
        int m = grid.length, n = grid[0].length, p = m*n, q = 0;
        int[] f = new int[p];

        for (int[] x : grid)
            for (int y : x)
                f[q++] = y;

        k = p - k % p;

        for (int i = 0; i < m; i++) {

            List<Integer> t = new ArrayList<>();
            for (int j = 0; j < n; j++) t.add(f[k++ % p]);
            result.add(t);
        }

        return result;
    }

}
