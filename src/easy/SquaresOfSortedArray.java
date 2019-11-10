package easy;

/*
    Given an array of integers A sorted in non-decreasing order, return an array
    of the squares of each number, also in sorted non-decreasing order.
 */
public class SquaresOfSortedArray {

    public static void main(String... args) {

        int[] A = {-7, -3, 2, 3, 11};
        SquaresOfSortedArray squaresOfSortedArray = new SquaresOfSortedArray();
        System.out.println(squaresOfSortedArray.sortedSquares(A));
    }

    public int[] sortedSquares(int[] A) {

        int[] t = new int[10001];
        int[] f = new int[A.length];
        for (int a : A) t[Math.abs(a)]++;
        int k = 0;

        for (int i = 0; i <= 10000; i++)
            for (int j = 0; j < t[i]; j++)
                f[k++] = i*i;

        return f;
    }

}
