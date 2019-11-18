package medium;

/*
    Given a non-negative integer, you could swap two digits at most once to get the maximum valued number.

    Return the maximum valued number you could get.
 */
public class MaximumSwap {

    public static void main(String... args) {

        MaximumSwap maximumSwap = new MaximumSwap();
        System.out.println(maximumSwap.maximumSwap(98368));
    }

    public int maximumSwap(int num) {

        char[] c = (num + "").toCharArray();
        int n = c.length;

        for (int i = 0; i < n-1; i++) {

            int p = i;

            for (int j = i+1; j < n; j++)
                if (c[j] >= c[p])
                    p = j;

            if (c[p] > c[i]) {

                char t = c[p];
                c[p] = c[i];
                c[i] = t;
                break;
            }
        }

        return Integer.parseInt(String.valueOf(c));
    }

}
