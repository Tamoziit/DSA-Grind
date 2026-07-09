/**
 * Binary search in Sorted Rotated Array with unique elements
 * Time: O(lgn)
 * Space: O(1)
 */
public class SearchInRotatedArray1 {

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
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

        return -1;
    }
}
