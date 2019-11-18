package medium;

/*
    Given an array A of positive integers, A[i] represents the value of the i-th sightseeing spot, and two sightseeing spots i and j have distance j - i between them.

    The score of a pair (i < j) of sightseeing spots is (A[i] + A[j] + i - j) : the sum of the values of the sightseeing spots, minus the distance between them.

    Return the maximum score of a pair of sightseeing spots.
 */
public class BestSightseeingPair {

    public static void main(String... args) {

        int[] A = {8, 1, 5, 2, 6};
        BestSightseeingPair bestSightseeingPair = new BestSightseeingPair();
        System.out.println(bestSightseeingPair.maxScoreSightseeingPair(A));
    }

    public int maxScoreSightseeingPair(int[] A) {

        int n = A.length;
        int last = A[1] + A[0] - 1;
        int max = last;

        for (int i = 2; i < n; i++)
            max = Math.max(max, last = Math.max(A[i] + A[i-1] -1, last - A[i-1] + A[i] - 1));

        return max;
    }

}
