package medium;

/*
    Given two integers n and k, you need to construct a list which contains n different
    positive integers ranging from 1 to n and obeys the following requirement:

    Suppose this list is [a1, a2, a3, ... , an], then the list
    [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.
 */
public class BeautifulArrangementII {

    public static void main(String... args) {

        BeautifulArrangementII beautifulArrangementII = new BeautifulArrangementII();
        System.out.println(beautifulArrangementII.constructArray(3, 2));
    }

    public int[] constructArray(int n, int k) {

        int p = 0;
        int[] result = new int[n];
        for (int i = 1; i < n-k; i++) result[p++] = i;
        for (int i = 0; i <= k; i++) result[p++] = (i & 1) == 0 ? (n - k + (i >> 1)) : (n - (i >> 1));
        return result;
    }

}
