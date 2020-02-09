package easy;

import java.util.HashSet;
import java.util.Set;

/*
    Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).

    More formally check if there exists two indices i and j such that :

    i != j
    0 <= i, j < arr.length
    arr[i] == 2 * arr[j]
 */
public class CheckIfDoubleExist {

    public static void main(String... args) {

        int[] arr = {7, 1, 14, 11};
        CheckIfDoubleExist checkIfDoubleExist = new CheckIfDoubleExist();
        System.out.println(checkIfDoubleExist.checkIfExist(arr));
    }

    public boolean checkIfExist(int[] arr) {

        Set<Integer> t = new HashSet<>();

        for (int x : arr) {

            if (t.contains(x << 1)) return true;
            if ((x & 1) == 0 && t.contains(x >> 1)) return true;
            t.add(x);
        }

        return false;
    }

}
