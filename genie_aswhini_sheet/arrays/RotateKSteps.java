
import java.util.Arrays;

public class RotateKSteps {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // handles k >= n

        int[] cpy = Arrays.copyOf(nums, n);
        for (int i = 0; i < n; i++) {
            nums[i] = cpy[(i - k + n) % n];
        }
    }
}
