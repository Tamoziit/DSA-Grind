/**
 * Time: O(N)
 * Space: O(1)
 */
public class JumpGame2 {

    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return 0; // already at destination, no jump needed
        }

        int farthest = 0; // furthest index reachable so far
        int currEnd = 0; // boundary of the current jump
        int jumpCnt = 0;

        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == currEnd) { // exhausted current jump's range, must jump again
                jumpCnt++;
                currEnd = farthest;

                if (currEnd >= n - 1) {
                    break; // destination reached
                }
            }
        }

        return jumpCnt;
    }
}
