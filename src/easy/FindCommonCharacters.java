package easy;

import java.util.ArrayList;
import java.util.List;

/*
    Given an array A of strings made only from lowercase letters,
    return a list of all characters that show up in all strings within the list (including duplicates).

    For example, if a character occurs 3 times in all strings but not 4 times,
    you need to include that character three times in the final answer.
 */
public class FindCommonCharacters {

    public static void main(String... args) {

        String[] A = {"bella", "label", "roller"};
        FindCommonCharacters findCommonCharacters = new FindCommonCharacters();
        System.out.println(findCommonCharacters.commonChars(A));
    }

    public List<String> commonChars(String[] A) {

        int n = A.length;
        List<String> result = new ArrayList<>();
        int[][] f = new int[123][n];

        for (int i = 0; i < n; i++) {

            char[] ch = A[i].toCharArray();
            for (char c : ch) f[c][i]++;
        }

        for (char c = 'a'; c <= 'z'; c++) {

            int min = 100;
            for (int i = 0; i < n; i++) min = Math.min(min, f[c][i]);
            while (min-- > 0) result.add(c + "");
        }

        return result;
    }

}
