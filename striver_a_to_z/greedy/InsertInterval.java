
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    /**
     * Expanding Merge Intervals Algo
     * Time: O(NlgN + N)
     * Space: O(N + 1)
     */
    public int[][] insert_1(int[][] intervals, int[] newInterval) {
        int[][] result = Arrays.copyOf(intervals, intervals.length + 1);
        result[intervals.length] = newInterval;
        return merge(result);
    }

    private int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int[][] result = new int[n][2];

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int k = 0, currIdx = 0, i;
        while (currIdx < n) {
            for (i = currIdx + 1; i < n; i++) {
                if (intervals[i][0] <= intervals[currIdx][1]) {
                    if (intervals[i][1] > intervals[currIdx][1]) {
                        intervals[currIdx][1] = intervals[i][1];
                    }
                } else {
                    break;
                }
            }

            result[k][0] = intervals[currIdx][0];
            result[k][1] = intervals[currIdx][1];
            k++;
            currIdx = i;
        }

        return Arrays.copyOfRange(result, 0, k);
    }

    /**
     * Greedy
     * Time: O(N)
     * Space: O(N)
     */
    public int[][] insert_2(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int n = intervals.length, i = 0;

        // left half
        while (i < n && intervals[i][1] < newInterval[0]) { // interval ends before new interval starts
            result.add(intervals[i]);
            i++;
        }

        // overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) { // interval starts earlier than/at the same time as end of new interval
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]); // lower bound of overlap
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]); // upper bound of overlap
            i++;
        }
        result.add(newInterval); // adding the overlapping interval

        // right half: all intervals that start after new interval ends
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
