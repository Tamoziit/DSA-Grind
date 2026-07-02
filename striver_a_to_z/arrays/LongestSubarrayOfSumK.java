
import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayOfSumK {

    /**
     * Hashmap + Prefix Sum (Optimal for +ves, -ves & 0s, NOT optimal for only
     * +ves) Time: O(NlgN) Space: O(N)
     */
    public int longestSubarray1(int[] nums, int k) {
        Map<Long, Integer> presumMap = new HashMap<>();
        int res = Integer.MIN_VALUE;
        long sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k) {
                res = Math.max(res, i + 1);
            }

            long rem = sum - k;
            int idx = presumMap.getOrDefault(rem, -1);
            if (idx != -1) { // if (x - k) presum found, update max
                res = Math.max(res, i - idx);
            }

            if (presumMap.getOrDefault(sum, -1) == -1) {
                presumMap.put(sum, i); // only update if sum doesn't exist [account for 0s]
            }
        }

        return res == Integer.MIN_VALUE ? 0 : res;
    }

    /**
     * 2-Pointer Sliding Window - Optimal for only +ves
     * Time: O(N)
     * Space: O(1)
     */
    public int longestSubarray2(int[] nums, int k) {
        int left = 0, right = 0;
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        long sum = 0;

        while (right < n) {
            sum += nums[right];

            while (sum > k && left <= right) {
                sum -= nums[left];
                left++;
            }

            if (sum == k) {
                max = Math.max(max, (right - left + 1));
            }

            right++;
        }

        return max == Integer.MIN_VALUE ? 0 : max;
    }
}
