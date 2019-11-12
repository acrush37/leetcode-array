package easy;

/*
    Let's define a function f(s) over a non-empty string s, which calculates the frequency of the smallest character in s.
    For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.

    Now, given string arrays queries and words, return an integer array answer, where each answer[i]
    is the number of words such that f(queries[i]) < f(W), where W is a word in words.
 */
public class CompareStringsByFrequencyOfSmallestCharacter {

    public static void main(String... args) {

        String[] queries = {"bbb", "cc"};
        String[] words = {"a", "aa", "aaa", "aaaa"};
        CompareStringsByFrequencyOfSmallestCharacter compareStringsByFrequencyOfSmallestCharacter = new CompareStringsByFrequencyOfSmallestCharacter();
        System.out.println(compareStringsByFrequencyOfSmallestCharacter.numSmallerByFrequency(queries, words));
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {

        int m = queries.length;
        int n = words.length;
        int[] f = new int[m];
        int[] t = new int[n];

        for (int i = 0; i < n; i++) {

            int[] a = new int[123];
            char[] ch = words[i].toCharArray();
            for (char c : ch) a[c]++;

            for (char j = 'a'; j <= 'z'; j++)
                if (a[j] != 0) {
                    t[i] = a[j];
                    break;
                }
        }

        for (int i = 0; i < m; i++) {

            int[] a = new int[123];
            char[] ch = queries[i].toCharArray();
            for (char c : ch) a[c]++;

            for (char j = 'a'; j <= 'z'; j++)
                if (a[j] != 0) {

                    for (int k = 0; k < n; k++)
                        if (a[j] < t[k])
                            f[i]++;

                    break;
                }
        }

        return f;
    }

}
