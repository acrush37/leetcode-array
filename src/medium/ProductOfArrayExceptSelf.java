package medium;

/*
    Given an array nums of n integers where n > 1,  return an array output such that
    output[i] is equal to the product of all the elements of nums except nums[i].
 */
public class ProductOfArrayExceptSelf {

    public static void main(String... args) {

        int[] nums = {9, 0, -2};
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        System.out.println(productOfArrayExceptSelf.productExceptSelf(nums));
    }

    public int[] productExceptSelf(int[] nums) {

        int s = 1;
        int count = 0;
        int n = nums.length;

        for (int x : nums) if (x == 0) count++; else s *= x;

        for (int i = 0; i < n; i++)
            if (count > 1) nums[i] = 0;
            else if (count == 0) nums[i] = s / nums[i];
            else nums[i] = nums[i] == 0 ? s : 0;

        return nums;
    }

}
