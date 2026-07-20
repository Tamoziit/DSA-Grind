/**
 * Time: O(N)
 * Space: O(1)
 */
public class StringToATOI {

    public int myAtoi(String s) {
        s = s.trim();
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        long res = 0;
        boolean isNegative = s.charAt(0) == '-';
        int i = (s.charAt(0) == '-' || s.charAt(0) == '+') ? 1 : 0;

        while (i < n) {
            char ch = s.charAt(i);
            if (!Character.isDigit(ch)) {
                break;
            }

            res = res * 10 + Character.getNumericValue(ch);

            if (!isNegative && res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (isNegative && res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int) (isNegative ? -res : res);
    }
}
