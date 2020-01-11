package easy;

/*
    We are given a list nums of integers representing a list compressed with run-length encoding.

    Consider each adjacent pair of elements [a, b] = [nums[2*i], nums[2*i+1]] (with i >= 0).  For each such pair, there are a elements with value b in the decompressed list.

    Return the decompressed list.
 */
public class DecompressRunLengthEncodedList {

    public static void main(String... args) {

        int[] nums = {1, 2, 3, 4};
        DecompressRunLengthEncodedList decompressRunLengthEncodedList = new DecompressRunLengthEncodedList();
        System.out.println(decompressRunLengthEncodedList.decompressRLElist(nums));
    }

    public int[] decompressRLElist(int[] nums) {

        int n = 0;
        for (int i = 0; i < nums.length; i += 2) n += nums[i];
        int[] result = new int[n];
        n = 0;

        for (int i = 0; i < nums.length; i += 2)
            for (int j = 0; j < nums[i]; j++)
                result[n++] = nums[i+1];

        return result;
    }

}
