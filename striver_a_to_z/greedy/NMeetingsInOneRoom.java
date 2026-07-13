/**
 * Time: O(NlgN) + O(N)
 * Space: O(N) [fixed 3 cols. for n rows in meetings[n][3]]
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class NMeetingsInOneRoom {

    public ArrayList<Integer> maxMeetings(int[] s, int[] f) {
        int n = s.length;
        int[][] meetings = new int[n][3]; // for storing <start, end, pos.> of each meeting

        for (int i = 0; i < n; i++) {
            meetings[i][0] = s[i];
            meetings[i][1] = f[i];
            meetings[i][2] = i + 1;
        }

        // greedy: sorting based on faster ending time, to accomodate more meetings
        Arrays.sort(meetings, (a, b) -> a[1] - b[1]);

        ArrayList<Integer> order = new ArrayList<>(); // to store the order of the meetings

        // initial: 1st meeting is always attended (after greedy sorting)
        int count = 1;
        order.add(meetings[0][2]); // adding the og position of the 1st meeting
        int freetime = meetings[0][1]; // latest free time after which a new meeting can be scheduled

        for (int[] m : meetings) {
            if (m[0] > freetime) { // start of curr. meeting > latest free time
                freetime = m[1]; // new free time
                order.add(m[2]);
                count++;
            }
        }

        System.out.println("Max meetings that can be attended = " + count);

        Collections.sort(order); // sorting by original index before returning
        return order;
    }
}
