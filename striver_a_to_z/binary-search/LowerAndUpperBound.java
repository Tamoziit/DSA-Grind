/**
 * Time: O(lg n)
 * Space: O(1)
 */
public class LowerAndUpperBound {

    public int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int ans = arr.length; // default

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                ans = mid; // record candidate, but keep looking left for even smaller bound
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public int upperBound(int[] arr, int target) {
		int left = 0, right = arr.length - 1;
		int ans = arr.length; // default
		
		while (left <= right) {
			int mid = left + (right - left) / 2;
			
			if (arr[mid] > target) {
				ans = mid;
				right = mid - 1; // keep moving right to find the largest possible upper bound
			} else {
				left = mid + 1;
			}
		}
		
		return ans;
	}
}
