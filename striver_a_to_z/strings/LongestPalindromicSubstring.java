/**
 * Time: O(N^2)
 * Space: O(1)
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        String res = "";
        int maxLen = 0, n = s.length();

        for (int i = 0; i < n; i++) {
            // odd length palindrome
            int l = i, r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > maxLen) {
                    maxLen = r - l + 1;
                    res = s.substring(l, r + 1);
                }

                // expanding out
                l--;
                r++;
            }

            // even length palindrome
            l = i;
            r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > maxLen) {
                    maxLen = r - l + 1;
                    res = s.substring(l, r + 1);
                }

                l--;
                r++;
            }
        }

        return res;
    }
}
