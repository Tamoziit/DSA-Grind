/**
 * Greedy
 * Time: O(N)
 * Space: O(1)
 */
import java.util.Arrays;

public class ShortestJobFirst {

    public long solve(int[] bt) {
        // greedy: sorting according to shortest job to decrease waiting time
        Arrays.sort(bt);

        long time = 0l, totalWaitingTime = 0l;

        for (int i = 0; i < bt.length; i++) {
            totalWaitingTime += time; // waiting for time which has passed uptil now
            time += bt[i]; // completing the whole burst to get new time when a process can be scheduled
        }

        long avgWT = (long) Math.floor(totalWaitingTime / bt.length);
        return avgWT;
    }
}
