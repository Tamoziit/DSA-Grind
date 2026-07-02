/**
 * 2-Pointer
 * Time: O(m + n)
 * Size: O(m + n)
 */
import java.util.Arrays;

public class UnionArrays {

    public int[] unionArray(int[] nums1, int[] nums2) {
        int i = 0, j = 0, m = nums1.length, n = nums2.length;
        int[] merged = new int[m + n];
        int size = 0;

        while (i < m && j < n) {
            int val;

            if (nums1[i] < nums2[j]) {
                val = nums1[i++];
            } else if (nums2[j] < nums1[i]) {
                val = nums2[j++];
            } else {
                val = nums1[i];
                i++;
                j++;
            }

            if (size == 0 || merged[size - 1] != val) {
                merged[size++] = val;
            }
        }

        while (i < m) {
            int val = nums1[i++];
            if (size == 0 || merged[size - 1] != val) {
                merged[size++] = val;
            }
        }

        while (j < n) {
            int val = nums2[j++];
            if (size == 0 || merged[size - 1] != val) {
                merged[size++] = val;
            }
        }

        return Arrays.copyOf(merged, size);
    }
}
