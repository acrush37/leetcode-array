package easy;

import java.util.ArrayList;
import java.util.List;

/*
    Given an array A of 0s and 1s, consider N_i: the i-th subarray from A[0] to A[i]
    interpreted as a binary number (from most-significant-bit to least-significant-bit.)

    Return a list of booleans answer, where answer[i] is true if and only if N_i is divisible by 5.
 */
public class BinaryPrefixDivisibleBy5 {

    public static void main(String... args) {

        int[] A = {0, 1, 1, 1, 1, 1};
        BinaryPrefixDivisibleBy5 binaryPrefixDivisibleBy5 = new BinaryPrefixDivisibleBy5();
        System.out.println(binaryPrefixDivisibleBy5.prefixesDivBy5(A));
    }

    public List<Boolean> prefixesDivBy5(int[] A) {

        int s = 0;
        List<Boolean> result = new ArrayList<>();

        for (int x : A) {
            result.add((s += x) % 5 == 0);
            s = (s << 1) % 5;
        }

        return result;
    }

}
