/**
 * Stack
 * Time: O(N)
 * Space: O(N)
 */
import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int maxLen = 0;
        st.push(-1); // initial

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') { // opening
                st.push(i);
            } else { // closing
                st.pop();
                if (st.isEmpty()) {
                    st.push(i); // next potential valid sequence starts at this idx = i
                } else {
                    int len = i - st.peek(); // curr idx. - stack top
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return maxLen;
    }
}
