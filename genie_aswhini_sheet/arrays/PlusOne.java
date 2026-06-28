/**
 * Time: O(n)
 * Space: O(n)
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits; // no carry, done immediately
            }

            digits[i] = 0; // was 9, becomes 0, carry continues
        }

        // Only reach here if ALL digits were 9 (e.g. [9,9,9] → [1,0,0,0])
        int[] res = new int[digits.length + 1];
        res[0] = 1;

        return res;
    }
}
