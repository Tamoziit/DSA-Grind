/**
 * Recursion - Backtracking
 * Time: O(n · 2ⁿ); total n partitions possible for n-idx & each idx has 2ⁿ leaves (paths)
 * Space: O(n · 2ⁿ) [o/p : res] + O(n) [auxiliary space for each recursion path (reused in each path)]
 */
import java.util.ArrayList;
import java.util.List;

public class PalindromicPartitons {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>(); // partitions lists
        List<String> path = new ArrayList<>(); // to store individual partitions for each recursion path

        findPartitions(0, s, path, res);
        return res;
    }

    private void findPartitions(int idx, String s, List<String> path, List<List<String>> res) {
        // base case
        // end of str -> no more partitions available, so adding the curr. partitions list to result
        if (idx == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                path.add(s.substring(idx, i + 1)); // adding palindromic substring to the curr. partition
                findPartitions(i + 1, s, path, res); // recursive call with next idx partitioning
                path.remove(path.size() - 1); // removing latest added palindromic str. to Backtrack to previous recursion path to find partitions in that path.
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
