/**
 * Find Min. from Sorted Rotated Array - extension
 * Time: O(lg n)
 * Space: O(1)
 */
public class FindKthRotation {

    public int findKRotation(int arr[]) {
        int rotatedIdx = 0;
        int min = Integer.MAX_VALUE;
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[low] <= arr[mid]) {
                if (arr[low] < min) {
                    min = arr[low];
                    rotatedIdx = low;
                }
                low = mid + 1;
            } else {
                if (arr[mid] < min) {
                    min = arr[mid];
                    rotatedIdx = mid;
                }
                high = mid - 1;
            }
        }

        return rotatedIdx; // min is rotated from 0 to k pos. -> pos. of min after rotation is effectively (0 + k) [for k < n]
        // k > n need not be handled here as fot k > n, (0 + k) % n will circle back to a k', such that k' < n
    }
}
