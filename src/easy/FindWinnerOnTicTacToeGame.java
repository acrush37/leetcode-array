package easy;

/*
    Tic-tac-toe is played by two players A and B on a 3 x 3 grid.

    Given an array moves where each element is another array of size 2 corresponding to the row and
    column of the grid where they mark their respective character in the order in which A and B play.

    Return the winner of the game if it exists (A or B), in case the game ends in
    a draw return "Draw", if there are still movements to play return "Pending".
 */
public class FindWinnerOnTicTacToeGame {

    public static void main(String... args) {

        int[][] moves = {{0, 0}, {1, 1}, {0, 1}, {0, 2}, {1, 0}, {2, 0}};
        FindWinnerOnTicTacToeGame findWinnerOnTicTacToeGame = new FindWinnerOnTicTacToeGame();
        System.out.println(findWinnerOnTicTacToeGame.tictactoe(moves));
    }

    public String tictactoe(int[][] moves) {

        int n = moves.length;
        if (n <= 4) return "Pending";
        int[][] t = new int[3][3];
        for (int i = 0; i < n; i++) t[moves[i][0]][moves[i][1]] = 1 + (i & 1);

        if ((n & 1) == 1) {

            if (t[0][0] == 1 && t[0][1] == 1 && t[0][2] == 1 || t[1][0] == 1 && t[1][1] == 1 && t[1][2] == 1
                || t[2][0] == 1 && t[2][1] == 1 && t[2][2] == 1 || t[0][0] == 1 && t[1][0] == 1 && t[2][0] == 1
                || t[0][1] == 1 && t[1][1] == 1 && t[2][1] == 1 || t[0][2] == 1 && t[1][2] == 1 && t[2][2] == 1
                || t[0][0] == 1 && t[1][1] == 1 && t[2][2] == 1 || t[0][2] == 1 && t[1][1] == 1 && t[2][0] == 1)
                return "A";
        } else if (t[0][0] == 2 && t[0][1] == 2 && t[0][2] == 2 || t[1][0] == 2 && t[1][1] == 2 && t[1][2] == 2
                || t[2][0] == 2 && t[2][1] == 2 && t[2][2] == 2 || t[0][0] == 2 && t[1][0] == 2 && t[2][0] == 2
                || t[0][1] == 2 && t[1][1] == 2 && t[2][1] == 2 || t[0][2] == 2 && t[1][2] == 2 && t[2][2] == 2
                || t[0][0] == 2 && t[1][1] == 2 && t[2][2] == 2 || t[0][2] == 2 && t[1][1] == 2 && t[2][0] == 2)
            return "B";

        return n == 9 ? "Draw" : "Pending";
    }

}
