/**
 * HashMap
 * Time: O(N)
 * Space: O(1) - const. 26 characters which cannot be exceeded for string of any length
 */
import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            if (freq.get(s.charAt(i)) == 1) {
                return i; // returning idx
            }
        }

        return -1;
    }
}
