package medium;

import java.util.ArrayList;
import java.util.List;

/*
    Given an array A, we can perform a pancake flip: We choose some positive integer k <= A.length,
    then reverse the order of the first k elements of A.  We want to perform zero or more pancake
    flips (doing them one after another in succession) to sort the array A.

    Return the k-values corresponding to a sequence of pancake flips that sort A.
    Any valid answer that sorts the array within 10 * A.length flips will be judged as correct.
 */
public class PancakeSorting {

    public static void main(String... args) {

        int[] A = {3, 2, 4, 1};
        PancakeSorting pancakeSorting = new PancakeSorting();
        System.out.println(pancakeSorting.pancakeSort(A));
    }

    public List<Integer> pancakeSort(int[] A) {

        int n = A.length;
        List<Integer> result = new ArrayList<>();

        for (int i = n-1; i >= 0; i--)
            if (A[i] != i+1) {

                int j = i-1;
                while (A[j] != i+1) j--;
                result.add(j+1);
                result.add(i+1);
                int p = (j + 1) >> 1;

                for (int k = 0; k < p; k++) {
                    int t = A[k];
                    A[k] = A[j-k];
                    A[j-k] = t;
                }

                p = (i + 1) >> 1;

                for (int k = 0; k < p; k++) {
                    int t = A[k];
                    A[k] = A[i-k];
                    A[i-k] = t;
                }
            }

        return result;
    }

}
