/**
 * Searching Min. using Bin. Search
 * Time: O(lgn)
 * Space: O(1)
 */
public class MinInRotatedArray {

    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // left half [low...mid] is sorted
            if (nums[low] <= nums[mid]) {
                ans = Math.min(ans, nums[low]); // leftmost of sorted half is smallest there
                low = mid + 1; // discard sorted left half, search right
            } else { // right half [mid...high] is sorted
                ans = Math.min(ans, nums[mid]); // leftmost of sorted half is smallest there
                high = mid - 1; // discard sorted right half, search left
            }
        }

        return ans;
    }
}
