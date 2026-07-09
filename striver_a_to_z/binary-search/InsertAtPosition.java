/**
 * Lower bound - Binary Search
 * Time: O(lgn)
 * Space: O(1)
 */
public class InsertAtPosition {

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int idx = nums.length;

        // target will be inserted after its lower bound ele.
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                idx = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return idx;
    }
}
