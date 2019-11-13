package easy;

/*
    Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the
    gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself.
    If a cell has less than 8 surrounding cells, then use as many as you can.
 */
public class ImageSmoother {

    public static void main(String... args) {

        int[][] M = {{2, 3, 4},
                     {5, 6, 7},
                     {8, 9, 10},
                     {11, 12, 13},
                     {14, 15, 16}};
        ImageSmoother imageSmoother = new ImageSmoother();
        System.out.println(imageSmoother.imageSmoother(M));
    }

    public int[][] imageSmoother(int[][] M) {

        int m = M.length;
        int n = M[0].length;
        int[][] f = new int[m][n];
        int[] a = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] b = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {

                int s = 0;
                int p = 0;

                for (int k = 0; k < 9; k++) {

                    int x = i + a[k];
                    int y = j + b[k];

                    if (x >= 0 && y >= 0 && x < m && y < n) {
                        p++;
                        s += M[x][y];
                    }
                }

                f[i][j] = s / p;
            }

        return f;
    }

}
