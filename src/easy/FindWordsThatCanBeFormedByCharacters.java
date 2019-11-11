package easy;

import java.util.Arrays;

/*
    You are given an array of strings words and a string chars.

    A string is good if it can be formed by characters from chars (each character can only be used once).

    Return the sum of lengths of all good strings in words.
 */
public class FindWordsThatCanBeFormedByCharacters {

    public static void main(String... args) {

        String[] words = {"cat", "bt", "hat", "tree"};
        FindWordsThatCanBeFormedByCharacters findWordsThatCanBeFormedByCharacters = new FindWordsThatCanBeFormedByCharacters();
        System.out.println(findWordsThatCanBeFormedByCharacters.countCharacters(words, "atach"));
    }

    public int countCharacters(String[] words, String chars) {

        int sum = 0;
        int[] f = new int[26];
        char[] ch = chars.toCharArray();
        for (char c : ch) f[c-97]++;

        for (String word : words) {

            boolean flag = true;
            char[] w = word.toCharArray();
            int[] t = Arrays.copyOf(f, 26);

            for (char c : w) {
                if (--t[c-97] < 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) sum += w.length;
        }

        return sum;
    }

}
