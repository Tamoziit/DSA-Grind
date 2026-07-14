/**
 * Greedy
 * Time: O(NlgN + N)
 * Space: O(1)
 */
import java.util.Arrays;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int prevEnd = Integer.MIN_VALUE, removed = 0;

        // greedy: sort in asc. order by end time, so that intervals that end later can be removed -> intervals that end later take up more time, causing more overlaps across the timeline
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        for (int i = 0; i < n; i++) {
            if (intervals[i][0] >= prevEnd) { // start of curr. interval >= end of prev. interval [no overlap -> interval starts after end of prev. non-overlapping interval]
                prevEnd = intervals[i][1]; // new end time
            } else { // larger end time -> curr interval starts before prev. interval could end
                removed++;
            }
        }

        return removed;
    }
}
