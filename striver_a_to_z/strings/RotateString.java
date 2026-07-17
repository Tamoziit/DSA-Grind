/**
 * Sliding Window
 * Time: O(N^2) [worst case]
 * Space: O(2N)
 */
public class RotateString {

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        int n = s.length();
        if (n == 0) {
            return true;
        }

        String doubled = s + s; // all possible rotations are contained in this string

        // Sliding window check
        for (int start = 0; start <= doubled.length() - n; start++) {
            boolean match = true;
            for (int j = 0; j < n; j++) {
                if (doubled.charAt(start + j) != goal.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                return true;
            }
        }

        return false;
    }
}
