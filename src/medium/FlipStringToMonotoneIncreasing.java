package medium;

/*
    A string of '0's and '1's is monotone increasing if it consists of some number
    of '0's (possibly 0), followed by some number of '1's (also possibly 0.)

    We are given a string S of '0's and '1's, and we may flip any '0' to a '1' or a '1' to a '0'.
    Return the minimum number of flips to make S monotone increasing.
 */
public class FlipStringToMonotoneIncreasing {

    public static void main(String... args) {

        FlipStringToMonotoneIncreasing flipStringToMonotoneIncreasing = new FlipStringToMonotoneIncreasing();
        System.out.println(flipStringToMonotoneIncreasing.minFlipsMonoIncr("010110"));
    }

    public int minFlipsMonoIncr(String S) {

        int n = S.length();
        if (n == 1) return 0;
        int[][] f = new int[2][2];
        char[] c = S.toCharArray();
        int count = 0, k = 0;

        if (c[0] == '0') f[0][1] = 1;
        else f[0][0] = ++count;

        for (int i = 1; i < n; i++) {

            k = i & 1;
            int p = k ^ 1;

            if (c[i] == '0') {
                f[k][0] = f[p][0];
                f[k][1] = 1 + Math.min(f[p][0], f[p][1]);
            } else {
                f[k][0] = ++count;
                f[k][1] = Math.min(f[p][0], f[p][1]);
            }
        }

        return Math.min(f[k][0], f[k][1]);
    }

}
