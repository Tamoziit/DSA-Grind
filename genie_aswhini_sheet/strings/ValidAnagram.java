/**
 * HashMap Approach
 * Time: O(N)
 * Space: O(N)
 */
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);

            if (!count.containsKey(ch) || count.get(ch) == 0) { // checking for absence of corresponding letter
                return false;
            }

            count.put(ch, count.get(ch) - 1); // decrementing count
        }

        return true;
    }
}
