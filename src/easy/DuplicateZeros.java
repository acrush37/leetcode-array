package easy;

import java.util.Arrays;

/*
    Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

    Note that elements beyond the length of the original array are not written.

    Do the above modifications to the input array in place, do not return anything from your function.
 */
public class DuplicateZeros {

    public static void main(String... args) {

        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        DuplicateZeros duplicateZeros = new DuplicateZeros();
        duplicateZeros.duplicateZeros(arr);
    }

    public void duplicateZeros(int[] arr) {

        int k = 0;
        int n = arr.length;
        int[] f = Arrays.copyOf(arr, n);

        for (int x : f) {

            arr[k++] = x;
            if (k == n) break;

            if (x == 0) {
                arr[k++] = 0;
                if (k == n) break;
            }
        }
    }

}
