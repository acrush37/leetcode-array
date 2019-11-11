package easy;

/*
    In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.

    There is at least one empty seat, and at least one person sitting.

    Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.

    Return that maximum distance to closest person.
 */
public class MaximizeDistanceToClosestPerson {

    public static void main(String... args) {

        int[] seats = {1, 0, 0, 0};
        MaximizeDistanceToClosestPerson maximizeDistanceToClosestPerson = new MaximizeDistanceToClosestPerson();
        System.out.println(maximizeDistanceToClosestPerson.maxDistToClosest(seats));
    }

    public int maxDistToClosest(int[] seats) {

        int k = 0;
        int n = seats.length;
        while (seats[k] == 0) k++;
        int max = k;

        for (int i = k+1; i < n; i++)
            if (seats[i] == 1) {
                max = Math.max(max, (i - k) >> 1);
                k = i;
            }

        return Math.max(max, n-k-1);
    }

}
