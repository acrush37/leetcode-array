package easy;

import java.util.ArrayList;
import java.util.List;

/*
    Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

    The digits are stored such that the most significant digit is at the head of the list,
    and each element in the array contain a single digit.

    You may assume the integer does not contain any leading zero, except the number 0 itself.
 */
public class PlusOne {

    public static void main(String... args) {

        int[] digits = {9, 8, 9, 9};
        PlusOne plusOne = new PlusOne();
        System.out.println(plusOne.plusOne(digits));
    }

    public int[] plusOne(int[] digits) {

        int n = digits.length;
        List<Integer> list = new ArrayList<>();
        int s = 1;

        for (int i = n-1; i >= 0; i--) {

            s += digits[i];
            list.add(s % 10);
            s /= 10;
        }

        if (s == 1) list.add(1);
        n = list.size();
        int[] f = new int[n];
        int k = n-1;
        for (int x : list) f[k--] = x;
        return f;
    }

}
