package easy;

/*
    A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row,
    column, and both diagonals all have the same sum.

    Given an grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).
 */
public class MagicSquaresInGrid {

    public static void main(String... args) {

        int[][] grid = {{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}};
        MagicSquaresInGrid magicSquaresInGrid = new MagicSquaresInGrid();
        System.out.println(magicSquaresInGrid.numMagicSquaresInside(grid));
    }

    public int numMagicSquaresInside(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int result = 0;

        for (int i = 0; i <= m-3; i++)
            for (int j = 0; j <= n-3; j++) {

                if (grid[i][j] + grid[i][j+1] + grid[i][j+2] != 15) continue;
                if (grid[i+1][j] + grid[i+1][j+1] + grid[i+1][j+2] != 15) continue;
                if (grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2] != 15) continue;
                if (grid[i][j] + grid[i+1][j] + grid[i+2][j] != 15) continue;
                if (grid[i][j+1] + grid[i+1][j+1] + grid[i+2][j+1] != 15) continue;
                if (grid[i][j+2] + grid[i+1][j+2] + grid[i+2][j+2] != 15) continue;
                if (grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2] != 15) continue;
                if (grid[i][j+2] + grid[i+1][j+1] + grid[i+2][j] != 15) continue;
                boolean[] t = new boolean[16];
                t[grid[i][j]] = true;
                t[grid[i][j+1]] = true;
                t[grid[i][j+2]] = true;
                t[grid[i+1][j]] = true;
                t[grid[i+1][j+1]] = true;
                t[grid[i+1][j+2]] = true;
                t[grid[i+2][j]] = true;
                t[grid[i+2][j+1]] = true;
                t[grid[i+2][j+2]] = true;

                for (int k = 1; k <= 9; k++)
                    if (!t[k]) {
                        result--;
                        break;
                    }

                result++;
            }

        return result;
    }

}
