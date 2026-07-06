
import java.util.ArrayList;
import java.util.Collections;

public class LeadersInArray {

    /**
     * Monotonic Stack
     * Time: O(N) [amortized]
     * Space: O(N)
     */
    public ArrayList<Integer> leaders_1(int arr[]) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length;
        res.add(arr[0]);

        for (int i = 1; i < n; i++) {
            while (!res.isEmpty() && res.get(res.size() - 1) < arr[i]) {
                res.remove(res.size() - 1);
            }

            res.add(arr[i]);
        }

        return res;
    }

    /**
     * Right-to-Left traversal
     * Time: O(N)
     * Space: O(N)
     */
    public ArrayList<Integer> leaders_2(int arr[]) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length;
        int maxFromRight = arr[n - 1]; // default

        res.add(maxFromRight);

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= maxFromRight) { // [61, 61, 7] -> bith [61, 61] are leaders by defn.
                res.add(arr[i]);
                maxFromRight = arr[i];
            }
        }

        // r-to-l traversal: leaders were added in reverse order, so we reverse res to get the correct order
        Collections.reverse(res);
        return res;
    }
}
