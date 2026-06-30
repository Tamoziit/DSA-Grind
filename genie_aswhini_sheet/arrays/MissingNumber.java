
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int sum = 0, n = nums.length;
        int expectedSum = (n * (n + 1)) / 2; // sum of nums in range [0, n]

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        return expectedSum - sum; // missing no.
    }
}
