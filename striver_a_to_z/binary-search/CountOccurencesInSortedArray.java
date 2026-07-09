/**
 * 1st & last occurence logic
 * Time: O(lgn)
 * Space: O(1)
 */
public class CountOccurencesInSortedArray {

    public int countOccurrences(int[] arr, int target) {
        int startIdx = -1, endIdx = -1;

        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                startIdx = mid;
            }
            if (arr[mid] >= target) {
                right = mid - 1; 
            }else {
                left = mid + 1;
            }
        }

        left = 0;
        right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                endIdx = mid;
            }
            if (arr[mid] <= target) {
                left = mid + 1; 
            }else {
                right = mid - 1;
            }
        }

        int count = startIdx == -1 || endIdx == -1 ? 0 : endIdx - startIdx + 1;
        return count;
    }
}
