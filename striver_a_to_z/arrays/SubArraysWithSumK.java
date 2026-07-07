/**
 * Prefix Sum Frequency - No. of Subarrays with sum K
 * Time: O(N)
 * Space: O(N)
 */
import java.util.HashMap;
import java.util.Map;

public class SubArraysWithSumK {

    public int subarraySum(int[] nums, int k) {
        Map<Long, Integer> preSumFreq = new HashMap<>();
        long preSum = 0;
        int count = 0;

        // Base case: prefix sum 0 has occurred once
        preSumFreq.put(0l, 1);

        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            long rem = preSum - k;

            count += preSumFreq.getOrDefault(rem, 0); // if not present, add 0 by default

            // update x - k count for subarray k
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }
}
