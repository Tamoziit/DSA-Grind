/**
 * Next Permutation Algo [Discrete]
 * Time: O(N)
 * Space: O(1)
 */
public class NextPerrmutation {

    public void nextPermutation(int[] nums) {
        int idx = -1;
        int n = nums.length;

        for (int i = n - 2; i >= 0; i--) { // last possible break pt. at (n-2)th idx.
            if (nums[i] < nums[i + 1]) { // break pt. found
                idx = i;
                break;
            }
        }

        if (idx == -1) { // no breakpoint -> reverse original
            reverse(nums, 0, n - 1);
            return;
        }

        // finding min. A in [(i + 1),...,(n - 1)], such that, A > nums[idx]
        for (int i = n - 1; i > idx; i--) {
            if (nums[i] > nums[idx]) {
                int temp = nums[idx]; // swapping
                nums[idx] = nums[i];
                nums[i] = temp;

                break;
            }
        }

        // reversing remaining digits in [(i + 1),...,(n - 1)] which is by nature - already sorted in descending order
        reverse(nums, idx + 1, n - 1);
    }

    private static void reverse(int[] arr, int m, int n) {
        while (m < n) {
            int temp = arr[m];
            arr[m] = arr[n];
            arr[n] = temp;

            m++;
            n--;
        }
    }
}
