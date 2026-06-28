
import java.util.Arrays;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int[] cpy = Arrays.copyOf(nums, n);
        int start = 0, end = n - 1;

        for (int i = 0; i < n; i++) {
            if (start <= end) {
                if (cpy[i] == 0) {
                    nums[end] = 0;
                    end--;
                } else {
                    nums[start] = cpy[i];
                    start++;
                }
            }
        }
    }
}
