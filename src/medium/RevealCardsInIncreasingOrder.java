package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    In a deck of cards, every card has a unique integer.  You can order the deck in any order you want.
    Initially, all the cards start face down (unrevealed) in one deck.
    Now, you do the following steps repeatedly, until all cards are revealed:

    Take the top card of the deck, reveal it, and take it out of the deck.
    If there are still cards in the deck, put the next top card of the deck at the bottom of the deck.
    If there are still unrevealed cards, go back to step 1.  Otherwise, stop.

    Return an ordering of the deck that would reveal the cards in increasing order.
 */
public class RevealCardsInIncreasingOrder {

    public static void main(String... args) {

        int[] deck = {17, 13, 11, 2, 3, 5, 7};
        RevealCardsInIncreasingOrder revealCardsInIncreasingOrder = new RevealCardsInIncreasingOrder();
        System.out.println(revealCardsInIncreasingOrder.deckRevealedIncreasing(deck));
    }

    public int[] deckRevealedIncreasing(int[] deck) {

        Arrays.sort(deck);
        int n = deck.length;
        int[] result = new int[n];
        List<Integer> t = new ArrayList<>();
        t.add(deck[n-1]);

        for (int i = n-2; i >= 0; i--) {
            t.add(0, t.remove(t.size()-1));
            t.add(0, deck[i]);
        }

        for (int i = 0; i < n; i++) result[i] = t.get(i);
        return result;
    }

}
