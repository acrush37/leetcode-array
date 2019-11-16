package medium;

/*
    Given an array of integers A, a move consists of choosing any A[i], and incrementing it by 1.

    Return the least number of moves to make every value in A unique.
 */
public class MinimumIncrementToMakeArrayUnique {

    public static void main(String... args) {

        int[] A = {3, 2, 1, 2, 1, 7};
        MinimumIncrementToMakeArrayUnique minimumIncrementToMakeArrayUnique = new MinimumIncrementToMakeArrayUnique();
        System.out.println(minimumIncrementToMakeArrayUnique.minIncrementForUnique(A));
    }

    public int minIncrementForUnique(int[] A) {

        int result = 0;
        boolean[] t = new boolean[80000];

        for (int x : A)
            if (!t[x]) t[x] = true;
            else for (int i = 1; ; i++)
                if (!t[x+i]) {

                    t[x+i] = true;
                    result += i;
                    break;
                }

        return result;
    }

}
