package easy;

/*
    We have an array A of integers, and an array queries of queries.

    For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].
    Then, the answer to the i-th query is the sum of the even values of A.

    (Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies the array A.)

    Return the answer to all queries.  Your answer array should have answer[i] as the answer to the i-th query.
 */
public class SumOfEvenNumbersAfterQueries {

    public static void main(String... args) {

        int[] A = {1, 2, 3, 4};
        int[][] queries = {{1,0}, {-3,1}, {-4,0}, {2,3}};
        SumOfEvenNumbersAfterQueries sumOfEvenNumbersAfterQueries = new SumOfEvenNumbersAfterQueries();
        System.out.println(sumOfEvenNumbersAfterQueries.sumEvenAfterQueries(A, queries));
    }

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {

        int m = queries.length;
        int[] f = new int[m];
        int s = 0;
        for (int x : A) if ((x & 1) == 0) s += x;

        for (int i = 0; i < m; i++) {

            if ((A[queries[i][1]] & 1) == 0) s -= A[queries[i][1]];
            A[queries[i][1]] += queries[i][0];
            if ((A[queries[i][1]] & 1) == 0) s += A[queries[i][1]];
            f[i] = s;
        }

        return f;
    }

}
