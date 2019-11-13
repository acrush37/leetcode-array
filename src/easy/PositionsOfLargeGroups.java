package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    In a string S of lowercase letters, these letters form consecutive groups of the same character.

    For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".

    Call a group large if it has 3 or more characters.

    We would like the starting and ending positions of every large group.

    The final answer should be in lexicographic order.
 */
public class PositionsOfLargeGroups {

    public static void main(String... args) {

        PositionsOfLargeGroups positionsOfLargeGroups = new PositionsOfLargeGroups();
        System.out.println(positionsOfLargeGroups.largeGroupPositions("abcdddeeeeaabbbcd"));
    }

    public List<List<Integer>> largeGroupPositions(String S) {

        List<List<Integer>> result = new ArrayList<>();
        char[] c = S.toCharArray();
        int n = c.length;
        int k = 1;

        for (int i = 1; i < n; i++)
            if (c[i] == c[i-1]) k++;
            else {
                if (k >= 3) result.add(Arrays.asList(i-k, i-1));
                k = 1;
            }

        if (k >= 3) result.add(Arrays.asList(n-k, n-1));
        return result;
    }

}
