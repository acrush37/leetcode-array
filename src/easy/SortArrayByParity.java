package easy;

/*
    Given an array A of non-negative integers, return an array consisting of all the even elements of A,
    followed by all the odd elements of A.

    You may return any answer array that satisfies this condition.
 */
public class SortArrayByParity {

    public static void main(String... args) {

        int[] A = {3, 1, 2, 4};
        SortArrayByParity sortArrayByParity = new SortArrayByParity();
        System.out.println(sortArrayByParity.sortArrayByParity(A));
    }

    public int[] sortArrayByParity(int[] A) {

        int k = 0;
        int[] f = new int[A.length];
        for (int a : A) if ((a & 1) == 0) f[k++] = a;
        for (int a : A) if ((a & 1) == 1) f[k++] = a;
        return f;
    }

}
