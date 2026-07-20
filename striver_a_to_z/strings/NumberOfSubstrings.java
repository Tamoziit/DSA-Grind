/**
 * Sliding Window with Two Pointer + HashMap
 * Time: O(n)
 * Space: O(1)
 */
import java.util.HashMap;
import java.util.Map;

public class NumberOfSubstrings {

    // Function to count substrings with exactly k distinct characters
    public int countSubstrings(String s, int k) {
        return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
    }

    // Function to count substrings with at most k distinct characters
    private int atMostKDistinct(String s, int k) {
        int left = 0, res = 0;
        Map<Character, Integer> freq = new HashMap<>();

        // Iterating with right pointer
        for (int right = 0; right < s.length(); right++) {
            freq.put(s.charAt(right), freq.getOrDefault(s.charAt(right), 0) + 1);

            // Shrinking window if distinct characters exceed k
            while (freq.size() > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);

                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }

                left++;
            }

            // Adding count of substrings in current window
            res += (right - left + 1);
        }

        return res;
    }
}
