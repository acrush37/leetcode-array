package medium;

import java.util.ArrayList;
import java.util.List;

/*
    Write an iterator that iterates through a run-length encoded sequence.

    The iterator is initialized by RLEIterator(int[] A), where A is a run-length encoding of some sequence.
    More specifically, for all even i, A[i] tells us the number of times that the non-negative integer value A[i+1] is repeated in the sequence.

    The iterator supports one function: next(int n), which exhausts the next n elements (n >= 1) and returns
    the last element exhausted in this way.  If there is no element left to exhaust, next returns -1 instead.

    For example, we start with A = [3,8,0,9,2,5], which is a run-length encoding of the sequence [8,8,8,5,5].
    This is because the sequence can be read as "three eights, zero nines, two fives".
 */
public class RleIterator {

    private int k;

    private long m;

    private int[] a;

    public static void main(String... args) {

        int[] A = {3, 8, 0, 9, 2, 5};
        RleIterator rleIterator = new RleIterator(A);
        System.out.println(rleIterator.next(2));
        System.out.println(rleIterator.next(1));
        System.out.println(rleIterator.next(1));
        System.out.println(rleIterator.next(2));
    }

    public RleIterator(int[] A) {

        a = A;
        for (int i = 0; i < a.length; i += 2) m += a[i];
    }

    public int next(int n) {

        if ((m -= n) < 0) return -1;

        while (true)
            if (n < a[k]) {
                a[k] -= n;
                return a[k+1];
            } else if (n > a[k]) {
                n -= a[k];
                k += 2;
            } else {
                k += 2;
                return a[k-1];
            }
    }

}
