/**
 * Increasing - Decreasing curve -> Binary Search
 * Time :O(lg n)
 * Space: O(1)
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int n = nums.length;

        // base case
        if (n == 1) {
            return 0;
        }

        // edge cases
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }

        int low = 1, high = n - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1]) { // mid in increasing curve -> peak is in decreasing curve
                low = mid + 1; // eliminating left half
            } else { // mid in decreasing curve -> peak is in increasing curve; or, mid is in trough [neither inc. nor dec. curve (V-curve)] -> eliminating right half will still retains peaks of left half
                high = mid - 1; // eliminating right half
            }
        }

        return -1;
    }
}
