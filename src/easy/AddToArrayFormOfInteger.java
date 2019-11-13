package easy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/*
    For a non-negative integer X, the array-form of X is an array of its digits in left to right order.
    For example, if X = 1231, then the array form is [1,2,3,1].

    Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.
 */
public class AddToArrayFormOfInteger {

    public static void main(String... args) {

        int[] A = {1, 2, 0, 0};
        AddToArrayFormOfInteger addToArrayFormOfInteger = new AddToArrayFormOfInteger();
        System.out.println(addToArrayFormOfInteger.addToArrayForm(A, 34));
    }

    public List<Integer> addToArrayForm(int[] A, int K) {

        String s = "";
        for (int x : A) s += x;
        char[] ch = new BigInteger(s).add(BigInteger.valueOf(K)).toString().toCharArray();
        List<Integer> list = new ArrayList<>();
        for (char c : ch) list.add(c - 48);
        return list;
    }

}
