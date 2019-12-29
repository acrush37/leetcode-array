package easy;

/*
    Given an array arr, replace every element in that array with the greatest element
    among the elements to its right, and replace the last element with -1.
 */
public class ReplaceElementsWithGreatestElementOnRightSide {

    public static void main(String... args) {

        int[] arr = {17, 18, 5, 4, 6, 1};
        ReplaceElementsWithGreatestElementOnRightSide replaceElementsWithGreatestElementOnRightSide = new ReplaceElementsWithGreatestElementOnRightSide();
        System.out.println(replaceElementsWithGreatestElementOnRightSide.replaceElements(arr));
    }

    public int[] replaceElements(int[] arr) {

        int n = arr.length, max = arr[n-1];

        for (int i = n-1; i >= 0; i--) {
            int x = arr[i];
            arr[i] = max;
            max = Math.max(max, x);
        }

        arr[n-1] = -1;
        return arr;
    }

}
