package easy;

/*
    Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if
    either (a==c and b==d), or (a==d and b==c) - that is, one domino can be rotated to be equal to another domino.

    Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].
 */
public class NumberOfEquivalentDominoPairs {

    public static void main(String... args) {

        int[][] dominoes = {{1, 2}, {2, 1}, {3, 4}, {5, 6}};
        NumberOfEquivalentDominoPairs numberOfEquivalentDominoPairs = new NumberOfEquivalentDominoPairs();
        System.out.println(numberOfEquivalentDominoPairs.numEquivDominoPairs(dominoes));
    }

    public int numEquivDominoPairs(int[][] dominoes) {

        int result = 0;
        int[][] f = new int[10][10];

        for (int[] x : dominoes)
            if (x[0] <= x[1]) f[x[0]][x[1]]++;
            else f[x[1]][x[0]]++;

        for (int i = 1; i <= 9; i++)
            for (int j = i; j <= 9; j++)
                result += (f[i][j] * (f[i][j] - 1)) >> 1;

        return result;
    }

}
