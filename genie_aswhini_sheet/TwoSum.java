/**
 * 2-Sum - Optimal One-pass HashMap
 * Time: O(n)
 * Space: O(n)
 */
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            int idx = map.getOrDefault(diff, -1);

            if (idx != -1) {
                res[0] = Math.min(idx, i);
                res[1] = Math.max(idx, i);
                break;
            }

            map.put(nums[i], i);
        }

        return res;
    }
}
