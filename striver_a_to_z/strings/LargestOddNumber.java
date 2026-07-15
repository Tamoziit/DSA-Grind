/**
 * Time: O(N)
 * Space: O(1)
 */
public class LargestOddNumber {

    public String largestOddNumber(String num) {
        int i;

        for (i = num.length() - 1; i >= 0; i--) {
            int d = Character.getNumericValue(num.charAt(i));
            if (d % 2 != 0) { // odd
                break;
            }
        }

        return num.substring(0, i + 1);
    }
}
