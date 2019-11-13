package easy;

import java.util.HashSet;
import java.util.Set;

/*
    In a deck of cards, each card has an integer written on it.

    Return true if and only if you can choose X >= 2 such that it is possible
    to split the entire deck into 1 or more groups of cards, where:

    Each group has exactly X cards.
    All the cards in each group have the same integer.
 */
public class XOfKindInDeckOfCards {

    public static void main(String... args) {

        int[] deck = {1, 1, 2, 2, 2, 2};
        XOfKindInDeckOfCards xOfKindInDeckOfCards = new XOfKindInDeckOfCards();
        System.out.println(xOfKindInDeckOfCards.hasGroupsSizeX(deck));
    }

    public boolean hasGroupsSizeX(int[] deck) {

        int[] f = new int[10000];
        for (int x : deck) f[x]++;
        Set<Integer> set = new HashSet<>();
        int min = 10000;

        for (int i = 0; i < 10000; i++)
            if (f[i] == 1) return false;
            else if (f[i] != 0) {
                min = Math.min(min, f[i]);
                set.add(i);
            }

        for (int i = 2; i <= min; i++) {

            boolean flag = true;

            for (int x : set)
                if (f[x] % i != 0) {
                    flag = false;
                    break;
                }

            if (flag) return true;
        }

        return false;
    }

}
