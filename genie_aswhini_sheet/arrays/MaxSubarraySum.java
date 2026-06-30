/**
 * Kadane's Algo
 * Time: O(N)
 * Space: O(1)
 */
public class MaxSubarraySum {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0, startIdx = -1, endIdx = -1;

        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) {
                startIdx = i; // subarray starts when sum is reset
            }

            sum += nums[i];

            if (sum > max) {
                max = sum;
                endIdx = i; // subarray ends where max is set
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        System.out.println("Start idx = " + startIdx + ", End idx = " + endIdx);
        return max;
    }
}
