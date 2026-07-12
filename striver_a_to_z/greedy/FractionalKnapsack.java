/**
 * Greedy - Fractional Knapsack
 * Time: O(NlgN)
 * Space: O(N); for greedy per unit cost precedence
 */
import java.util.Arrays;

public class FractionalKnapsack {

    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        int n = val.length;
        Integer[] idx = new Integer[n]; // indices array to store per unit greedy sequence after sorting
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }

        // Greedy: sorting indices by val[i]/wt[i] in descending order
        Arrays.sort(idx, (a, b) -> Double.compare(
                (double) val[b] / wt[b],
                (double) val[a] / wt[a]
        )); // O(NlgN)

        double totalvalue = 0.0;

        for (int i : idx) { // accessing objects by their greedy precedence -> O(N)
            if (capacity <= 0) {
                break;
            }

            if (wt[i] <= capacity) { // can take full capacity
                totalvalue += val[i];
                capacity -= wt[i];
            } else { // cannot take full capacity -> a fraction taken
                totalvalue += ((double) val[i] / wt[i]) * capacity;
                break; // full capacity of knapsack used
            }
        }

        return totalvalue;
    }
}
