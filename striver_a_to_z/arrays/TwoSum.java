/**
 * HashMap
 * Time: O(N)
 * Space: O(N)
 */
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            int idx = map.getOrDefault(rem, -1);

            if (idx != -1) {
                ans[0] = Math.min(i, idx);
                ans[1] = Math.max(i, idx);
                return ans;
            }

            map.put(nums[i], i);
        }

        return ans;
    }
}
