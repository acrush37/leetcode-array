package easy;

/*
    You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.

    Check if these points make a straight line in the XY plane.
 */
public class CheckIfItIsStraightLine {

    public static void main(String... args) {

        int[][] coordinates = {{1, 2}, {2, 3}, {3, 4}, {4,5}};
        CheckIfItIsStraightLine checkIfItIsStraightLine = new CheckIfItIsStraightLine();
        System.out.println(checkIfItIsStraightLine.checkStraightLine(coordinates));
    }

    public boolean checkStraightLine(int[][] coordinates) {

        for (int i = 2; i < coordinates.length; i++)
            if ((coordinates[0][0] - coordinates[1][0]) * (coordinates[1][1] - coordinates[i][1])
                    != (coordinates[0][1] - coordinates[1][1]) * (coordinates[1][0] - coordinates[i][0]) )
                return false;

        return true;
    }

}
