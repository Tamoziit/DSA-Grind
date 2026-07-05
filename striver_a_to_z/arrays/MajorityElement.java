
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    /**
     * Hash Map
     * Time: O(N + m); m = no. of unique eles. in the array
     * Space: O(m)
     */
    public int majorityElement_1(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > n / 2) {
                return entry.getKey();
            }
        }

        return -1;
    }

    /**
     * Boyer-Moore Voting Algorithm Walk through the array — if count is 0, pick
     * a new candidate. If the current number matches the candidate, increment
     * count; otherwise decrement it. Because a majority element appears more
     * than n/2 times, it will always "outvote" all other elements combined, so
     * whatever survives at the end is guaranteed to be the majority element
     * (the problem guarantees one exists).
     *
     * Every time you see a non-candidate, it "cancels out" one occurrence of
     * the candidate. Since the majority element occurs more than everything
     * else combined, it can never be fully cancelled out — it always survives
     * as the final candidate.
     *
     * Time: O(N)
     * Space: O(1)
     */
    public int majorityElement_2(int[] nums) {
        int candidate = 0, count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            count += (candidate == num) ? 1 : -1;
        }

        return candidate;
    }
}
