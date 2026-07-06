/**
 * Unordered Set
 * Time: O(N + 2N) = O(3N) [amortized]
 * Space: O(N)
 */
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequenceInArray {

    public int longestConsecutive(int[] nums) {
        int n = nums.length, longest = Integer.MIN_VALUE;
        if (n == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) { // O(N)
            set.add(nums[i]);
        }

        for (int num : set) { // O(N)
            if (!set.contains(num - 1)) {
                int count = 1;
                int x = num;

                while (set.contains(x + 1)) { // O(2N)
                    x = x + 1;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}
