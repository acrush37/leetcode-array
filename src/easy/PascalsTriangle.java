package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 */
public class PascalsTriangle {

    public static void main(String... args) {

        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        System.out.println(pascalsTriangle.generate(3));
    }

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result;
        result.add(Arrays.asList(1));

        for (int i = 1; i < numRows; i++) {

            Integer[] a = new Integer[i];
            result.get(i-1).toArray(a);
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 0; j < i-1; j++) list.add(a[j] + a[j+1]);
            list.add(1);
            result.add(list);
        }

        return result;
    }

}
