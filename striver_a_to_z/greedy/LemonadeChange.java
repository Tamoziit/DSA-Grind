/**
 * Greedy
 * Time: O(N)
 * Space: O(1) [constant 3-key hashmap]
 */
import java.util.HashMap;
import java.util.Map;

public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> denom = new HashMap<>();
        // initializing map
        denom.put(5, 0);
        denom.put(10, 0);
        denom.put(20, 0);

        for (int bill : bills) {
            if (bill == 5) {
                denom.put(5, denom.get(5) + 1); // we receive 5$
            } else if (bill == 10) {
                if (denom.get(5) == 0) {
                    return false; // no sufficient change available
                } else {
                    denom.put(10, denom.get(10) + 1); // we receive 10$
                    denom.put(5, denom.get(5) - 1); // to return: 5$
                }
            } else if (bill == 20) {
                // greedy choice: using higher value denom. = 10$ first over 5$
                if (denom.get(5) > 0 && denom.get(10) > 0) { // both 10 & 5 change available
                    // to return: 10$ + 5$ = 15$
                    denom.put(10, denom.get(10) - 1);
                    denom.put(5, denom.get(5) - 1);

                    denom.put(20, denom.get(20) + 1); // we receive 20$
                } else if (denom.get(5) >= 3) { // 10$ not available but 3*5 = 15$ available
                    denom.put(5, denom.get(5) - 3); // 15$ change given
                    denom.put(20, denom.get(20) + 1);
                } else {
                    return false; // no sufficient change available
                }
            }
        }

        return true; // all orders processed
    }
}
