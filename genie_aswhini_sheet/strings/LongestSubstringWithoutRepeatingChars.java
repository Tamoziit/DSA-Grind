/**
 * Sliding Window + 2-Pointer
 * Time: O(N)
 * Space: O(1)
 */
public class LongestSubstringWithoutRepeatingChars {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), l = 0, r = 0, maxLen = 0;
        int[] hash = new int[257]; // actually 256, 0th idx is dummy

        for (int i = 1; i < 257; i++) {
            hash[i] = -1;
        }

        while (r < n) {
            int idx = hash[s.charAt(r)];
            if (idx != -1) { // character seen previously
                if (idx >= l) { // character within the current window
                    l = idx + 1; // immediate unrepeated character
                }
            }

            maxLen = Math.max(maxLen, (r - l + 1));
            hash[s.charAt(r)] = r; // updating hash to store latest pos.
            r++;
        }

        return maxLen;
    }
}
