/**
 * Greedy
 * Time: O(NlgN + N)
 * Space: O(N)
 */
import java.util.Arrays;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int[][] result = new int[n][2];

        // greedy: Sorting by lower bound of intervals
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
}
