package hard;

import java.util.ArrayList;
import java.util.List;

/*
    Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

    You may assume that the intervals were initially sorted according to their start times.
 */
public class InsertInterval {

    public static void main(String... args) {

        int[] newInterval = {4, 8};
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        InsertInterval insertInterval = new InsertInterval();
        System.out.println(insertInterval.insert(intervals, newInterval));
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {

        int i = 0, n = intervals.length;
        List<int[]> t = new ArrayList<>();
        while (i < n && intervals[i][1] < newInterval[0]) t.add(intervals[i++]);

        while (i < n && intervals[i][0] <= newInterval[1])
            newInterval = new int[]{Math.min(intervals[i][0], newInterval[0]),
                    Math.max(intervals[i++][1], newInterval[1])};

        t.add(newInterval);
        while (i < n) t.add(intervals[i++]);
        int[][] result = new int[t.size()][2];
        for (i = 0; i < t.size(); i++) result[i] = t.get(i);
        return result;
    }

}
