/**
 * Binary Search
 * Time: O(lgn) [floor] + O(lgn) [ceil]
 * space: O(1)
 */
public class FloorAndCeil {

    public int[] getFloorAndCeil(int[] nums, int x) {
        int[] res = {-1, -1};
        int floor = -1, ceil = -1;
        int left = 0, right = nums.length - 1;

        // floor
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= x) {
                floor = nums[mid];
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        left = 0;
        right = nums.length - 1;

        // ceil
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= x) {
                ceil = nums[mid];
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        res[0] = floor;
        res[1] = ceil;

        return res;
    }
}
