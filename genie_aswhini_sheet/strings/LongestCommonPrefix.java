
import java.util.Arrays;

public class LongestCommonPrefix {
    /**
     * Time: O(n.m), m = min length among the strs
     * Space: O(m)
     */
    public String longestCommonPrefix_1(String[] strs) {
        int min = Integer.MAX_VALUE;
        StringBuilder prefix = new StringBuilder();
        int n = strs.length;

        for (int i = 0; i < n; i++) {
            min = Math.min(min, strs[i].length());
        }

        for (int i = 0; i < min; i++) {
            char ch = strs[0].charAt(i);
            boolean matched = true;

            for (int j = 1; j < n; j++) {
                if (strs[j].charAt(i) != ch) {
                    matched = false;
                    break;
                }
            }

            if (!matched) {
                break;
            }
            prefix.append(ch);
        }

        return prefix.toString();
    }

    /**
     * Sorting -> after sorting lexicographically, the min prefix b/w 1st & last strings is also the common prefix of all intermediate strings
     * This can be viewed as: 1! is contained in 5!, so 1! is also contained in 2!, 3! & 4! for range: [1!, 5!]
     * Time: O(n·log n·m)
     * Space: O(n) [sort] + O(m) [prefix]
     */
    public String longestCommonPrefix_2(String[] v) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(v);
        String first = v[0];
        String last = v[v.length - 1];

        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }

            ans.append(first.charAt(i));
        }

        return ans.toString();
    }
}
