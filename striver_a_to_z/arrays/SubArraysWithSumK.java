/**
 * Prefix Sum Frequency - No. of Subarrays with sum K
 * Time: O(N)
 * Space: O(N)
 */
import java.util.HashMap;
import java.util.Map;

public class SubArraysWithSumK {

    public int subarraySum(int[] nums, int k) {
        Map<Long, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0L, 1);

        long sum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            long rem = sum - k;

            count += prefixCount.getOrDefault(rem, 0);

            prefixCount.put(rem, prefixCount.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
