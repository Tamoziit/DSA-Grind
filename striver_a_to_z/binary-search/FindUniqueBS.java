/**
 * Time: O(lg n)
 * Space: O(1)
 */
public class FindUniqueBS {

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        // base case
        if (n == 1) {
            return nums[0];
        }

        // edge cases
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }

        int low = 1, high = n - 2; // limits after handling edge cases separately
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid]; // unique ele.
            }

            // left half -> ele. in right half
            if ((mid % 2 == 1 && nums[mid] == nums[mid - 1]) || (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                low = mid + 1; // eliminating left half
            } else {
                high = mid - 1; // eliminating right half
            }
        }

        return -1;
    }
}
