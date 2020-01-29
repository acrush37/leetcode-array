package medium;

import java.util.ArrayList;
import java.util.List;

/*
    Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.
 */
public class NumberOfMatchingSubsequences {

    public static void main(String... args) {

        String[] words = {"a", "bb", "acd", "ace"};
        NumberOfMatchingSubsequences numberOfMatchingSubsequences = new NumberOfMatchingSubsequences();
        System.out.println(numberOfMatchingSubsequences.numMatchingSubseq("abcde", words));
    }

    private boolean find(List<Integer>[] f, String s) {

        int x = -1;

        for (int i = 0; i < s.length(); i++)
            if ((x = search(f[s.charAt(i)-97], x) + 1) == 0)
                return false;

        return true;
    }

    private int search(List<Integer> t, int x) {

        if (t.isEmpty()) return -1;
        int left = 0, right = t.size();

        while (left < right) {

            int mid = (left + right) >> 1;

            if (t.get(mid) < x) left = mid + 1;
            else right = mid;
        }

        return left >= t.size() ? -1 : t.get(left);
    }

    public int numMatchingSubseq(String s, String[] words) {

        int result = 0;
        List<Integer>[] f = new List[26];
        for (int i = 0; i < 26; i++) f[i] = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) f[s.charAt(i) - 97].add(i);
        for (String word : words) if (find(f, word)) result++;
        return result;
    }

}
