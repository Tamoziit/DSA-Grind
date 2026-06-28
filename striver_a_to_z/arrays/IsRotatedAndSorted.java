
import java.util.Arrays;

public class IsRotatedAndSorted {

    /**
     * Brute Force
     * Time: O(nlgn + n^2)
     * Space: O(n)
     */
    public boolean check_1(int[] nums) {
        int x = 0, n = nums.length;
        int[] rotated = new int[n];
        boolean canBeSorted = true;

        int[] sorted = Arrays.copyOf(nums, n);
        Arrays.sort(sorted);

        while (x < n) {
            canBeSorted = true;

            for (int i = 0; i < n; i++) {
                rotated[i] = sorted[(i + x) % n];

                if (nums[i] != rotated[i]) {
                    canBeSorted = false;
                    break;
                }
            }

            if (canBeSorted == true) {
                return canBeSorted;
            } else {
                x++;
            }
        }

        return canBeSorted;
    }

    /**
     * Inversion Count
     * Time: O(n)
     * Space: O(1)
     */
    public boolean check_2(int[] nums) {
        int inversionCount = 0, n = nums.length;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) { // nums[i] > nums[i + 1] -> inversion count
                inversionCount++;
            }

            if (inversionCount > 1) {
                return false;
            }
        }

        // Also checking between the last and the first element due to rotation
        if (nums[0] < nums[n - 1]) {
            inversionCount++;
        }

        // A valid rotation if inversion count <= 1, i.e, only one inversion allowed --> max ele > min ele. eg: [3,4,5,1,2] --> only 1 valid inversion: 5(max) > 1(min); for all other ele. i > i + 1
        return inversionCount <= 1;
    }
}
