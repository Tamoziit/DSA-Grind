/**
 * Time: O(N)
 * Space: O(1)
 */
public class StringToATOI {
    public int myAtoi(String s) {
        long num = 0;
        s = s.trim(); // trimming leading spaces
        if (s.isEmpty())
            return 0;

        boolean isNegative = s.charAt(0) == '-'; // handling sign
        int startIdx = (s.charAt(0) == '-' || s.charAt(0) == '+') ? 1 : 0;

        for (int i = startIdx; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!Character.isDigit(ch)) { // 1st non-digit character encountered
                break;
            }

            num = num * 10 + Character.getNumericValue(ch);

            // clamping early to avoid overflow blowing up 'long' too
            if (!isNegative && num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (isNegative && -num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return isNegative ? (int) -num : (int) num;
    }
}
