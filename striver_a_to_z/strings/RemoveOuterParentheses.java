/**
 * Stack
 * Time: O(N)
 * Space: O(N)
 */
import java.util.Stack;

public class RemoveOuterParentheses {

    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        String res = "", segment = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (!st.isEmpty()) { // not start of new segment
                    segment += '(';
                }

                st.push('(');
            } else { // ch = ')'
                st.pop();

                if (st.isEmpty()) { // segment complete
                    res += segment; // adding segment to result
                    segment = ""; // reset segment
                } else {
                    segment += ')'; // curr. segment contd.
                }
            }
        }

        return res;
    }
}
