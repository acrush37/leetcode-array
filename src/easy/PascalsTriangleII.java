package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
    Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

    Note that the row index starts from 0.
 */
public class PascalsTriangleII {

    public static void main(String... args) {

        PascalsTriangleII pascalsTriangleII = new PascalsTriangleII();
        System.out.println(pascalsTriangleII.getRow(4));
    }

    public List<Integer> getRow(int rowIndex) {


        Integer[] f = new Integer[rowIndex+1];
        f[0] = 1;

        for (int i = 1; i <= rowIndex; i++) {

            f[i] = 0;
            for (int j = i; j > 0; j--) f[j] += f[j-1];
        }


        return Arrays.asList(f);
    }

}
