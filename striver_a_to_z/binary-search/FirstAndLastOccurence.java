/**
 * Time: O(lgn)
 * Space: O(1)
 */
public class FirstAndLastOccurence {

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int startIdx = -1, endIdx = -1;

        // first occurence
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                startIdx = mid;
            }
            if (nums[mid] >= target) {
                right = mid - 1; // keep searching further left
            } else {
                left = mid + 1;
            }
        }

        // last occurence
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                endIdx = mid;
            }
            if (nums[mid] <= target) {
                left = mid + 1; // keep searching further right
            } else {
                right = mid - 1;
            }
        }

        res[0] = startIdx;
        res[1] = endIdx;
        return res;
    }
}
