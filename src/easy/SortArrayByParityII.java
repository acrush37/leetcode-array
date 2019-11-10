package easy;

/*
    Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.

    Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.

    You may return any answer array that satisfies this condition.
 */
public class SortArrayByParityII {

    public static void main(String... args) {

        int[] A = {4, 2, 5, 7};
        SortArrayByParityII sortArrayByParityII = new SortArrayByParityII();
        System.out.println(sortArrayByParityII.sortArrayByParityII(A));
    }

    public int[] sortArrayByParityII(int[] A) {

        int i = 0;
        int j = 1;
        int[] f = new int[A.length];

        for (int a : A)
            if ((a & 1) == 0) {
                f[i] = a;
                i += 2;
            } else {
                f[j] = a;
                j += 2;
            }

        return f;
    }

}
