package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.
 */
public class NumberOfMatchingSubsequences {

    public static void main(String... args) {

        String[] words = {"a", "bb", "acd", "ace"};
        NumberOfMatchingSubsequences numberOfMatchingSubsequences = new NumberOfMatchingSubsequences();
        System.out.println(numberOfMatchingSubsequences.numMatchingSubseq("abcde", words));
    }

    private boolean find(String word, int m, char[] c, Map<String, Integer> t) {

        Integer x = t.get(word);
        if (x != null && x != -1) return true;
        char[] w = word.toCharArray();
        int n = w.length;

        for (int i = n-1; i >= 0; i--) {

            String f = word.substring(0, i);
            x = t.get(f);

            if (x != null) {

                if (x == -1) return false;

                for (int j = i; j < n; j++)
                    while (x++ < m) {

                        t.put(f + c[x-1], j+1);

                        if (c[x-1] == w[j]) {

                            f += c[x-1];
                            break;
                        }
                    }

                x = t.get(word);
                boolean flag = x != null && x != -1;
                if (!flag) t.put(word, -1);
                return flag;
            }
        }

        return false;
    }

    public int numMatchingSubseq(String S, String[] words) {

        int result = 0;
        int m = S.length();
        char[] c = S.toCharArray();
        Map<String, Integer> t = new HashMap<>();
        t.put("", 0);

        Arrays.sort(words, (a, b) -> {
            int x = a.length();
            int y = b.length();
            if (x == y) return a.compareTo(b);
            return x > y ? 1 : -1;
        });

        for (String word : words)
            if (find(word, m, c, t))
                result++;

        return result;
    }

}
