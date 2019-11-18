package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    Given a sorted integer array without duplicates, return the summary of its ranges.
 */
public class SummaryRanges {

    public static void main(String... args) {

        int[] nums =  {0, 1, 2};
        SummaryRanges summaryRanges = new SummaryRanges();
        System.out.println(summaryRanges.summaryRanges(nums));
    }

    public List<String> summaryRanges(int[] nums) {

        int n = nums.length;
        if (n == 0) return Collections.EMPTY_LIST;
        List<String> result = new ArrayList<>();
        String s = nums[0] + "";

        for (int i = 1; i < n; i++)
            if (nums[i] == 1 + nums[i-1]) s += "->" + nums[i];
            else {
                String[] x = s.split("->");
                int m = x.length;
                result.add(m == 1 ? x[0] + "" : x[0] + "->" + x[m-1]);
                s = nums[i] + "";
            }

        String[] x = s.split("->");
        int m = x.length;
        result.add(m == 1 ? x[0] + "" : x[0] + "->" + x[m-1]);
        return result;
    }

}
