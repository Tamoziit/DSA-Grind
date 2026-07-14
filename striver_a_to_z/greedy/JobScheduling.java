/**
 * Time: O(NlgN + M.m); m = max deadline
 * Space = O(N + m)
 */
import java.util.ArrayList;
import java.util.Arrays;

public class JobScheduling {

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = i + 1;
            jobs[i][1] = deadline[i];
            jobs[i][2] = profit[i];
        }

        // greedy: sortiing jobs according to max profit to maximize totalProfit
        Arrays.sort(jobs, (a, b) -> b[2] - a[2]);

        int totalProfit = 0, count = 0, maxDeadline = -1;

        // finding last deadline upto which a job can be delayed to
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }

        // to track jobs done & on which day
        int[] jobsDone = new int[maxDeadline + 1];
        for (int i = 1; i <= maxDeadline; i++) { // days from [1...maxDeadline]
            jobsDone[i] = -1;
        }

        // maximizing profit till day 'j'
        for (int i = 0; i < n; i++) {
            for (int j = jobs[i][1]; j >= 1; j--) { // delaying job till day-n (deadline), then n-1, n-2,...,1
                if (jobsDone[j] == -1) { // day free
                    count++;
                    totalProfit += jobs[i][2];
                    jobsDone[j] = jobs[i][0]; // job id marked as done on day 'j'

                    break;
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        res.add(count);
        res.add(totalProfit);

        return res;
    }
}
