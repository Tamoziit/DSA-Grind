/**
 * Stack
 * Time: O(N)
 * Space: O(N)
 */
import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParenthesis {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false; // closing bracket with nothing to match
                }

                char top = stack.pop();
                if ((ch == ')' && top != '(')
                        || (ch == ']' && top != '[')
                        || (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
