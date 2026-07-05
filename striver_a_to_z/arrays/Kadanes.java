/**
 * Kadane's Algo
 * Time: O(N)
 * Space: O(1)
 */
public class Kadanes {

    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, startIdx = -1, endIdx = -1, start = -1;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum == 0) {
                start = i;
            }

            sum += nums[i];

            if (sum > max) {
                max = sum;
                startIdx = start;
                endIdx = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        System.out.println("Start: " + startIdx + ", End: " + endIdx);
        return max;
    }
}
