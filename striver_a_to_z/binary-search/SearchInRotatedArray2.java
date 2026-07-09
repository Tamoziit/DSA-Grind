/**
 * Binary search in Sorted Rotated Array with repeating elements
 * Time: O(lgn)
 * Space: O(1)
 */
public class SearchInRotatedArray2 {

    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // ambiguous case: can't tell which half is sorted
            // eg: [1, 0, 1] -> nums[low] <= nums[mid] is true, but this half is actually not sorted
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            // checking if left half [low...mid] is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && nums[mid] >= target) {
                    high = mid - 1; // ele. will be in left half [eliminate right half]
                } else {
                    low = mid + 1; // ele. will be in right half [eliminate left half]
                }
            } else { // if left half is not sorted then, right half [mid...high] has to be sorted
                if (nums[mid] <= target && nums[high] >= target) {
                    low = mid + 1; // ele. will be in right half [eliminate left half]
                } else {
                    high = mid - 1; // ele. will be in left half [eliminate right half]
                }
            }
        }

        return false;
    }
}
