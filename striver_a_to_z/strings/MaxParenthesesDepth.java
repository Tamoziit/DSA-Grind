
import java.util.Stack;

public class MaxParenthesesDepth {
    /**
     * Stack
     * Time: O(N)
     * Space: O(N)
     */
    public int maxDepth_1(String s) {
        Stack<Character> st = new Stack<>();
        int maxDepth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(c);
                maxDepth = Math.max(maxDepth, st.size());
            } else if (c == ')') {
                st.pop();
            }
        }

        return maxDepth;
    }

    /**
     * Counter
     * Time: O(N)
     * Space: O(1)
     */
    public int maxDepth_2(String s) {
        int count = 0, maxDepth = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if(c == ')') {
                count--;
            }
            
            maxDepth = Math.max(count, maxDepth);
        }

        return maxDepth;
    }
}
