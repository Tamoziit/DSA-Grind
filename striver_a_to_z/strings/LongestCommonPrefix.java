/**
 * Sorting -> after sorting lexicographically, the min prefix b/w 1st & last strings is also the common prefix of all intermediate strings
 * This can be viewed as: 1! is contained in 5!, so 1! is also contained in 2!, 3! & 4! for range: [1!, 5!]
 * Time: O(n·log n·m)
 * Space: O(n) [sort] + O(m) [prefix]
 */
import java.util.Arrays;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];

        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }

            ans.append(first.charAt(i));
        }

        return ans.toString();
    }
}
