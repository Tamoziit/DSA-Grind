
public class ValidParenthesis {

    /**
     * Recursion + Backtracking
     * Time: O(3^N)
     * Space: O(N) [auxiliary stack space]
     */
    public boolean checkValidString_1(String s) {
        return getCount(s, 0, 0);
    }

    private boolean getCount(String s, int idx, int count) {
        if (count < 0) {
            return false; // invalid
        }
        if (idx == s.length()) {
            return count == 0; // at the end of string, if count = 0 -> valid
        }

        if (s.charAt(idx) == '(') {
            return getCount(s, idx + 1, count + 1);
        } else if (s.charAt(idx) == ')') {
            return getCount(s, idx + 1, count - 1);
        }

        // for ch = '*': If any one branch is true -> then backtrack whole branch to return true
        return getCount(s, idx + 1, count + 1)
                || // * = '('
                getCount(s, idx + 1, count)
                || // * = ''
                getCount(s, idx + 1, count - 1); // * = ')'
    }

    /**
     * Greedy
     * Time: O(N)
     * Space: O(1)
     */
    public boolean checkValidString_2(String s) {
        int min = 0; // min possible value of count
        int max = 0; // max possible value of count

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                min += 1;
                max += 1;
            } else if (s.charAt(i) == ')') {
                min -= 1;
                max -= 1;
            } else { // ch = '*'
                min -= 1; // min of possible [-1, 0, 1] transforms
                max += 1; // max of possible [-1, 0, 1] transforms
            }

            if (min < 0) {
                min = 0; // ignoring -ve min. since the deficiet can be supplied for, later in the sequence, by the surplus in max. for count in range [min, max]
            }

            if (max < 0) {
                return false; // if max < 0, then max. of count cannot provide for min. of count -> invalid
            }
        }

        return min == 0; // if any of [min, max] range of count = 0 -> valid parenthesis seq.
    }
}
