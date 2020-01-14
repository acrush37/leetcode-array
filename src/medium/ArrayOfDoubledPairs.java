package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.Map.Entry;

/*
    Given an array of integers A with even length, return true if and only if it is possible
    to reorder it such that A[2 * i + 1] = 2 * A[2 * i] for every 0 <= i < len(A) / 2.
 */
public class ArrayOfDoubledPairs {

    public static void main(String... args) {

        int[] A = {4, -2, 2, -4};
        ArrayOfDoubledPairs arrayOfDoubledPairs = new ArrayOfDoubledPairs();
        System.out.println(arrayOfDoubledPairs.canReorderDoubled(A));
    }

    public boolean canReorderDoubled(int[] A) {

        boolean zero = false, negative = false;
        Map<Integer, Integer> f = new HashMap<>();

        for (int x : A)
            if (x == 0) zero = !zero;
            else {
                if (x < 0) {
                    x = -x;
                    negative = !negative;
                }

                Integer y = f.get(x);
                f.put(x, y == null ? 1 : 1 + y);
            }

        if (zero || negative) return false;

        while (!f.isEmpty()) {

            boolean flag = true;
            Set<Integer> a = new HashSet<>(f.keySet());

            for (int x : a)
                if ((x & 1) == 1) {

                    int k = f.get(x), z = x << 1;
                    Integer y = f.get(z);
                    if (y == null || (y -= k) < 0) return false;
                    f.remove(x);
                    flag = false;

                    if (y == 0) f.remove(z);
                    else f.put(z, y);
                }

            if (flag) {

                Set<Entry<Integer, Integer>> t = f.entrySet();
                Map<Integer, Integer> m = new HashMap<>();
                for (Entry<Integer, Integer> e : t) m.put(e.getKey() >> 1, e.getValue());
                f = m;
            }
        }

        return true;
    }

}
