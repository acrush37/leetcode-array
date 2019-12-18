package easy;

/*
    Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time.

    Return that integer.
 */
public class ElementAppearingMoreThan25PercentInSortedArray {

    public static void main(String... args) {

        int[] arr = {1, 2, 2, 6, 6, 6, 6, 7, 10};
        ElementAppearingMoreThan25PercentInSortedArray elementAppearingMoreThan25PercentInSortedArray = new ElementAppearingMoreThan25PercentInSortedArray();
        System.out.println(elementAppearingMoreThan25PercentInSortedArray.findSpecialInteger(arr));
    }

    public int findSpecialInteger(int[] arr) {

        int count = 1, n = arr.length;
        double m = n / 4.0;

        for (int i = 1; i < n; i++)
            if (arr[i] != arr[i-1]) count = 1;
            else if (++count > m) return arr[i];

        return arr[0];
    }

}
