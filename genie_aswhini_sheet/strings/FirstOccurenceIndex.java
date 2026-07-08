/**
 * Time: O(N)
 * Space: O(1)
 */
public class FirstOccurenceIndex {

    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            String s = haystack.substring(i, i + m);

            if (s.equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}
