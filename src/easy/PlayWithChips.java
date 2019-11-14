package easy;

/*
    There are some chips, and the i-th chip is at position chips[i].

    You can perform any of the two following types of moves any number of times (possibly zero) on any chip:

    Move the i-th chip by 2 units to the left or to the right with a cost of 0.
    Move the i-th chip by 1 unit to the left or to the right with a cost of 1.
    There can be two or more chips at the same position initially.

    Return the minimum cost needed to move all the chips to the same position (any position).
 */
public class PlayWithChips {

    public static void main(String... args) {

        int[] chips = {2, 2, 2, 3, 3};
        PlayWithChips playWithChips = new PlayWithChips();
        System.out.println(playWithChips.minCostToMoveChips(chips));
    }

    public int minCostToMoveChips(int[] chips) {

        int result = Integer.MAX_VALUE;
        int n = chips.length;

        for (int i = 0; i < n; i++) {

            int s = 0;
            for (int j = 0; j < n; j++) s += ((chips[i] - chips[j]) & 1);
            result = Math.min(result, s);
        }

        return result;
    }

}
