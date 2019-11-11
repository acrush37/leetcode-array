package easy;

/*
    Given n and m which are the dimensions of a matrix initialized by zeros and given an array indices where indices[i] = [ri, ci].
    For each pair of [ri, ci] you have to increment all cells in row ri and column ci by 1.

    Return the number of cells with odd values in the matrix after applying the increment to all indices.
 */
public class CellsWithOddValuesInMatrix {

    public static void main(String... args) {

        int[][] indices = {{0, 1}, {1, 1}};
        CellsWithOddValuesInMatrix cellsWithOddValuesInMatrix = new CellsWithOddValuesInMatrix();
        System.out.println(cellsWithOddValuesInMatrix.oddCells(2, 3, indices));
    }

    public int oddCells(int n, int m, int[][] indices) {

        int sum = 0;
        int[][] f = new int[n][m];

        for (int[] x : indices) {

            for (int i = 0; i < n; i++) f[i][x[1]]++;
            for (int i = 0; i < m; i++) f[x[0]][i]++;
        }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if ((f[i][j] & 1) == 1) sum++;

        return sum;
    }

}
