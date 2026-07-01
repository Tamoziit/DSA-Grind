/**
 * 2 Pointer - Sliding Window
 * Time: O(n)
 * Space: O(1)
 */
public class MinSubarraySumLength {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0;
        int res = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            // we can update the window by shifting it forward from [left...right] -> [left + 1...right]
            // this is because, we achieved sum >= target, only by adding all eles. in [left...right]
            // we cannot have sum >= target in any window in [left + 1...right]
            // from [left + 1...right], we can calculate sum for new windows by incrementing right (increasing window size)
            while (sum >= target) { // shrinking the window [moving left forward, keeping right static] as much as possible to achieve min window with target sum
                res = Math.min(res, (right - left + 1)); // minimizing window size
                sum -= nums[left]; // updating sum by moving the window forward
                left++; // new window
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
