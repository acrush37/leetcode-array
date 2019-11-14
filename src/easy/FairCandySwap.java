package easy;

/*
    Alice and Bob have candy bars of different sizes:
    A[i] is the size of the i-th bar of candy that Alice has, and B[j] is the size of the j-th bar of candy that Bob has.

    Since they are friends, they would like to exchange one candy bar each so that after the exchange, they both have the same total amount of candy.
    (The total amount of candy a person has is the sum of the sizes of candy bars they have.)

    Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange,
    and ans[1] is the size of the candy bar that Bob must exchange.
 */
public class FairCandySwap {

    public static void main(String... args) {

        int[] A = {1, 1};
        int[] B = {2, 2};
        FairCandySwap fairCandySwap = new FairCandySwap();
        System.out.println(fairCandySwap.fairCandySwap(A, B));
    }

    public int[] fairCandySwap(int[] A, int[] B) {

        int x = 0, y = 0;
        boolean[] a = new boolean[100001];
        boolean[] b = new boolean[100001];

        for (int i : A) {
            x += i;
            a[i] = true;
        }

        for (int i : B) {
            y += i;
            b[i] = true;
        }

        x = (x - y) >> 1;

        if (x > 0) {
            for (int i = x+1; i <= 100000; i++)
                if (a[i] && b[i-x])
                    return new int[]{i, i-x};
        } else {
            for (int i = 1-x; i <= 100000; i++)
                if (a[i+x] && b[i])
                    return new int[]{i+x, i};
        }

        return null;
    }

}
