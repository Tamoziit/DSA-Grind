/**
 * Greedy
 * Time: O(nlgn + mlgm + m)
 * Space: O(1)
 */
import java.util.Arrays;

public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        int n = g.length, m = s.length;
        int l = 0; // curr. cookie
        int r = 0; // curr. child to be satiated

        // to greedily get min. possible s[i], such that: s[i] >= g[i]
        Arrays.sort(g);
        Arrays.sort(s);

        while (l < m && r < n) { // cookie left to be assigned & child is left to be satiated
            if (s[l] >= g[r]) {
                r++; // curr. child satiated -> move to next child
            }

            l++; // try next cookie
        }

        return r; // no. of children who got cookie = curr. idx of g[]
    }
}
