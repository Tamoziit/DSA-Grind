/**
 * Time: O(N)
 * Space: O(1)
 */
public class JumpGame1 {

    public boolean canJump(int[] nums) {
        int maxIdx = 0; // to store the farthest idx we can reach from idx i

        for (int i = 0; i < nums.length; i++) {
            if (i > maxIdx) {
                // we never reached idx i (since, maxIdx < i)
                // hence, we cannot possibly reach idx n - 1 from subsequent jumps
                return false;
            }

            // greedy step: tracking farthest idx we can reach from [0..i]
            maxIdx = Math.max(maxIdx, i + nums[i]);

            if (maxIdx >= nums.length - 1) {
                return true; // we recahed the end idx = n - 1
            }
        }

        return true;
    }
}
